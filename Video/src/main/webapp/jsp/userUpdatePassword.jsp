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
<link rel="icon" href="<%=basePath%>pictures/favicon.png"
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
					<li><a href="<%=basePath%>user/index.do">首页</a></li>
					<li class="menu_active"><a
						href="<%=basePath%>user/userCenter.do">个人中心</a></li>
				</ul>
				<div id="user_bar">
					<a> <img id="avatar" src="${user.imgurl }" alt="" width="30px;">
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
						<img id="avatar" width="200px;" src="${user.imgurl }" alt="">
					</div>
					<div class="profile_ifo_area">
						<form action="<%=basePath%>user/passwordUpdate.do" method="post">
							<div class="form_group">
                                    <span class="dd">旧　密　码：</span>
                                    <input id="originalPassword" type="password" name="originalPassword"><span id="oldMsg"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">新　密　码：</span>
                                    <input  id="newPassword" type="password" name="newPassword">
                                </div>
                                <div class="form_group">
                                    <span class="dd">确认新密码：</span>
                                    <input id="rePassword"  type="password" name="rePassword"><span id="passMsg"></span>
                                </div>
							 <div class="form_submit dd">
                                    <input value="保　存" type="submit" id="subBtn">
                                
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

	<script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#subBtn").attr('disabled',true);
		$("#originalPassword").blur(originalPasswordCheck);
		$("#rePassword").blur(rePasswordCheck);
	});
	function originalPasswordCheck(){
    
		$.ajax({
		url:"/SSM_Learn/user/originalPasswordCheck.do",
		type:"post",		
		data:{
			originalPassword:$("#originalPassword").val()
		},
		dataType:"json",
		success:function(msg){
			if(msg.isSuccess){
				$("#oldMsg").html("<font color='green'>原密码正确!</font>");
			}else{
				$("#oldMsg").html("<font color='red'>原密码错误!</font>");
			    
			}
		}
	});

	}
	function rePasswordCheck() {
		$.ajax({
			url:"/SSM_Learn/user/rePasswordCheck.do",
			type:"post",		
			data:{
				newPassword:$("#newPassword").val(),
				rePassword:$("#rePassword").val()
			},
			dataType:"json",
			success:function(msg){
				if(msg.isSuccess){
					$("#subBtn").attr('disabled',false);
					$("#passMsg").html("<font color='green'>两次密码一致!</font>");
				}else{
					$("#passMsg").html("<font color='red'>两次密码不一致!</font>");
				    
				}
			}
		});
	}
	</script>



</body>
</html>