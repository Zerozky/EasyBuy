package com.jit.zky.service;

import com.jit.zky.dao.UserDao;
import com.jit.zky.entity.User;

import java.sql.SQLException;

public class UserService {
    private UserDao dao = new UserDao();
    public boolean regist(User user) {
        int row = 0;
        try {
            row = dao.regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public void active(String activeCode) {
        try {
            dao.active(activeCode);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean checkUsername(String username) {
        //调用dao判断是否存在
        Long count = 0L;
        try {
            count = dao.checkUsername(username);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count > 0 ? true : false;
    }

}
