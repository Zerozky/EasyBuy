<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>好易购综合购物商城</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="shortcut icon" href="img/title_logo.ico"/>

</head>

<body>
<div id="index_cont" class="container-fliud">

    <!-- 引入header.jsp -->
    <jsp:include page="/header.jsp"></jsp:include>
    <!-- 轮播图 -->
    <div class="container-fluid">
        <div id="carousel-example-generic" class="carousel slide"
             data-ride="carousel">
            <!-- 轮播图的中的小点 -->
            <ol class="carousel-indicators" id="circular_banner_active">
                <li data-target='#carousel-example-generic' data-slide-to='0'></li>
                <li data-target='#carousel-example-generic' data-slide-to='1'></li>
                <li data-target='#carousel-example-generic' data-slide-to='2'></li>
                <li data-target='#carousel-example-generic' data-slide-to='3'></li>
                <li data-target='#carousel-example-generic' class='active'
                    data-slide-to='4'></li>
            </ol>
            <!-- 轮播图的轮播图片 -->
            <div class="carousel-inner" role="listbox" id="circular_banner_pic">
                <div class='item' style='background: #99cce1'>
                    <img class='img-responsive center-block'
                         src='img/circular_banner/2.jpg'>
                </div>
                <div class='item' style='background: #478FFE'>
                    <img class='img-responsive center-block'
                         src='img/circular_banner/9.jpg'>
                </div>
                <div class='item' style='background: #9D5CFE'>
                    <img class='img-responsive center-block'
                         src='img/circular_banner/3.jpg'>
                </div>
                <div class='item' style='background: #FFFFFF'>
                    <img class='img-responsive center-block'
                         src='img/circular_banner/4.jpg'>
                </div>
                <div class='item active' style='background: #EBEFFB'>
                    <img class='img-responsive center-block'
                         src='img/circular_banner/5.jpg'>
                </div>
            </div>

            <!-- 上一张 下一张按钮 -->
            <a class="left carousel-control" href="#carousel-example-generic"
               role="button" data-slide="prev"> <span
                    class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a> <a class="right carousel-control" href="#carousel-example-generic"
                    role="button" data-slide="next"> <span
                class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
        </div>
    </div>

    <!-- 1F 服饰百货 -->
    <div class="container-fluid">
        <div class="col-md-12">
            <h3>1F服饰百货</h3>
        </div>
        <div class="col-md-3"
             style="hight: 400px; width: 360px; padding: 0px 0px;">
            <img src="img/go_left/1.jpg"
                 style="height: 420px; display: inline-block;"/>
        </div>
        <div class="col-md-8" id="floor1">
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=41&cid=1&currentPage=1"><img
                        src="products/1/400/cs20010.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=41&cid=1&currentPage=1"
                       style="color: #666">草色深深毛衣</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;1469</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=42&cid=1&currentPage=1"><img
                        src="products/1/400/cs10010.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=42&cid=1&currentPage=1"
                       style="color: #666">粉红女郎</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;2699</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=94&cid=1&currentPage=1"><img
                        src="products/1/400/cs20001.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=94&cid=1&currentPage=1"
                       style="color: #666">时尚服装线衣披风</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;1299</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=95&cid=1&currentPage=1"><img
                        src="products/1/400/cs20002.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=95&cid=1&currentPage=1"
                       style="color: #666">时尚服装秋季风衣</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;2599</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=98&cid=1&currentPage=1"><img
                        src="products/1/400/cs20005.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=98&cid=1&currentPage=1"
                       style="color: #666">时尚服装大红方格外套</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;4288</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=99&cid=1&currentPage=1"><img
                        src="products/1/400/cs20006.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=99&cid=1&currentPage=1"
                       style="color: #666">时尚服装粉色毛衣</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;1469</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=100&cid=1&currentPage=1"><img
                        src="products/1/400/cs20007.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=100&cid=1&currentPage=1"
                       style="color: #666">时尚服装印花小鹿</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;2699</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=102&cid=1&currentPage=1"><img
                        src="products/1/400/cs20009.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=102&cid=1&currentPage=1"
                       style="color: #666">时尚服装sonim 摆裙</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;1699</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=103&cid=1&currentPage=1"><img
                        src="products/1/400/cs20007.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=103&cid=1&currentPage=1"
                       style="color: #666">时尚服装努比亚精英</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;3888</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=31&cid=1&currentPage=1"><img
                        src="products/1/400/cs10001.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=31&cid=1&currentPage=1"
                       style="color: #666">线衣披风</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;1299</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=32&cid=1&currentPage=1"><img
                        src="products/1/400/cs10002.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=32&cid=1&currentPage=1"
                       style="color: #666">秋季风衣</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;2599</font>
                </p>
            </div>
            <div class="col-md-2"
                 style="text-align: center; height: 200px; padding: 10px 0px;">
                <a
                        href="/ngshop/product?method=productInfo&pid=37&cid=1&currentPage=1"><img
                        src="products/1/400/cs10005.jpg"
                        style="display: inline-block; width: 150px; height: 150px;"></a>
                <p
                        style="height: 22px; width: 170px; overflow: hidden; text-align: center; margin: auto;">
                    <a href="product?method=productInfo&pid=37&cid=1&currentPage=1"
                       style="color: #666">大红方格外套</a>
                </p>
                <p>
                    <font color="#E4393C" style="font-size: 16px">&yen;4288</font>
                </p>
            </div>
        </div>
        <div class="col-md-1" style="hight: 400px; padding: 0px 0px;">
            <img src="img/go_right/1.jpg"
                 style="height: 420px; width: 190px; display: inline-block;"/>
        </div>
    </div>
    <!-- 分割条 -->
    <div class="container-fluid"
         style="background: #b6232b; height: 10px;"></div>
</div>


<script type="text/javascript">
    $(function () {
        //加载楼层信息
        function floor_load() {
            $.post("${pageContext.request.contextPath}/indexFloor",
                function (data) {
                    var index_cont = ''
                    for (var i = 0; i < data.length; i++) {
                        var pcode = data[i]
                        index_cont += '<div class="container-fluid">';
                        index_cont += '<div class="col-md-12"><h3>' + pcode.param1 + '</h3></div>';
                        index_cont += '<div class="col-md-3" style="hight: 400px; width: 360px; padding: 0px 0px;"> <img src="' + pcode.param3 + '" style="height: 420px; display: inline-block;" /></div>';
                        index_cont += '<div class="col-md-8" id="' + pcode.param7 + '"></div>';
                        index_cont += '<div class="col-md-1" style="hight: 400px; padding: 0px 0px;"> <img src="' + pcode.param5 + '" style="height: 420px; width: 190px; display: inline-block;" /></div>';
                        index_cont += '</div>';
                    }
                    $("#index_cont").append(index_cont);
                }, "json");
        }

        floor_load();
    });
</script>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
    //加载热门商品列表
    function hot_product_load() {
        $.post("${pageContext.request.contextPath}/hotproduct",
            function (datas) {
                for (var index = 0; index < datas.length; index++) {
                    var data = datas[index]
                    var floorNo = data.floorNo;//获取楼层
                    var hotProducts = data.hotProducts;//获取楼层对应的数据
                    if (hotProducts.length > 0) {
                        var hotProduct = '';
                        for (var i = 0; i < hotProducts.length; i++) {
                            product = hotProducts[i];
                            hotProduct += '<div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">';
                            hotProduct += '<a href="${pageContext.request.contextPath}/product?method=productInfo&pid=' + product.pid + '&cid=' + product.cid + '&currentPage=1"><img src="' + product.pimage + '" style="display: inline-block;width:150px;height:150px;"></a>';
                            hotProduct += '<p style="height: 22px; width: 170px; overflow: hidden;text-align: center;margin: auto;">';
                            hotProduct += '<a href="product?method=productInfo&pid=' + product.pid + '&cid=' + product.cid + '&currentPage=1" style="color: #666">' + product.pname + '</a></p><p>';
                            hotProduct += '<font color="#E4393C" style="font-size: 16px">&yen;' + product.shop_price + '</font></p></div>';
                        }
                        //console.log(hotProduct);
                        var floorObj = document.getElementById(floorNo);
                        var $floorObj = $(floorObj);
                        //console.log($floorObj);
                        $floorObj.append(hotProduct);
                    }
                }
            }, "json");
    }
</script>

<!-- 引入footer.jsp -->
<div class="container-fliud">
    <jsp:include page="/footer.jsp"></jsp:include>
</div>
</body>
</html>