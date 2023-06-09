package com.zrq.NoTalk.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_img")
public class Image {

    private int id;
    private int uid;
    private String time;
    private String path;
    private String title;
    @TableField(exist = false)
    private User user;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", uid=" + uid +
                ", time='" + time + '\'' +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
