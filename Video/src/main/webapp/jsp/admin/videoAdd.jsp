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

<style type="text/css">
.col-md-1 {
	padding-top: 20px;
}

.a1 {
	color: gray;
}

b {
	float: right;
}
</style>

</head>
<body>
	<nav class="navbar-inverse">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand">视频管理系统</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
					<li><a href="<%=basePath%>admin/videoManage.do">视频管理</a></li>
					<li><a href="<%=basePath%>admin/speakerManage.do">主讲人管理</a></li>
					<li><a href="<%=basePath%>admin/courseManage.do">课程管理</a></li>
				</ul>
				<p class="navbar-text navbar-right">
					<span>${sessionScope.accounts}</span> <i
						class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a
						class="navbar-link" href="<%=basePath%>admin/logout.do">退出</a>
				</p>
			</div>

		</div>

	</nav>



	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">


			<h2>添加视频</h2>


		</div>
	</div>



	<div class="container" style="margin-top: 20px;">

		<form id="infoForm" class="form-horizontal"
			action="<%=basePath%>admin/videoSave.do" method="post">


			<div class="form-group">
				<label for="subjectTitle" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-10">
					<input class="form-control" name="title" id="subjectTitle"
						placeholder="课程标题" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="speakerId" class="col-sm-2 control-label">主讲人</label>
				<div class="col-sm-10">

					<select name="speakerId" id="speakerId" class="form-control">

						<c:forEach var="speaker" items="${speakerList}">
							<option value="${speaker.id}">${speaker.speakerName}</option>
						</c:forEach>

					</select>

				</div>
			</div>

			<div class="form-group">
				<label for="courseId" class="col-sm-2 control-label">所属课程</label>
				<div class="col-sm-10">

					<select name="courseId" id="courseId" class="form-control">

						<c:forEach var="course" items="${courseList}">
							<option value="${course.id}">${course.courseTitle}</option>
						</c:forEach>
					</select>

				</div>
			</div>
			<div class="form-group">
				<label for="time" class="col-sm-2 control-label">视频时长</label>
				<div class="col-sm-10">
					<input class="form-control" name="time" id="time"
						placeholder="精确到秒（正整数）" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="imageUrl" class="col-sm-2 control-label">封面图片地址</label>
				<div class="col-sm-10">
					<input class="form-control" name="imageUrl" id="imageUrl"
						placeholder="具体url" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="videoUrl" class="col-sm-2 control-label">视频播放地址</label>
				<div class="col-sm-10">
					<input class="form-control" name="videoUrl" id="videoUrl"
						placeholder="具体url" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="videoDesc" class="col-sm-2 control-label">备注</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="detail" name=""detail""
						rows="3"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">保存</button>
				</div>
			</div>
		</form>
	</div>



	<script src="<%=basePath%>js/jquery-1.js"></script>
	<script src="<%=basePath%>js/bootstrap.js"></script>
	<script src="<%=basePath%>js/confirm.js"></script>
	<script src="<%=basePath%>js/jquery.js"></script>
	<script src="<%=basePath%>js/message_cn.js"></script>



	<div id="modal-background" class=""></div>
	<div id="confirm-modal" class="modal fade role=" dialog"=""
		tabindex="-1">
		<div class="modal-dialog modal-undefined">
			<div class="modal-content">
				<div class="modal-header">
					<button id="modal-upper-close" class="close modal-close"
						aria-label="Close" type="button">
						<span aria-hidden="true">×</span>
					</button>
					<h4 id="modal-title" class="modal-title">Modal Title</h4>
				</div>
				<div id="modal-body" class="modal-body">Modal Message</div>
				<div id="modal-footer" class="modal-footer"></div>
			</div>
		</div>
	</div>
	<div id="modal-background" class=""></div>
</body>
</html>