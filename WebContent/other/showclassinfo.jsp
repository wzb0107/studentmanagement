<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
<script
	src="${pageContext.request.contextPath}/layDate-v5.0.9/laydate/laydate.js"></script>
<style>
label.error {
	background: url(${pageContext.request.contextPath}/img/unchecked.gif)
		no-repeat 10px 3px;
	padding-left: 30px;
	font-family: georgia;
	font-size: 15px;
	font-style: normal;
	color: red;
}
</style>
<script type="text/javascript">
	$(function() {
		laydate.render({
			elem : '#birthday' //指定元素
		});
		
		$("#classForm").validate({
			rules : {
				number : {
					required : true,
					maxlength : 20
				},
				name : {
					required : true,
					maxlength : 50
				},
				birthday : {
					required : true
				},
				man : {
					maxlength : 20
				},
				phone : {
					digits : true,
					maxlength : 11
				},
				memo : {
					maxlength : 200
				}
			},
			messages : {
				number : {
					required : "编号不能为空",
				},
				name : {
					required : "学院名不能为空",
				},
				birthday : {
					required : "建院日期不能为空"
				},
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
					<li>欢迎您，<span>${sessionScope.user.username }</span></li>
					<li><a
						href="${pageContext.request.contextPath}/userLogout.action"
						onclick="alert('退出成功！')">安全退出</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!--中部-->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<a href="${pageContext.request.contextPath}/admin/adminIndex.jsp"
					class="list-group-item"> <span class="glyphicon glyphicon-home"></span>
					&nbsp;&nbsp;&nbsp;&nbsp;菜单
				</a> <a href="${pageContext.request.contextPath}/collegeinfo.action"
					class="list-group-item "> <!-- 小图标样式设置 --> <span
					class="glyphicon glyphicon-search" aria-hidden="true"></span>
					学院信息管理
				</a> <a
					href="${pageContext.request.contextPath}/findSpecialFieldInfo.action"
					class="list-group-item"> <span
					class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
					专业信息管理
				</a> <a href="${pageContext.request.contextPath}/findclassinfo.action"
					class="list-group-item active"> <span
					class="glyphicon glyphicon-camera" aria-hidden="true"></span>
					班级信息管理
				</a> <a
					href="${pageContext.request.contextPath}/findstudent.action"
					class="list-group-item"> <span class="glyphicon glyphicon-plus"
					aria-hidden="true"></span> 学生信息管理
				</a> <a
					href="${pageContext.request.contextPath}/findteacher.action"
					class="list-group-item"> <span
					class="glyphicon glyphicon-minus" aria-hidden="true"></span> 教师信息管理
				</a> <a href="${pageContext.request.contextPath}/findcourse.action"
					class="list-group-item"> <span
					class="glyphicon glyphicon-search" aria-hidden="true"></span>
					课程信息管理
				</a> <a
					href="${pageContext.request.contextPath}/findstudentselectcourseinfo.action"
					class="list-group-item"> <span
					class="glyphicon glyphicon-search" aria-hidden="true"></span>
					选课信息管理
				</a> <a
					href="${pageContext.request.contextPath}/other/alterpassword.jsp"
					class="list-group-item"> <span class="glyphicon glyphicon-user"
					aria-hidden="true"></span> 重置密码
				</a>
			</div>

			<div class="col-sm-10">
				<ol class="breadcrumb">
					<li class="active">首页</li>
					<li class="active">班级信息管理</li>
				</ol>

				<div class="panel panel-default">
					<div class="panel-body">
						<span style="font-size: 30px">班级详细信息</span>
					</div>
				</div>
				<!--列表展示-->
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<form method="post" id="collegeForm"
							action="${pageContext.request.contextPath}/updateClassinfo.action">
							<div class="form-group">
								<input type="hidden" id="id" name="id" value="${classinfo.id}">
								<label for="number">学员编号</label> <input type="text"
									class="form-control" id="number" value="${classinfo.number}"
									name="number" placeholder="学员编号">
							</div>
							<div class="form-group">
								<label for="name">班级名称</label> <input type="text"
									value="${classinfo.name}" class="form-control" id="name"
									name="name" placeholder="班级名称">
							</div>
							<div class="form-group">
								<label for="name">专业ID</label> <input type="text"
									value="${classinfo.spacialfieldid}" class="form-control" id="spacialfieldid"
									name="spacialfieldid" placeholder="专业ID">
							</div>
							<div class="form-group">
								<label for="birthday">开班时间</label> <input type="text"
									value="<fmt:formatDate value="${classinfo.birthday}"
											pattern="yyyy-MM-dd" />"
									class="form-control" id="birthday" name="birthday"
									placeholder="开班时间">
							</div>
							<div class="form-group">
								<label for="teachercharge">辅导员</label> <input type="text"
									value="${classinfo.teachercharge}" class="form-control" id="teachercharge"
									name="teachercharge" placeholder="辅导员">
							</div>
							<div class="form-group">
								<label for="phone">手机</label> <input type="text"
									value="${classinfo.phone}" class="form-control" id="phone"
									name="phone" placeholder="手机">
							</div>
							<div class="form-group">
								<label for="memo">附加信息</label>
								<textarea class="form-control" rows="3"
									placeholder="不要超过200字..." name="memo">${classinfo.memo}</textarea>
							</div>
							<div class="form-group" style="margin-left: 50px;">
								<input type="submit" class="btn btn-info" value="修改班级信息">
								<a href="${pageContext.request.contextPath}/findClassInfo.action" class="btn btn-info" style="margin-left:60px">返回</a>
							</div>
						</form>
					</div>
					<div class="col-sm-4"></div>
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
