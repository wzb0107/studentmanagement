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
<style>
</style>
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
				<a href="${pageContext.request.contextPath}/admin/adminIndex.jsp"
					class="list-group-item"> <span class="glyphicon glyphicon-home"></span>
					&nbsp;&nbsp;&nbsp;&nbsp;菜单
				</a> <a href="${pageContext.request.contextPath}/collegeinfo.action"
					class="list-group-item"> <!-- 小图标样式设置 --> <span
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
					class="list-group-item active"> <span
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
					<li class="active">选课信息管理</li>
				</ol>

				<div class="panel panel-default">
					<div class="panel-heading">搜索</div>
					<div class="panel-body">
						<form role="form" class="form-inline" method="post"
							action="${pageContext.request.contextPath}/selectStudentById.action">
							<div class="form-group">
								<label for="name">名称</label> <input type="text"
									class="form-control" id="name" placeholder="请输入名称">
							</div>
							<div class="form-group" style="margin-left: 10px;">
								<button type="submit" class="btn btn-info">开始搜索</button>
							</div>
							<div class="form-group">
								<label for="number">课程</label> <select class="form-control"
									id="number" name="number">
									<option value="">--请选择--</option>
									<c:forEach items="${list}" var="item">
										<option value="${item.number}"
											<c:if test="${item.number == number}"> selected</c:if>>${item.name}</option>
									</c:forEach>
								</select>
							</div>
						</form>
					</div>
				</div>
				<!--列表展示-->
				<div class="table-responsive">
					<table class="table table-striped ">
						<thead>
							<tr>
								<th>课程名</th>
								<th>学生名</th>
								<th>分数</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.rows}" var="c">
								<c:forEach items="${c.studentCourse}" var="s">
									<tr>
										<c:forEach items="${s.students}" var="e">
											<td>${c.name}</td>
											<td>${e.name}</td>
											<td>${s.score}</td>
										</c:forEach>
									</tr>
								</c:forEach>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-sm-12 text-right">
					<wt:page
						url="${pageContext.request.contextPath}/selectStudentById.action"></wt:page>
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
