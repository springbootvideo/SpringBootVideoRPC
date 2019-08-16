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

<script src="<%=basePath%>js/jquery-1.js"></script>
<script src="<%=basePath%>js/bootstrap.js"></script>
<script src="<%=basePath%>js/confirm.js"></script>
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/message_cn.js"></script>

<style type="text/css">
th {
	text-align: center;
.d{
padding-left: 400px;
display:inline-block;
}
}
</style>
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
				</ul>
				<p class="navbar-text navbar-right">
					<span>${sessionScope.accounts}</span> <i class="glyphicon glyphicon-log-in"
						aria-hidden="true"></i>&nbsp;&nbsp;<a class="navbar-link" href="<%=basePath%>admin/logout.do">退出</a>
				</p>
			</div>


		</div>
		<!-- /.container-fluid -->
	</nav>






	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">
			<h2>视频管理</h2>
		</div>
	</div>

	<form action="<%=basePath%>admin/deleteall.do" id="videoForm">
		<div class="container">
			<button onclick="videoAdd()" type="button"
				class="btn btn-info dropdown-toggle" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">添加</button>
			<button onclick="deleteAll()" type="submit" id="btn"
				class="btn btn-info dropdown-toggle">批量删除</button>
		<div class="d">
		<input type="text" placeholder="标题" id="in" name="factor" class="" value="">
			<select name="speakerId" id="speaker" class="btn btn-primary">
				<option value="0">请选择老师</option>	
			           <c:forEach items="${speakerList}" var="i" >
				        <option value="${i.id}">${i.speakerName}</option>
				       </c:forEach>
			</select>
			<select name="courseId" id="course" class="btn btn-primary">
				<option value="0">请选择课程</option>	
			       <c:forEach items="${courseList}" var="j" >
				        <option value="${j.id}">${j.courseTitle}</option>
				    </c:forEach>
			</select>
			<button type="button" onclick="selectFor()" class="btn btn-info dropdown-toggle">查询</button>
		</div>
		
		</div>

		<div class="container" style="margin-top: 20px;">

			<table class="table table-bordered table-hover"
				style="text-align: center; table-layout: fixed;">
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="all" name="select"></th>
						<th>序号</th>
						<th style="width: 9%">名称</th>
						<th style="width: 50%">介绍</th>
						<th>讲师</th>
						<th>时长</th>
						<th style="width: 9%">播放次数</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="video" items="${videoList}">
						<tr>
							<td><input type="checkbox" name="select"></td>
							<td>${video.videoId}</td>
							<td>${video.title}</td>
							<td
								style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${video.detail}</td>
								<td>${video.speaker.speakerName}</td>
							<td>${video.time}</td>
							<td>${video.playNum}</td>
							<td><a href="<%=basePath%>admin/videoUpdate.do?id=${video.videoId}">✎</a></td>
							<td><a id="del" href="javascript:void(0)" onclick="delVideoById('#del','${video.videoId}','${video.title}')">X</a></td>
						</tr>
					</c:forEach>
					<tr>
						    <td colspan="9"><font>总共${selectCouunt}条,当前第${page}页</font> <c:if
								test="${selectCouunt%5==0}">
								<c:set var="page" value="${selectCouunt/5}">
								</c:set>
							</c:if> <c:if test="${selectCouunt%5!=0}">
								<c:set var="page" value="${selectCouunt/5+1}">
								</c:set>
							</c:if> <c:forEach var="i" begin="1" end="${page}">
								<a href="${pageContext.request.contextPath }/admin/videoManage.do?page=${i}">第${i}页</a>
							</c:forEach>
					</tr>
				</tbody>
			</table>

		</div>
	</form>




	<script type="text/javascript">
	
	function selectFor(){
		$("#videoForm").attr('action','/video/admin/videoSelectLike.do').submit();
		
	}


   $(function() {
		$("#all").click(function() {
			$("input[name='select']").prop("checked", this.checked);
		})

	})
	function deleteAll() {
		var selected = [];
		$.each($("input[name='select']"), function() {
			if (this.checked) {
				selected.push($(this).val());
			}
		})
		var ids = JSON.stringify(selected);
		$("#ids").val(ids);
	}
	function videoAdd(){
		location.href="<%=basePath%>admin/videoAdd.do";
	}
		function delVideoById(Obj,id,title){

			Confirm.show('温馨提示：', '确定要删除'+title+'么？', {
				'Delete': {
					'primary': true,
					'callback': function() {
						var param={"id":id};
						$.post("<%=basePath%>admin/videoDelete.do",param,function(data){
							if(data=='success'){
								Confirm.show('温馨提示：', '删除成功');
								$(Obj).parent().parent().remove();
							}else{
								Confirm.show('温馨提示：', '操作失败');
							}
						});
					}
				}
			});
		}
	</script>


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