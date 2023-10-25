package com.jit.zky.service;

import com.jit.zky.dao.UserDao;
import com.jit.zky.user.User;

import java.sql.SQLException;

public class UserService {
    public boolean regist(User user) {
        int row = 0;
        UserDao dao = new UserDao();
        try {
            row = dao.regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

}
