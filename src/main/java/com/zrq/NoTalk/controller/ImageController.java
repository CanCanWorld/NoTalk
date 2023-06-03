package com.zrq.NoTalk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrq.NoTalk.entity.Image;
import com.zrq.NoTalk.entity.User;
import com.zrq.NoTalk.mapper.ImageMapper;
import com.zrq.NoTalk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ImageMapper imageMapper;

        private static final String UPLOADED_FOLDER = System.getProperty("user.dir") + "/img/";
//    private static final String UPLOADED_FOLDER = "D:/img/img/";

    @PostMapping("img")
    public Boolean uploadImage(Image image, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("Size:" + file.getSize());
        String originalFilename = file.getOriginalFilename();
        System.out.println("OriginalFilename:" + originalFilename);
        System.out.println("Name:" + file.getName());
        String name = image.getName();
        final String path = request.getServletContext().getRealPath("/img/");

        if (originalFilename != null) {
            int indexOf = originalFilename.lastIndexOf(".");
            String substring = originalFilename.substring(indexOf);
            name = name + substring;
        }
        saveFile(path ,name, file);
        int insert = imageMapper.insert(image);
        return insert > 0;
    }

    @GetMapping("img")
    public List<Image> getImages() {
        List<Image> images = imageMapper.selectList(null);
        for (Image image : images) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", image.getUid());
            User user = userMapper.selectOne(queryWrapper);
            image.setUser(user);
        }
        return images;
    }

    private void saveFile(String path , String name, MultipartFile file) throws IOException {
        final File dir = new File(path);
        System.out.println(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        final File newFile = new File(path + name);
        file.transferTo(newFile);
    }

}
