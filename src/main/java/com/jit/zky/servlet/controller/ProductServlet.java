package com.jit.zky.servlet.controller;

import com.alibaba.fastjson.JSON;
import com.jit.zky.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 获取各楼层热门商品信息
 *
 * @author 86159清风明月
 * @ClassName ProductServlet
 * @date 2022年11月14日 上午4:52:02
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private ProductService service = new ProductService();
    private int pagesize = 12;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductService.FloorVo> hotProducts = service.findeFloorsHotProducts(0, pagesize);
        String jsonString = JSON.toJSONString(hotProducts);
        resp.getWriter().write(jsonString);
    }
}


