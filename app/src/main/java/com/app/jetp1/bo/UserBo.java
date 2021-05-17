package com.app.jetp1.bo;

/**
 * @author:create by ys
 * 时间:2021/5/17 15
 * 邮箱 894417048@qq.com
 */
public class UserBo {

    private int id;
    private String name;
    private String pawd;
    private int age;
    private String deptName;

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

    public String getPawd() {
        return pawd;
    }

    public void setPawd(String pawd) {
        this.pawd = pawd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
