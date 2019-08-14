<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta name="keywords"
	content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description"
	content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">

<link rel="stylesheet" href="<%=basePath%>css/base.css">
<link rel="stylesheet" href="<%=basePath%>css/css.css">
<link rel="icon" href="<%=basePath%>pictures/favicon.png"
	type="image/png">
<title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
</head>
<body>
	
	<header>
		<div class="container">
			<span>欢迎来到IT培训的黄埔军校——智游教育！</span>
			<div id="userBlock" style="float: right">
				<c:if test="${user!=null}">
					<a href="<%=basePath%>user/logout.do">退出</a>
					<a  href="<%=basePath%>user/userCenter.do">${user.accounts}</a>
				</c:if>
				<c:if test="${user==null}">
					<a id="reg_open" raggable="false">注册</a>
					<a id="login_open" raggable="false">登录</a>
				</c:if>
				<a id="admin_open" raggable="false">后台管理</a>

			</div>
			<a onclick="JavaScript:addFavorite2()"> <img
				src="<%=basePath%>pictures/sc.png" draggable="false">加入收藏
			</a> <img src="<%=basePath%>pictures/we.png" draggable="false"> <a
				class="color_e4"><img src="<%=basePath%>pictures/phone.png"
				draggable="false"> 0371-88888598 4006-371-555</a>
		</div>
	</header>


	<div id="app">
		<!--banner图-->
		<div class="banner">
			<img alt="" src="<%=basePath%>pictures/banner-1.jpg" width="100%"
				height="470px;">
		</div>

		<!--面包屑导航-->
		<div class="container mian-nav" id="navDiv">公开课 / WEB前端</div>

		<c:forEach items="${courseList}" var="course">
			<div class="classify">
				<div class="container" id="dataContainer">
					<div class="section">
						<div class="classifyName">
							<p class="title title-first">${course.courseTitle }</p>
						</div>
						<div class="kcIntro">
							<p class="int">
								<span>课程介绍：</span> ${course.courseDesc }
							</p>
						</div>
						<ul>
							<c:forEach items="${course.videoList}" var="video">
								<li class="section-main" >
									<div class="thum" style="background-image: url(<%=basePath%>${video.imageUrl })"></div>
									<p><a href="<%=basePath%>user/videoDetail.do?videoId=${video.videoId}&courseId=${course.id}" >${video.title}</a></p>
									<div class="classify-v-info">
										<span class="count" title="观看次数"><img
											src="<%=basePath%>pictures/count.png" alt="">${video.playNum }</span> <span
											class="duration" title="视频时长"><img
											src="<%=basePath%>pictures/player.png" alt="">${video.time }</span>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</c:forEach>





		<!--页脚-->
		<footer>
			<ul>
				<li><img src="<%=basePath%>pictures/footer_logo.png" alt=""
					draggable="false"></li>
				<li class="mt25">
					<h3>各校区地址</h3>
					<ul>
						<li>总部地址<br>中国-郑州经济技术开发区河南省通信产业园六层
						</li>
						<li>郑州校区一<br>中国-郑州经济技术开发区第一大街与经北一路
						</li>
						<li>郑州校区二<br>中国-郑州经济技术开发区第四大街经开人才市场七楼
						</li>
						<li>郑州校区三<br>中国-郑州经济技术开发区第八大街河南省留学生创业园九层、十层
						</li>
						<li>西安分校<br>中国-西安莲湖区 联系人：梁老师 13201570801
						</li>
					</ul>
				</li>
				<li class="mt25">
					<h3>联系我们</h3>
					<ul id="foo_icon">
						<li>中国-郑州经济技术开发区经北三路河南通信产业园六层</li>
						<li>e-mail:zy@zhiyou100.com</li>
						<li>电话:4006-371-555 0371-88888598</li>
						<li class="erwei"><br>
							<div>
								<img class="weixin" src="./课程展示_files/a_002.png" alt=""
									draggable="false"> <img class="weibo"
									src="<%=basePath%>pictures/a.png" alt="" draggable="false">
							</div></li>
					</ul>
				</li>
			</ul>
			<div class="record">智游教育 © 豫ICP备17000832号-1 河南智游臻龙教育科技有限公司</div>
		</footer>


		<!--登录注册弹出框-->
		<div class="mask hidden" id="login">
			<div class="mask_content">
				<div class="mask_content_header">
					<img src="./课程展示_files/logo.png" alt="" class="ma">
				</div>
				<div class="mask_content_body">
					<form id="loginForm" action="http://localhost:8080/Voids/#">
						<h3>快速登录</h3>
						<input id="loginEmail" placeholder="请输入邮箱" name="email"
							type="email"> <input id="loginPassword"
							placeholder="请输入密码" name="password" type="password">
						<div id="forget">
							<a
								href="http://localhost:8080/video/front/user/forgetPassword.action">忘记密码？</a>
						</div>
						<input onclick="return commitLogin()" value="登　录" type="submit">
					</form>
				</div>
				<div class="mask_content_footer">
					<span id="login_close">关 闭</span>
				</div>
			</div>
		</div>
		<div class="mask hidden" id="reg">
			<div class="mask_content">
				<div class="mask_content_header">
					<img src="./课程展示_files/logo.png" alt="" class="ma">
				</div>
				<div class="mask_content_body">
					<form id="regForm"
						action="http://localhost:8080/Voids/user/insertUser.action">
						<h3>新用户注册</h3>
						<input id="regEmail" placeholder="请输入邮箱" name="email" type="email"><span
							id="emailMsg"></span> <input id="regPsw" placeholder="请输入密码"
							name="password" type="password"> <input id="regPswAgain"
							placeholder="请再次输入密码" name="psw_again" type="password"><span
							id="passMsg"></span>
						<div id="yzm" class="form-inline">
							<input name="yzm" style="width: 45%; display: inline-block;"
								type="text">
							<div id="v_container"
								style="width: 45%; height: 40px; float: right;">
								<canvas id="verifyCanvas" width="100" height="38"
									style="cursor: pointer;">您的浏览器版本不支持canvas</canvas>
								<canvas id="verifyCanvas" width="100" height="38"
									style="cursor: pointer;">您的浏览器版本不支持canvas</canvas>
							</div>
						</div>
						<input onclick="return commitRegForm();" value="注　册" type="submit">
					</form>
				</div>
				<div class="mask_content_footer">
					<span id="reg_close">关 闭</span>
				</div>
			</div>
		</div>



		<form action="http://localhost:8080/Voids/">
			<input type="text" value="1" id="isLogin">
		</form>


		<script src="<%=basePath%>js/jquery-1.js.下载"></script>
		<script src="<%=basePath%>js/gVerify.js.下载"></script>
		<script src="<%=basePath%>js/index.js.下载"></script>



	</div>
</body>
</html>