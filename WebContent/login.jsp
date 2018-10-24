<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<style>
label.error {
	background: url(img/unchecked.gif) no-repeat 10px 3px;
	padding-left: 30px;
	font-family: georgia;
	font-size: 15px;
	font-style: normal;
	color: red;
}
</style>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script>
	$(function() {
		$("#login").validate({
			rules : {
				username : {
					required : true
				},
				password : {
					required : true,
					rangelength : [ 6, 16 ]
				},
				validateCode : {
					required : true
				}
			},
			messages : {
				username : {
					required : "用户名不能为空"
				},
				password : {
					required : "密码不能为空"
				},
				validateCode : {
					required : "验证码不能为空"
				}
			}
		});
	});
</script>
<script type="text/javascript">
	function change() {
		document.getElementById("im").src = "${pageContext.request.contextPath}/showValidateCode.action?time"
				+ new Date().getTime();
	};
</script>
</head>
<body>
	<div class="login">
		<div class="content clearfix">
			<div class="content-left">
				<div class="logo">
					<img src="img/logobg.jpg" />
					<p>河海大学文天学院教务系统</p>
				</div>
			</div>
			<div class="shu"></div>
			<div class="content-right">
				<div class="login-form">
					<h2>用户登录/LOGIN</h2>
					<form action="${pageContext.request.contextPath}/userLogin.action"
						method="post" id="login">
						<span style="font-size:15px; color:red;">${error}</span>
						<div class="identifire">
							<span>身 份：</span>
							<select name="power">
								<option value="3" selected="selected">学生</option>
								<option value="2">教师</option>
								<option value="1">管理员</option>
							</select>
						</div>
						<div class="account clearfix">
							<span>账 号：</span>
							<input type="text" name="username" size="2" placeholder="请输入用户名" />
						</div>
						<div class="password clearfix">
							<span>密 码：</span>
							<input type="password" name="password" placeholder="请输入密码" />
						</div>
						<div class="code clearfix">
							<span>验证码：</span>
							<input type="text" name="validateCode" placeholder="请输入验证码" />
							<img
								src="${pageContext.request.contextPath}/showValidateCode.action"
								onclick="change()" id="im"
								style="margin-left:10px; width: 100px; height: 32px;" />
							<span style="font-size: 15px;color: red;">${requestScope.loginmessage}</span>
						</div>
						<div class="btn">
							<span id="login">
								<input type="submit" value="登录" style="width:225px"/>
							</span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
