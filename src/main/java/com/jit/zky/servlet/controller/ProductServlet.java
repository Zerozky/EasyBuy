package com.jit.zky.servlet.controller;

import com.alibaba.fastjson.JSON;
import com.jit.zky.entity.*;
import com.jit.zky.service.PcodeService;
import com.jit.zky.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final PcodeService pcodeService = new PcodeService();
    private final int pagesize = 12;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端请求的方法名
        String methodName = req.getParameter("method");
        //根据名称判断调用的方法
        if ("productInfo".equals(methodName)) {
            productInfo(req, resp);
        } else if ("productPage".equals(methodName) || "productListByCid".equals(methodName)) {
            productPage(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端请求的方法名
        String methodName = req.getParameter("method");
        //根据名称判断调用的方法
        if ("indexFloor".equals(methodName)) {
            indexFloor(req, resp);
        } else if ("hotproduct".equals(methodName)) {
            hotproduct(req, resp);
        } else if ("navegationBar".equals(methodName)) {
            navegationBar(req, resp);
        }
    }

    protected void hotproduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        List<FloorVo> hotProducts = productService.findeFloorsHotProducts(0, pagesize);
        String jsonString = JSON.toJSONString(hotProducts);
        resp.getWriter().write(jsonString);
    }

    protected void navegationBar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查找所有类别
        List<Category> cateGorylist = productService.navigationBar();
        String buf = JSON.toJSONString(cateGorylist);
        //设置响应对象的编码方式
        resp.setCharacterEncoding("UTF-8");
        //设置响应对象的内容类型
        resp.setContentType("application/json");
        resp.getWriter().write(buf);
        resp.getWriter().close();
    }

    protected void indexFloor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        List<Pcode> pcodelist = pcodeService.findPcodeListByCodeType("4");
        String jsonString = JSON.toJSONString(pcodelist);
        resp.getWriter().write(jsonString);
    }


    protected void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        String cid = request.getParameter("cid");
        String currentPage = request.getParameter("currentPage");

        //根据商品id查找该商品对象
        ProductService service = new ProductService();
        Product product = service.findProductById(pid);
        request.setAttribute("cid", cid);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("product", product);

        //使用cookie技术保存浏览历史记录
        //1.从cookie中读取是否有名字是pids的值
        String pids = pid;
        //获取所有Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //判断是否是Pids这个cookie
                System.out.println("cookie = " + cookie.getName());
                if ("pids".equals(cookie.getName())) {
                    pids = cookie.getValue();//1,2,3

                    //获取到cookie值后,处理,将字符串转为数组
                    String[] strs = pids.split("&");//{1,2,3}
                    //将数组转换为LinkedList操作更简便,先将数组转成List集合,再转成LinkedList集合
                    List<String> arrList = Arrays.asList(strs);
                    LinkedList<String> list = new LinkedList<>(arrList);
                    list.remove(pid);
                    //无论重不重复都要添加在起始位置
                    list.addFirst(pid);

                    StringBuffer sb = new StringBuffer();
                    //再将集合转为String
                    for (int i = 0; i < list.size() && i < 7; i++) {
                        sb.append(list.get(i));
                        sb.append("&");
                    }

                    pids = sb.substring(0, sb.length() - 1);
                    break;
                }
            }
        }
        //创建Cookie,将新拼接好的pids携带回客户端
        Cookie c = new Cookie("pids", pids);
        response.addCookie(c);
        request.getRequestDispatcher("/product_info.jsp").forward(request, response);
    }

    protected void productPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品类别ID
        String cid = request.getParameter("cid");
        String page = request.getParameter("currentPage");
        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }
        int currentCount = 12;
        ProductService service = new ProductService();
        PageBean<Product> pageBean = service.findProductListByCid(cid, currentPage, currentCount);
        request.setAttribute("cid", cid);
        request.setAttribute("pageBean", pageBean);

        //获取cookie中名字为pids的Cookie值,查询商品集合,放入request域中,返回product_list.jsp页面中展现
        Cookie[] cookies = request.getCookies();
        List<Product> historyList = new ArrayList<Product>();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("pids".equals(c.getName())) {
                    System.out.println("c = " + c.getName());
                    String pids = c.getValue();//获取字符串1,31,33,34
                    System.out.println("pids = " + pids);
                    String[] pids_arr = pids.split("&");
                    System.out.println("pids_arr = " + pids_arr);
                    for (String pid : pids_arr) {
                        //根据id查找商品
                        Product product = service.findProductById(pid);
                        historyList.add(product);
                    }
                }
            }
        }
        System.out.println("historyList = " + historyList);
        request.setAttribute("historyList", historyList);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);

    }

}


