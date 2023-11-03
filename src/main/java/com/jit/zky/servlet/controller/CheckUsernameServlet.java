package com.jit.zky.servlet.controller;

import com.jit.zky.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkUsername")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String username = request.getParameter("username");
        //service验证是否存在
        UserService service = new UserService();
        boolean isExist = service.checkUsername(username);
        String json = "{\"isExist\":"+isExist+"}";//不要写成"{‘isExist‘:"+isExist+"}"
        response.getWriter().write(json);
    }
}
