package com.jit.zky.servlet.controller;

import com.jit.zky.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import com.jit.zky.user.User;
import com.jit.zky.utils.CommonUtil;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/register")
public class RegistServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> properties = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setUid(CommonUtil.generateUUID());
        service.regist(user);
        resp.sendRedirect("login.jsp");

//        String UserName = req.getParameter("username");
//        System.out.println("UserName->" + UserName);
//        String Password = req.getParameter("password");
//        System.out.println("Password->" + Password);
    }
}
