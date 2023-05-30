package com.zrq.NoTalk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrq.NoTalk.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
