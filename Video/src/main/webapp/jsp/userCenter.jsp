<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css">
<link rel="stylesheet" href="<%=basePath%>css/profile.css">
<link rel="icon" href="http://localhost:8080/Voids/static/z/favicon.png"
	type="image/png">
<title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
</head>
<body>
	<header>
		<div class="container top_bar clearfix">
			<img src="<%=basePath%>pictures/logo.png" alt="智游">
			<div id="tele">
				<span>4006-371-555</span> <span>0371-88888598</span>
			</div>
		</div>
		<menu>
			<div class="container clearfix">
				<ul class="clearfix f_left">
					<li><a href="<%=basePath%>user/index">首页</a></li>
					<li class="menu_active"><a href="<%=basePath%>user/userCenter">个人中心</a></li>
				</ul>
				<div id="user_bar">
					<a> <img id="avatar" src="${user.imgurl }" alt=""
						width="30px;">
					</a> <a id="lay_out" href="<%=basePath%>user/logout">退出</a>
				</div>
			</div>
		</menu>
	</header>
	<main>
	<div class="container">
		<h2>我的资料</h2>
		<div id="profile_tab">
			<ul class="profile_tab_header f_left clearfix">
				<li><a href="<%=basePath%>user/userUpdate">更改资料</a></li>
				<li class="profile_tab_line">|</li>
				<li><a href="<%=basePath%>user/userUpdateImg">更改头像</a></li>
				<li class="profile_tab_line">|</li>
				<li><a href="<%=basePath%>user/userUpdatePassword">密码安全</a></li>
			</ul>
			<div class="proflle_tab_body">
				<div class="proflle_tab_workplace clearfix">
					<div class="profile_avatar_area">
						<img id="avatar" width="200px;" src="${user.imgurl }" alt="">
						<p>欢迎回来！</p>
					</div>
					<ul class="profile_ifo_area">
						<li><span class="dd">昵 称：${user.nickname }</span></li>
						<li><span class="dd">性 别：${user.sex }</span></li>
						<li><span class="dd">生 日：${user.birthday }</span></li>
						<li><span class="dd">邮 箱：${user.accounts }</span></li>
						<li><span class="dd">所在地：${user.address }</span></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</main>
	<footer>
		<div class="container">
			<ul>
				<li><img src="./各人 中心_files/footer_logo.png" alt=""
					id="foot_logo"></li>
				<li>版权所有：智游3G教育 ©&nbsp;www.zhiyou100.com</li>
				<li><img src="./各人 中心_files/a.png" alt="" id="wxgzh"></li>
			</ul>
		</div>
	</footer>
</body>
</html>