package com.project.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类,负责数据库连接对象和数据库资源关闭
 *
 * 使用Druid连接池, 连接数据库
 * 是JdbcUtil的优化版
 *
 * @Author: Jeese Y
 * @Data: 2020-06-12-21:53
 */
public class JdbcUtils {
    // 数据库资源
    private static DataSource ds;

    static {
        try {
            // 加载Properties文件
            Properties ppt = new Properties();
            ppt.load(new FileInputStream("./src/db.properties"));

            // 已经完成数据库连接池操作
            ds = DruidDataSourceFactory.createDataSource(ppt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 返回数据库连接对象,连接失败返回null
     *
     * @return Java.sql.Connection 数据库连接对象
     */
    public static Connection getConnection() {
        Connection con = null;

        try {
            con = ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }

    /*
    以下三个代码实际上都是执行同一个方法,使用这种方式
        1. 简化代码结构
        2. 规范化所有的操作
     */
    /**
     * 处理数据库操作对应的资源问题
     *
     * @param con java.sql.Connection 数据库连接对象
     */
    public static void close(Connection con) {
        close(con, null, null);
    }

    /**
     * 处理数据库操作对应的资源问题
     *
     * @param con java.sql.Connection 数据库连接对象
     * @param stm java.sql.Statement 数据库SQL语句搬运工对象
     */
    public static void close(Connection con, Statement stm) {
        close(con, stm, null);
    }

    /**
     * 处理数据库操作对应的资源问题
     *
     * @param con java.sql.Connection 数据库连接对象
     * @param stm java.sql.Statement 数据库SQL语句搬运工对象
     * @param rs java.sql.ResultSet 数据库查询结果集对象
     */
    public static void close(Connection con, Statement stm, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
