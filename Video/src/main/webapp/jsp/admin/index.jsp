<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">

<script src="./js/jquery-1.js"></script>
<script src="./js/bootstrap.js"></script>
<script src="./js/confirm.js"></script>
<script src="./js/jquery.js"></script>
<script src="./js/message_cn.js"></script>

<style type="text/css">
th {
	text-align: center;
}
</style>
</head>
</head>
<body>
	<nav class="navbar-inverse">
		<div class="container">

			<div class="navbar-header">
				<a class="navbar-brand">视频管理系统</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
					<li><a href="<%=basePath%>admin/videoManage.do">视频管理</a></li>
					<li><a href="<%=basePath%>admin/speakerManage.do">主讲人管理</a></li>
					<li><a href="<%=basePath%>admin/courseManage.do">课程管理</a></li>
					<c:if test="${sessionScope.adminId<=3 }">
					<li><a href="<%=basePath%>admin/adminManage.do">管理员管理</a></li>
					</c:if>
				</ul>
				<p class="navbar-text navbar-right">
					<span>${sessionScope.accounts}</span> <i class="glyphicon glyphicon-log-in"
						aria-hidden="true"></i>&nbsp;&nbsp;<a class="navbar-link" href="<%=basePath%>admin/logout.do">退出</a>
				</p>
			</div>

		</div>
	</nav>
	<div>${msg }</div>
</body>
</html>