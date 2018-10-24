<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="wt" uri="http://hhuwtian.edu.cn/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
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

		$("#collegeForm").validate({
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
					class="list-group-item active"> <!-- 小图标样式设置 --> <span
					class="glyphicon glyphicon-search" aria-hidden="true"></span>
					学院信息管理
				</a> <a
					href="${pageContext.request.contextPath}/findSpecialFieldInfo.action"
					class="list-group-item"> <span
					class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
					专业信息管理
				</a> <a href="${pageContext.request.contextPath}/findClassInfo.action"
					class="list-group-item"> <span
					class="glyphicon glyphicon-camera" aria-hidden="true"></span>
					班级信息管理
				</a> <a
					href="${pageContext.request.contextPath}/findStudent.action"
					class="list-group-item"> <span class="glyphicon glyphicon-plus"
					aria-hidden="true"></span> 学生信息管理
				</a> <a
					href="${pageContext.request.contextPath}/findTeacher.action"
					class="list-group-item"> <span
					class="glyphicon glyphicon-minus" aria-hidden="true"></span> 教师信息管理
				</a> <a href="${pageContext.request.contextPath}/findcourseinfo.action"
					class="list-group-item"> <span
					class="glyphicon glyphicon-search" aria-hidden="true"></span>
					课程信息管理
				</a> <a
					href="${pageContext.request.contextPath}/selectStudentById.action"
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
					<li class="active">学院信息管理</li>
				</ol>

				<div class="panel panel-default">
					<div class="panel-heading">搜索</div>
					<div class="panel-body">
						<form role="form" class="form-inline" method="post"
							action="${pageContext.request.contextPath}/collegeinfo.action">
							<div class="form-group">
								
								<label for="name">名称</label> <input type="text"
									class="form-control" name="name" id="name"
									value="${param.name}" placeholder="请输入名称">
							</div>
							<div class="form-group" style="margin-left: 10px;">
								<input type="submit" class="btn btn-info" value="开始搜索">
							</div>
							<div class="form-group" style="margin-left: 50px;">
								<button type="button" class="btn btn-info" data-toggle="modal"
									data-target="#myModal">添加学院信息</button>
							</div>
						</form>
					</div>
				</div>
				<!--列表展示-->
				<div class="table-responsive">
				<span style="color:red">${error}</span>
					<table class="table table-striped ">
						<thead>
							<tr>
								<th>序号</th>
								<th>学院编号</th>
								<th>学院名称</th>
								<th>开院时间</th>
								<th>负责人</th>
								<th>手机</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.rows}" var="c" varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td>${c.number}</td>
									<td>${c.name}</td>
									<td><fmt:formatDate value="${c.birthday}"
											pattern="yyyy-MM-dd" /></td>
									<td>${c.man}</td>
									<td>${c.phone}</td>
									<td>
										<div class="btn-group">
											<a
												href="${pageContext.request.contextPath}/showCollegeinfo.action?id=${c.id}"
												class="btn btn-success">查看</a> <a
												href="${pageContext.request.contextPath}/deleteCollegeinfo.action?id=${c.id}"
												class="btn btn-danger">删除</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-sm-12 text-right">
					<wt:page
						url="${pageContext.request.contextPath}/collegeinfo.action"></wt:page>
				</div>
			</div>
		</div>
	</div>

	<!--底部-->
	<div class="footer">
		<p class="text-center">2018 &copy; 贾金磊.</p>
	</div>

	<!-- 模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加学院信息</h4>
				</div>
				<form method="post"
					action="${pageContext.request.contextPath}/addCollegeinfo.action"
					id="collegeForm">
					<div class="modal-body">
						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="number">学员编号</label> <input type="text"
										class="form-control" id="number" value="" name="number"
										placeholder="学员编号">
								</div>
								<div class="form-group">
									<label for="name">学院名称</label> <input type="text"
										class="form-control" id="name" name="name" placeholder="学院名称">
								</div>
								<div class="form-group">
									<label for="birthday">开院时间</label> <input type="text"
										class="form-control" id="birthday" name="birthday"
										placeholder="开院时间">
								</div>
								<div class="form-group">
									<label for="man">负责人</label> <input type="text"
										class="form-control" id="man" name="man" placeholder="负责人">
								</div>
								<div class="form-group">
									<label for="phone">手机</label> <input type="text"
										class="form-control" id="phone" name="phone" placeholder="手机">
								</div>
								<div class="form-group">
									<label for="memo">附加信息</label>
									<textarea class="form-control" rows="3"
										placeholder="不要超过200字..." name="memo"></textarea>
								</div>
							</div>
							<div class="col-sm-3"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<input type="submit" class="btn btn-primary" value="添加">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

