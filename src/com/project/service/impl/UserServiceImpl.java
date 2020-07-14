package com.project.service.impl;

import com.project.dao.UserDao;
import com.project.dao.impl.UserDaoImpl;
import com.project.entity.User;
import com.project.service.UserService;
import com.project.utils.ResultEntity;

/**
 * @Author: Jeese Y
 * @Data: 2020-06-21 19:09
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public ResultEntity<User> login(String username, String password) {
        ResultEntity result = new ResultEntity();
        User user = userDao.selectUserByName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                result.setUser(user);
                result.setMsg("登录成功!");
            } else {
                result.setMsg("账号或密码错误!");
            }

        } else {
            result.setMsg("用户名不存在!");
        }
        return result;

    }
}
