package com.app.jetp1.entity;

/**
 * @author:create by ys
 * 时间:2021/5/14 10
 * 邮箱 894417048@qq.com
 */

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dept {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
