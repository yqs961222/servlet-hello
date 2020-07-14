package com.project.controller;

import com.project.entity.User;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;
import com.project.utils.ResultEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Jesse Y
 * @Data: 2020-06-21 17:30
 */
public class ReqServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ResultEntity<User> result = userService.login(username, password);
        resp.getWriter().println(result);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
