package com.zrq.NoTalk.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_note")
public class Note {
    private int id;
    private String time;
    private String content;
    private int uid;
    @TableField(exist = false)
    private User user;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
