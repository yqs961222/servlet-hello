package com.project.dao;

import com.project.entity.User;

/**
 * DAO 数据操作
 * 与业务操作无关
 *
 * @Author: Jeese Y
 * @Data: 2020-06-21 18:01
 */
public interface UserDao {
    User selectUserByName(String username);
}
