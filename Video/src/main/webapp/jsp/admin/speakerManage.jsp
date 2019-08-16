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
			<h2>主讲人管理</h2>
		</div>
	</div>

	<form action="http://localhost:8888/Video/admin/deleteAll.do">
		<div class="container">
			<button onclick="speakerAdd()" type="button"
				class="btn btn-info dropdown-toggle" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">添加</button>

			<button onclick="deleteAll()" type="button" id="btn"
				class="btn btn-info dropdown-toggle">批量删除</button>
		</div>

		<div class="container" style="margin-top: 20px;">

			<table class="table table-bordered table-hover"
				style="text-align: center; table-layout: fixed;">
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="all" name="select" value=""></th>
						<th>序号</th>
						<th >名称</th>
						<th >职位</th>
						<th style="width: 60%">简介</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="speaker" items="${speakerList}">
						<tr>
							<td><input type="checkbox" name="select1" value="${speaker.id}"></td>
							<td>${speaker.id}</td>
							<td>${speaker.speakerName}</td>
							<td>${speaker.speakerJob}</td>
							<td
								style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${speaker.speakerDesc}</td>
							<td><a href="<%=basePath%>admin/speakerUpdate.do?id=${speaker.id}">✎</a></td>
							<td><a id="del" href="javascript:void(0)" onclick="delCourseById('#del','${speaker.id}','${speaker.speakerName}')">X</a></td>
						</tr>
					</c:forEach>
					<tr>
						    <td colspan="7"><font>总共${selectCouunt}条,当前第${page}页</font> <c:if
								test="${selectCouunt%5==0}">
								<c:set var="page" value="${selectCouunt/5}">
								</c:set>
							</c:if> <c:if test="${selectCouunt%5!=0}">
								<c:set var="page" value="${selectCouunt/5+1}">
								</c:set>
							</c:if> <c:forEach var="i" begin="1" end="${page}">
								<a href="${pageContext.request.contextPath }/admin/speakerManage.do?page=${i}">第${i}页</a>
							</c:forEach>
					</tr>
				</tbody>
			</table>

		</div>
	</form>




	<script type="text/javascript">
	   $(function() {
			$("#all").click(function() {
				$("input[name='select1']").prop("checked", this.checked);
			})

		})
		function deleteAll() {
			var selected = new Array();
			$.each($("input[name='select1']"), function() {
				if (this.checked) {
					selected.push($(this).val());
				}
			})
			var ids = selected;
			//var idds =$("#ids").val(ids);
		 //   alert(idds)
		 
		<%-- 	 $.ajax({
		           type:"post",
		           url:"<%=basePath%>admin/deleteAll.do",
		           data:{"ids":ids},		          
		           dataType:"json",		           
		           //traditional:true,
		           success:function(data){
		               if(data.status=='success'){
		            	   Confirm.show('温馨提示：', '删除成功');

		                       $(location).attr("温馨提示：', '删除成功","admin/speakerManage.do");
		                       //window.location.href="user/showUser";
		                     
		               }
		           }
		       }); --%>
	 
			$.post("<%=basePath%>admin/speakerDeleteAll.do",{"ids":ids},function(data){
				if(data=='success'){
					Confirm.show('温馨提示：', '删除成功');
					
					$(Obj).parent().parent().remove();
					location.reload();
				}else{
					Confirm.show('温馨提示：', '操作失败');
				}
			}); 
		}
	  
 
	   
		function speakerAdd(){
			location.href="<%=basePath%>admin/speakerAdd.do";
		}
		function delCourseById(Obj,id,title){

			Confirm.show('温馨提示：', '确定要删除'+title+'么？', {
				'Delete': {
					'primary': true,
					'callback': function() {
						var param={"id":id};
						$.post("<%=basePath%>admin/speakerDelete.do",param,function(data){
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