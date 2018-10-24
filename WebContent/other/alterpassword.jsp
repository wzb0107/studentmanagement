<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
<style>
label.error {
	background: url(../img/unchecked.gif) no-repeat 10px 3px;
	padding-left: 30px;
	font-family: georgia;
	font-size: 15px;
	font-style: normal;
	color: red;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script>
	$(function() {
		$("#alterform").validate({
			rules : {
				password : {
					required : true
				},
				rePassword : {
					required : true,
					equalTo : "#password"
				},
				newPassword : {
					required : true,
					rangelength : [ 6, 16 ]
				}
			},
			messages : {
				password : {
					required : "原密码不能为空"
				},
				rePassword : {
					required : "重复密码不能为空",
					equalTo : "两次输入的不一致"
				},
				newPassword : {
					required : "新密码不能为空"
				}
			}
		});
	});
</script>
</head>
<body>
	<!--顶部-->
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a class="icon-bar"
						style="font-size: 20px;" href="javascript:void(0)">河海大学文天学院教务系统</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li style="color:white;padding-top:15px">欢迎您，<span>${sessionScope.user.username }</span>
                     </li>
                     <li><a href="${pageContext.request.contextPath}/userLogout.action" onclick="alert('退出成功！')">安全退出</a>
                     </li>
				</ul>
			</div>
		</div>
	</nav>
	<!--中部-->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<a href="${pageContext.request.contextPath}/admin/adminIndex.jsp" class="list-group-item"> <span
					class="glyphicon glyphicon-home"></span> &nbsp;&nbsp;&nbsp;&nbsp;菜单
				</a> <a href="${pageContext.request.contextPath}/collegeinfo.action" class="list-group-item"> <!-- 小图标样式设置 -->
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					学院信息管理
				</a> <a href="${pageContext.request.contextPath}/findSpecialFieldInfo.action" class="list-group-item">
					<span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
					专业信息管理
				</a> <a href="${pageContext.request.contextPath}/findClassInfo.action" class="list-group-item"> <span
					class="glyphicon glyphicon-camera" aria-hidden="true"></span>
					班级信息管理
				</a> <a href="${pageContext.request.contextPath}/findStudent.action" class="list-group-item"> <span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span> 学生信息管理
				</a> <a href="${pageContext.request.contextPath}/findTeacher.action" class="list-group-item"> <span
					class="glyphicon glyphicon-minus" aria-hidden="true"></span> 教师信息管理
				</a> <a href="${pageContext.request.contextPath}/findcourseinfo.action" class="list-group-item"> <span
					class="glyphicon glyphicon-search" aria-hidden="true"></span>
					课程信息管理
				</a> <a href="${pageContext.request.contextPath}/selectStudentById.action"
					class="list-group-item"> <span
					class="glyphicon glyphicon-search" aria-hidden="true"></span>
					选课信息管理
				</a> <a href="${pageContext.request.contextPath}/other/alterpassword.jsp" class="list-group-item active">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					重置密码
				</a>
			</div>

			<div class="col-sm-10">
				<ol class="breadcrumb">
					<li class="active">首页</li>
					<li class="active">重置密码</li>
				</ol>

				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<form class="form-horizontal" method="post"
									action="${pageContext.request.contextPath}/alterPassword.action"
									id="alterform">
									<div class="form-group">
										<span style="color:red">${error}</span> <label for="password"
											class="col-sm-2 control-label">原密码</label>
										<div class="col-sm-10">
											<input type="password" id="password" class="form-control" name="password"
												placeholder="请输入原密码" style="width: 250px;">
										</div>
									</div>
									<div class="form-group">
										<label for="rePassword" class="col-sm-2 control-label">重复密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="rePassword" name="rePassword"
												placeholder="重复输入原密码" style="width: 250px;">
										</div>
									</div>
									<div class="form-group">
										<label for="newPassword" class="col-sm-2 control-label">新密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control"
												name="newPassword" placeholder="请输入新密码"
												style="width: 250px;">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<input type="submit" class="btn btn-success" value="提交">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
												type="reset" class="btn btn-warning" value="重置">
										</div>
									</div>
								</form>
							</div>
							<div class="col-sm-3"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--底部-->
	<div class="footer">
		<p class="text-center">2018 &copy; 贾金磊.</p>
	</div>
</body>
</html>
