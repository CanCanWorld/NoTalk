package com.zrq.NoTalk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrq.NoTalk.entity.Note;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteMapper extends BaseMapper<Note> {
}
