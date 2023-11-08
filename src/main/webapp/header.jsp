<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" type="text/css" href="css/index.css"/>

<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container" id="search">
    <div class="col-md-5" style="padding:0px 0px;">
        <a href="#"><img src="img/mylogos.png"/></a>
        <a href="#"><img src="img/logo.gif" alt=""/></a>
    </div>
    <div class="col-md-7">
        <div class="main_search">
            <div class="ng_search">
                <i class="ng-iconfont search-icon">&#xe619;</i>
                <form action="">
                    <div class="search-keyword-box">
                        <input value="iPhone6s最大的不同就是处处相同" id="searchKeywords" type="text"
                               class="search-keyword"/>
                    </div>
                    <input id="searchSubmit" type="submit" class="search-btn" value="搜索"/>
                    <div class="hotwords">
                        <a href="####">PPTV互联网电视</a>
                        <a href="####">三星note5</a>
                        <a href="####">奶粉</a>
                        <a href="####">烤箱</a>
                        <a href="####">智能电视</a>
                        <a href="####">面膜</a>
                        <a href="####">奥克斯空调</a>
                        <a href="####">大闸蟹</a>
                        <a href="####" style="color: #FF6600;">香港莎莎</a>
                        <a href="####">佳能70d</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="col-md-9">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed"
                            data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                            aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span> <span
                            class="icon-bar"></span> <span class="icon-bar"></span> <span
                            class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">首页</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id="categoryList" class="nav navbar-nav">
<%--                        <li><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>--%>
<%--                        <li><a href="#">电脑办公</a></li>--%>
<%--                        <li><a href="#">电脑办公</a></li>--%>
<%--                        <li><a href="#">电脑办公</a></li>--%>
                    </ul>
                </div>
            </div>
            <div class="col-md-3" style="padding:15px 0px; height:50px;">
                <ol class="list-inline">
                    <li>亲爱的<span style="margin:0px 5px; font-size:16px; color:#093; font-weight:bold; "></span>你好！
                    </li>
                    <li><a href="#">退出</a></li>
                    <li><a href="#" style="color:red;">亲，请登录</a></li>
                    <li><a href="register.jsp">免费注册</a></li>
                    <li><a href="#">购物车</a></li>
                    <li><a href="">我的订单</a></li>
                </ol>
            </div>
        </div>
    </nav>
</div>
<script type="text/javascript">
    $(function () {
        $.post("${pageContext.request.contextPath}/navegationBar", function (data) {
            var navbar = []
            for (var i = 0; i < data.length; i++) {
                var category = data[i]
                navbar.push('<li id="nvabar' + data[i].cid + '"><a href= "${pageContext.request.contextPath}/productPage?cid=' + data[i].cid + '"> ' + category.cname + '</a></li>')
            }
            $('#categoryList').append(navbar.join(""))
            setCurrentBar()
        }, "json")

        //设置当前页签样式
        function setCurrentBar() {
            var cid = '${param.cid}'
            if (cid != '') {
                $('#nvabar' + cid).children().css({'font-weight': 'bold', 'color': '#333'})
            } else {
                $('.navbar-brand').css({'font-weight': 'bold', 'color': '#333'})
            }
        }
    })
</script>

