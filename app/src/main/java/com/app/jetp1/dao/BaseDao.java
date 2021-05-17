package com.app.jetp1.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

/**
 * @author:create by ys
 * 时间:2021/5/14 10
 * 邮箱 894417048@qq.com
 */
@Dao
public interface BaseDao<T> {

    /**
     * OnConflictStrategy.REPLACE：取代旧数据同时继续事务。
     * OnConflictStrategy.ROLLBACK：回滚事务。
     * OnConflictStrategy.ABORT：终止事务。
     * OnConflictStrategy.FAIL：事务失败。
     * OnConflictStrategy.IGNORE：忽略冲突。
     * @param t
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(T t);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItems(List<T> items);

    @Delete
    void delete(T t);

    @Delete
    void deleteItems(List<T> items);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(T t);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateItems(List<T> items);

}
