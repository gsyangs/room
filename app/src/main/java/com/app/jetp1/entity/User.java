package com.app.jetp1.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author:create by ys
 * 时间:2021/5/14 10
 * 邮箱 894417048@qq.com
 */
//设置外键
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String username;
    @ColumnInfo
    private String password;
    @ColumnInfo
    private int age;
    @ColumnInfo
    private int did;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
