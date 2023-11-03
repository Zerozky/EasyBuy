package com.jit.zky.dao;

import com.jit.zky.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import com.jit.zky.utils.DataSourceUtil;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDao {
    public int regist(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";

        int row = runner.update(sql, user.getUid(), user.getUsername(), user.getPassword(),
                user.getName(), user.getEmail(), user.getTelephone(), user.getBirthday(),
                user.getSex(), user.getState(), user.getCode());
        return row;
    }

    public void active(String activeCode) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
        String sql = "update user set state = 1 where code = ? ";
        runner.update(sql, activeCode);
    }

    public Long checkUsername(String username) throws SQLException {
        QueryRunner runner =  new QueryRunner(DataSourceUtil.getDataSource());
        String sql ="select count(*) from user where username = ?" ;
        Long count = (Long)runner.query(sql, new ScalarHandler(), username);
        return count;
    }


}
