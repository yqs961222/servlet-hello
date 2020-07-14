package com.project.service;

import com.project.entity.User;
import com.project.utils.ResultEntity;

/**
 * 业务层
 * 与业务相关的都在这里
 *
 * @Author: Jeese Y
 * @Data: 2020-06-21 19:06
 */
public interface UserService {
    /**
     * 与业务相关的登录
     * @return
     */
    ResultEntity<User> login(String username, String password);
}
