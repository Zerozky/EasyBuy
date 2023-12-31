<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link href="css/style_new.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link rel="shortcut icon" href="img/title_logo.ico" />
</head>
<body>
<div class="container">
	<div class="col-md-6" style="text-align:left;">
		<a href="${pageContext.request.contextPath }"><img src="img/mylogos.png" /></a>
	</div>
	<div class="col-md-6" style="text-align:right;">
		<a href="#" ><img src="img/logo.gif"/></a>
	</div>
</div>

<div class="wrap">

	<div class="banner-show" id="js_ban_content">
		<div class="cell bns-01">
			<div class="con">
			</div>
		</div>
		<div class="cell bns-02" style="display:none;">
			<div class="con">
				<a href="javascript:void(0);" target="_blank" class="banner-link">
				<i>圈子</i></a> </div>
		</div>
		<div class="cell bns-03" style="display:none;">
			<div class="con">
				<a href="javascript:void(0);" target="_blank" class="banner-link">
				<i>企业云</i></a> </div>
		</div>
	</div>
	<div class="banner-control" id="js_ban_button_box">
		<a href="javascript:;" class="left">左</a>
		<a href="javascript:;" class="right">右</a>
	</div>
<script type="text/javascript">
;(function(){
	
	var defaultInd = 0;
	var list = $('#js_ban_content').children();
	var count = 0;
	var change = function(newInd, callback){
		if(count) return;
		count = 2;
		$(list[defaultInd]).fadeOut(400, function(){
			count--;
			if(count <= 0){
				if(start.timer) window.clearTimeout(start.timer);
				callback && callback();
			}
		});
		$(list[newInd]).fadeIn(400, function(){
			defaultInd = newInd;
			count--;
			if(count <= 0){
				if(start.timer) window.clearTimeout(start.timer);
				callback && callback();
			}
		});
	}
	
	var next = function(callback){
		var newInd = defaultInd + 1;
		if(newInd >= list.length){
			newInd = 0;
		}
		change(newInd, callback);
	}
	
	var start = function(){
		if(start.timer) window.clearTimeout(start.timer);
		start.timer = window.setTimeout(function(){
			next(function(){
				start();
			});
		}, 8000);
	}
	
	start();
	
	$('#js_ban_button_box').on('click', 'a', function(){
		var btn = $(this);
		if(btn.hasClass('right')){
			//next
			next(function(){
				start();
			});
		}
		else{
			//prev
			var newInd = defaultInd - 1;
			if(newInd < 0){
				newInd = list.length - 1;
			}
			change(newInd, function(){
				start();
			});
		}
		return false;
	});
	
})();

function submitForm(){
	$("#loginForm").submit();
}

</script>


	<form id="loginForm" action="${pageContext.request.contextPath }/user" method="post">
		<div class="container_">
			<div class="register-box" style="top:-480px;height:350px">
				<div class="reg-slogan"> 用户登录</div>
				<div class="reg-form" id="js-form-mobile">
				<input type="hidden" name="method" value="login"/>
					<div class="cell">
						<input type="text" placeholder="请输入用户名" name="username" id="js-mobile_ipt" class="text" maxlength="11" />
					</div>
					<div class="cell">
						<input type="password" placeholder="请输入密码"  name="pwd" id="js-mobile_pwd_ipt" class="text" />
					</div>
					
					<div class="user-agreement" style="color:#BDBDBD;font-size: 14px">
						<input type="checkbox" id="js-mail_chk" checked="checked" />
						记住用户名
					</div>
					
					<div class="bottom" onclick="submitForm()">
						<a id="js-mobile_btn" href="javascript:;" class="button btn-green">用户登录</a>
					</div>
					<div style="width:300px;height:18px;margin-top:26px;text-align: right;">
						<span style="color: red;font-size: 12px;margin-right:20px;">${msg}</span>
						<a href="#" style="color: #6c6c6c;font-size: 12px;">忘记密码</a>
						<a href="#" style="margin:0px 5px;color: #6c6c6c;font-size: 12px;">忘记用户名</a>
						<a href="${pageContext.request.contextPath }/register.jsp" style="color: #6c6c6c;font-size: 12px;">免费注册</a>
					</div>
				</div>
				
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">
/* $(document).ready(function() {
	FancyForm.setup();
}); */
</script>

</body>
</html>
