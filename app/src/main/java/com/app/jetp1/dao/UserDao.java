package com.app.jetp1.dao;

import com.app.jetp1.bo.UserBo;
import com.app.jetp1.entity.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

/**
 * @author:create by ys
 * 时间:2021/5/14 10
 * 邮箱 894417048@qq.com
 */
@Dao
public interface UserDao extends BaseDao<User> {

    @Query("select u.username as name,u.password as pawd ,u.id as id,u.age as age,d.name as deptName from user u ,dept d where u.did = d.id and u.username = (:username) and u.password = (:password)")
    UserBo getUser(String username, String password);

    @Query("select u.username as name,u.password as pawd ,u.id as id,u.age as age,d.name as deptName from user u ,dept d where u.did = d.id")
    List<UserBo> getUsers();

    @Query("delete from user")
    void deleteAll();
}
