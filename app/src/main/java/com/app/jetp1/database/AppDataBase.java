package com.app.jetp1.database;


import android.util.Log;

import com.app.jetp1.entity.Dept;
import com.app.jetp1.entity.User;
import com.app.jetp1.dao.DeptDao;
import com.app.jetp1.dao.UserDao;
import com.app.jetp1.utlis.ContextProvider;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * @author:create by ys
 * 时间:2021/5/14 10
 * 邮箱 894417048@qq.com
 */

@Database(entities = {User.class, Dept.class},version = 3,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase{

    public static AppDataBase instance;

    private static final String dataName = "roomTest";

    public abstract UserDao getUserDao();
    public abstract DeptDao getDeptDao();

    public static AppDataBase getInstance(){
        if (instance == null){
            instance = createData();
        }
        return instance;
    }

    /**
     * 创建数据库
     * @return
     */
    private static AppDataBase createData(){
        return Room.databaseBuilder(ContextProvider.getInstance().getContext(),AppDataBase.class,dataName+".db").addCallback(new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                Log.d("AppDataBase", "oncreat");
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
                Log.d("AppDataBase", "onOpen");
            }
        }).addMigrations(MIGRATION_2_3).allowMainThreadQueries().build(); //MIGRATION_2_3  根据version 判断
    }

    /**
     * 更新  删除字段 1 ----> 2
     */
    private static Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

            //没有直接删除表一列的方法 所以需要 复制表 然后删除
            database.execSQL("CREATE TABLE userTemp" + "(id INTEGER "+ " PRIMARY KEY NOT NULL," + " username TEXT,"+" password TEXT)");
            //复制数据
            database.execSQL("insert into userTemp(id,username,password) select id,username,password from user");
            //删除原表
            database.execSQL("drop table user");
            //修改附表表名字
            database.execSQL("alter table userTemp rename to user");
        }
    };

    /**
     * 更新 新增字段  2 ----> 3
     */
    private static Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //修改附表表名字
            database.execSQL("alter table user "+" add column age INTEGER NOT NULL DEFAULT 1");
        }
    };


}
