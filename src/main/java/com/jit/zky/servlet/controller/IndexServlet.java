package com.jit.zky.servlet.controller;

import com.alibaba.fastjson.JSON;
import com.jit.zky.entity.Pcode;
import com.jit.zky.service.PcodeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 加载楼层信息
 *
 * @author 86159
 * @ClassName IndexServlet
 * @date 2022年11月14日 上午4:08:40
 */
@WebServlet("/indexFloor")
public class IndexServlet extends HttpServlet {
    private PcodeService service = new PcodeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        List<Pcode> pcodelist = service.findPcodeListByCodeType("4");
        String jsonString = JSON.toJSONString(pcodelist);
        resp.getWriter().write(jsonString);
    }
}
