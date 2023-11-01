package com.jit.zky.servlet.controller;

import com.jit.zky.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/active")
public class ActiveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //进行激活操作
        String activeCode = request.getParameter("activeCode");
        UserService service = new UserService();
        service.active(activeCode);
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
