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
<link rel="stylesheet" href="<%=basePath%>css/jquery.css">
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
					<li><a href="<%=basePath%>user/index.do">首页</a></li>
					<li class="menu_active"><a href="<%=basePath%>user/userCenter.do">个人中心</a></li>
				</ul>
				<div id="user_bar">
					<a> <img id="avatar" src="${user.imgurl }" alt=""
						width="30px;">
					</a> <a id="lay_out" href="<%=basePath%>user/logout.do">退出</a>
				</div>
			</div>
		</menu>
	</header>
	<main>
	<div class="container">
		<h2>我的资料</h2>
		<div id="profile_tab">
			<ul class="profile_tab_header f_left clearfix">
				<li><a href="<%=basePath%>user/userUpdate.do">更改资料</a></li>
				<li class="profile_tab_line">|</li>
				<li><a href="<%=basePath%>user/userUpdateImg.do">更改头像</a></li>
				<li class="profile_tab_line">|</li>
				<li><a href="<%=basePath%>user/userUpdatePassword.do">密码安全</a></li>
			</ul>
			<div class="proflle_tab_body">
				<div class="proflle_tab_workplace clearfix">
					<div class="profile_avatar_area">
						<img src="${user.imgurl }">
						<p style="text-align: center;">当前头像</p>
					</div>
					<div class="profile_ifo_area">
						<form id="upload_form" action="<%=basePath%>user/userAlterImg.do" enctype="multipart/form-data" method="post">
							<!-- hidden crop params -->


							<p>第一步：请选择图像文件</p>
							<div>
								<input name="imageFile" id="image_file"
									onchange="fileSelectHandler()" type="file">
							</div>

							<div class="error"></div>

							<div class="step2">
								<p>第二步：请确定,然后按上传</p>


								<input value="上传" type="submit">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>



	<footer>
		<div class="container">
			<ul>
				<li><img src="<%=basePath%>pictures/footer_logo.png" alt=""
					id="foot_logo"></li>
				<li>版权所有：智游3G教育 ©&nbsp;www.zhiyou100.com</li>
				<li><img src="<%=basePath%>pictures/a.png" alt="" id="wxgzh"></li>
			</ul>
		</div>
	</footer>



	<script src="<%=basePath%>js/jquery-1.js"></script>
	<script src="<%=basePath%>js/gVerify.js"></script>
	<script src="<%=basePath%>js/index.js"></script>
	<script src="<%=basePath%>js/jquery.js"></script>
	<script src="<%=basePath%>js/Jcrop_upload.js"></script>
</body>
</html>