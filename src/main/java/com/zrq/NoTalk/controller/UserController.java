package com.zrq.NoTalk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrq.NoTalk.entity.User;
import com.zrq.NoTalk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> queryUser() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @PostMapping("/register")
    public int register(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        queryWrapper.allEq(map);
        List<User> users = userMapper.selectList(queryWrapper);
        if (users.size() > 0) return -1;
        int insert = userMapper.insert(user);
        if (insert <= 0) return -1;
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("username", user.getUsername());
        int id = userMapper.selectOne(queryWrapper2).getId();
        return id;
    }

    @GetMapping("/login")
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        queryWrapper.allEq(map);
        User u = userMapper.selectOne(queryWrapper);
        return u;
    }

}
