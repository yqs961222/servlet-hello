package com.project.dao.impl;

import com.project.dao.UserDao;
import com.project.entity.User;
import com.project.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Jeese Y
 * @Data: 2020-06-21 19:10
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User selectUserByName(String username) {
       /* QueryRunner qr = new QueryRunner();
        //language=MySQL
        String sql = "select * from user where username=?";

        Connection con = JdbcUtils.getConnection();

        User user = null;
        try {
            user = qr.query(con, sql, new BeanHandler<>(User.class), username);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JdbcUtils.close(con);
        return user;*/



        User user = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {


            con = JdbcUtils.getConnection();
            //language=MySQL
            String sql = "select * from user where username=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                int uid = rs.getInt("uid");
//                String username1 = rs.getString("username");
                String password = rs.getString("password");
//                int isDel = rs.getInt("is_del");
                user = new User(username, password, uid);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return user;

    }
}
