package com.app.jetp1.ui;

import android.text.Html;
import android.view.View;
import android.widget.EditText;

import com.app.jetp1.R;
import com.app.jetp1.base.BaseActivity;
import com.app.jetp1.bo.UserBo;
import com.app.jetp1.entity.Dept;
import com.app.jetp1.entity.User;
import com.app.jetp1.dao.DeptDao;
import com.app.jetp1.dao.UserDao;
import com.app.jetp1.database.AppDataBase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text)
    EditText text;
    private UserDao userDao;
    private DeptDao deptDao;
    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        initData();
    }

    private void initData(){
        userDao = AppDataBase.getInstance().getUserDao();
        deptDao = AppDataBase.getInstance().getDeptDao();
    }

    @OnClick({R.id.add,R.id.delete,R.id.update,R.id.select,R.id.select_items,R.id.dept})
    public void onClickView(View v){
        switch (v.getId()){
            case R.id.add:
                addUser();
                break;
            case R.id.delete:
//                deleteUser();
                userDao.deleteAll();
                break;
            case R.id.update:
                update();
                break;
            case R.id.select:
                UserBo ub = userDao.getUser("ys","123");
                text.setText("ID:" + ub.getId() +  "  名："+ ub.getName() + "   密：" + ub.getPawd() + " 年：" +ub.getAge()+ "  部门：" + ub.getDeptName() );
                break;
            case R.id.select_items:
                List<UserBo> users = userDao.getUsers();
                StringBuffer str = new StringBuffer();
                for (UserBo ub1 : users){
                    str.append(Html.fromHtml("ID:" + ub1.getId() +  "      名："+ ub1.getName() + "   密：" + ub1.getPawd() + " 年：" +ub1.getAge() + "  部门：" + ub1.getDeptName() + "<br>"));
                }
                text.setText(str.toString());
                break;
            case R.id.dept:
                Dept dept = new Dept();
                dept.setName("IT");
                Dept dept1 = new Dept();
                dept1.setName("设计");
                Dept dept2 = new Dept();
                dept2.setName("客服");
                List<Dept> depts =new ArrayList<>();
                depts.add(dept);
                depts.add(dept1);
                depts.add(dept2);
                deptDao.insertItems(depts);
                break;
        }
    }

    /**
     * add
     */
    private void addUser(){
        User u1 = new User();
        u1.setUsername("ys");
        u1.setPassword("123");
        u1.setDid(1);
        u1.setAge(12);

        User u2 = new User();
        u2.setUsername("gs");
        u2.setPassword("123");
        u2.setDid(2);
        u2.setAge(9);

        User u3 = new User();
        u3.setUsername("yj");
        u3.setPassword("123");
        u3.setDid(1);
        u3.setAge(9);

        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        userDao.insertItems(users);
    }

    /**
     * delete
     */
    private void deleteUser(){
        User u1 = new User();
        u1.setId(1);
        u1.setUsername("ys");
        u1.setPassword("123");
        userDao.delete(u1);
    }

    /**
     * update
     */
    private void update(){
        User u1 = new User();
        u1.setId(2);
        u1.setUsername("高爽");
        u1.setPassword("123");
        u1.setAge(15);
        u1.setDid(2);
        userDao.update(u1);
    }
}