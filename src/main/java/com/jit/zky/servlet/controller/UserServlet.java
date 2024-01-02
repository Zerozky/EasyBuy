package com.jit.zky.servlet.controller;

import com.jit.zky.entity.User;
import com.jit.zky.service.UserService;
import com.jit.zky.utils.CommonUtil;
import com.jit.zky.utils.MailUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    private boolean isSuccess = false;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String methodName = req.getParameter("method");
        if ("register".equals(methodName)) {
            register(req, resp);
        } else if ("checkUsername".equals(methodName)) {
            checkUsername(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String methodName = req.getParameter("method");
        if ("checkUsername".equals(methodName)) {
            checkUsername(req, resp);
        } else if ("active".equals(methodName)) {
            active(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Map<String, String[]> properties = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setUid(CommonUtil.generateUUID());
        user.setCode(CommonUtil.generateUUID());
        if (userService.regist(user)) {
            isSuccess = true;
        }

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
    }

    protected void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String username = req.getParameter("username");
        //service验证是否存在
        UserService service = new UserService();
        boolean isExist = service.checkUsername(username);
        String json = "{\"isExist\":" + isExist + "}";//不要写成"{‘isExist‘:"+isExist+"}"
        resp.getWriter().write(json);

    }

    protected void active(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进行激活操作
        String activeCode = req.getParameter("activeCode");
        UserService service = new UserService();
        service.active(activeCode);
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
