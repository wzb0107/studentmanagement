<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	</head>
	<body>
		<!--顶部-->
		 <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="example-navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a class="icon-bar" style="font-size: 20px;" href="javascript:void(0)">河海大学文天学院教务系统</a>
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
                    <a href="${pageContext.request.contextPath}/admin/adminIndex.jsp" class="list-group-item active">
                    	<span class="glyphicon glyphicon-home"></span>
                    	&nbsp;&nbsp;&nbsp;&nbsp;菜单
                    </a>
                    <a href="${pageContext.request.contextPath}/collegeinfo.action" class="list-group-item">
                    <!-- 小图标样式设置 -->
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                                            学院信息管理
                    </a>
                    <a href="${pageContext.request.contextPath}/findSpecialFieldInfo.action" class="list-group-item">
                        <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
                                                            专业信息管理
                    </a>
                    <a href="${pageContext.request.contextPath}/findClassInfo.action" class="list-group-item">
                        <span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
                                                            班级信息管理
                    </a>
                    <a href="${pageContext.request.contextPath}/findStudent.action" class="list-group-item">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                                            学生信息管理
                    </a>
                    <a href="${pageContext.request.contextPath}/findTeacher.action" class="list-group-item">
                        <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                                                            教师信息管理
                    </a>
                    <a href="${pageContext.request.contextPath}/findcourseinfo.action" class="list-group-item">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                                            课程信息管理
                    </a>
                    <a href="${pageContext.request.contextPath}/selectStudentById.action" class="list-group-item">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                                            选课信息管理
                    </a>
                    <a href="${pageContext.request.contextPath}/other/alterpassword.jsp" class="list-group-item">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                                            重置密码
                    </a>
                </div>
                <!--左边菜单栏-->
                <div class="col-sm-10">
                    <ol class="breadcrumb">
                        <li class="active">首页</li>
                    </ol>

                    <div class="panel panel-default">
                        <div class="panel-body">
	                        <p style="font-size: 50px;">河海大学文天学院</p>
							<p style="font-size: 25px;">欢迎使用河海大学文天学院教务系统</p>
						  	<p>开发人员：贾金磊、葛雪珂、陈翠莲、魏婷婷、吴佳嘉、刘林阳</p>
						  	<p>开发周期：2018/08/01 --- 2018/08/31（共计31天）</p>
						  	<hr />
						  	<h2>开发环境</h2>
						  	<p>系统环境：Windows</p>
							<p>开发工具：Eclipse</p>
							<p>Java版本：JDK 1.7</p>
							<p>服务器：tomcat 8.5</p>
							<p>数据库：MySQL 5.6</p>
							<p>系统采用技术：SpringMVC+MyBatis+Spring+JQuery+bootstrap</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		
		<!--底部-->
		<div class="footer">
     		<p class="text-center">
         		2018 &copy; 贾金磊.
     		</p>
 		</div>
	</body>
</html>
