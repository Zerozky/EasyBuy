package com.jit.zky.servlet.controller;

import com.jit.zky.service.UserService;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import com.jit.zky.entity.User;
import com.jit.zky.utils.CommonUtil;
import com.jit.zky.utils.MailUtil;
import org.apache.commons.beanutils.BeanUtils;


@WebServlet("/register")
public class RegistServlet extends HttpServlet {
    private UserService service = new UserService();
    private boolean isSuccess = false;

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
        user.setCode(CommonUtil.generateUUID());
        if (service.regist(user)) {
            isSuccess = true;
        }
//        resp.sendRedirect("login.jsp");

        if (isSuccess)//注册成功
        {
            int port = req.getLocalPort();
            String contextPath = req.getContextPath();
            String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
                    + "<a href='http://localhost:" + port + contextPath + "/active?activeCode=" + user.getCode() + "'>"
                    + "http://localhost:8080/IGeekShop/active?activeCode=" + user.getCode() + "</a>";
            //发送激活邮件
            try {
                MailUtil.sendMail(user.getEmail(), emailMsg);
            } catch (AddressException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (MessagingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp");


//        String UserName = req.getParameter("username");
//        System.out.println("UserName->" + UserName);
//        String Password = req.getParameter("password");
//        System.out.println("Password->" + Password);
    }
}
