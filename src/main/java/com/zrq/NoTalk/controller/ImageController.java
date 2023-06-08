package com.zrq.NoTalk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrq.NoTalk.entity.Image;
import com.zrq.NoTalk.entity.User;
import com.zrq.NoTalk.mapper.ImgMapper;
import com.zrq.NoTalk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ImgMapper imageMapper;

    private static final String UPLOADED_FOLDER = "http://8.140.61.64:9999/img/";

    @Value("${file-save-path}")
    private String basePath;

    @PostMapping("img")
    public Boolean uploadImage(Image image, MultipartFile file, HttpServletRequest request) throws IOException {
        String originalFilename = file.getOriginalFilename();
//        final String basePath = request.getServletContext().getRealPath("/img/");
        System.out.println(basePath);
        String filePath = basePath + image.getUid() + "_" + image.getTime();
        String path = UPLOADED_FOLDER + image.getUid() + "_" + image.getTime();

        if (originalFilename != null) {
            int indexOf = originalFilename.lastIndexOf(".");
            String substring = originalFilename.substring(indexOf);
            path = path + substring;
            filePath = filePath + substring;
        }
        image.setPath(path);
        saveFile(basePath, filePath, file);
        int insert = imageMapper.insert(image);
        return insert > 0;
    }

    @GetMapping("img")
    public List<Image> getImages() {
        List<Image> images = imageMapper.selectList(null);
        for (Image image : images) {
            System.out.println(image);
        }
        for (Image image : images) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", image.getUid());
            User user = userMapper.selectOne(queryWrapper);
            image.setUser(user);
        }
        return images;
    }

    private void saveFile(String basePath, String filePath, MultipartFile file) throws IOException {
        final File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        final File newFile = new File(filePath);
        file.transferTo(newFile);
    }

}
