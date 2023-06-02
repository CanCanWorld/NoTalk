package com.zrq.NoTalk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrq.NoTalk.entity.Note;
import com.zrq.NoTalk.entity.User;
import com.zrq.NoTalk.mapper.NoteMapper;
import com.zrq.NoTalk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NoteMapper noteMapper;

    @GetMapping("/note")
    public List<Note> queryNote() {
        List<Note> notes = noteMapper.selectList(null);
        for (Note note : notes) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", note.getUid());
            User user = userMapper.selectOne(queryWrapper);
            note.setUser(user);
        }
        return notes;
    }

    @PostMapping("/note")
    public boolean addNote(Note note) {
        int insert = noteMapper.insert(note);
        return insert > 0;
    }

}
