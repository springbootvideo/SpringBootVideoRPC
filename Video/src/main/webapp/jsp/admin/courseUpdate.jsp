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
		<!-- /.container-fluid -->
	</nav>



	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">



			<h2>修改课程</h2>

		</div>
	</div>



	<div class="container" style="margin-top: 20px;">

		<form id="infoForm" class="form-horizontal" action="<%=basePath%>admin/courseAlter.do">

			<div class="form-group">
				<label for="subjectId" class="col-sm-2 control-label">所属学科</label>
				<div class="col-sm-10">

					<select name="subjectId" id="subjectId" class="form-control">
						<c:forEach var="subject" items="${subjectList}">
							<option value="${subject.subjectId}"
								<c:if test="${subject.subjectId==course.subject.subjectId }"> selected </c:if>>${subject.subjectName}</option>
						</c:forEach>


					</select>

				</div>
			</div>



			<div class="form-group">
				<label for="subjectTitle" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-10">
					<input class="form-control" name="courseTitle" id="subjectTitle"
						value="${course.courseTitle }" placeholder="课程标题" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="courseDesc" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="courseDesc" name="courseDesc"
						rows="3">${course.courseDesc}</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				<input type="hidden" name="id" value=${course.id }>
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