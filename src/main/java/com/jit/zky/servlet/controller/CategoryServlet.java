package com.jit.zky.servlet.controller;

import com.alibaba.fastjson.JSON;
import com.jit.zky.entity.Category;
import com.jit.zky.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/navegationBar")
public class CategoryServlet extends HttpServlet {

    ProductService service = new ProductService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查找所有类别
        List<Category> cateGorylist = service.navigationBar();
        String buf = JSON.toJSONString(cateGorylist);
        //设置响应对象的编码方式
        resp.setCharacterEncoding("UTF-8");
        //设置响应对象的内容类型
        resp.setContentType("application/json");
        resp.getWriter().write(buf);
        resp.getWriter().close();
    }
}
