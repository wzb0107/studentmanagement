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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

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
					<li style="color:white;padding-top:15px">欢迎您，<span>${sessionScope.user.username }</span></li>
					<li><a href="${pageContext.request.contextPath}/userLogout.action" onclick="alert('退出成功！')">安全退出</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!--中部-->
	<div class="container">
		<div class="table-responsive">
           <table class="table table-striped">
               <thead>
                   <tr>
                       <th>课程名</th>
                       <th>成绩</th>
                   </tr>
               </thead>
               <tbody>
               	<c:forEach items="${page.rows}" var="c">
                        <c:forEach items="${c.studentCourse}" var="s">
	                        <tr>
	                        	<td>${c.name}</td>
	                        	<td>${s.score}</td>
	                        </tr>
                        </c:forEach>
                   </c:forEach>
               </tbody>
           </table>
        </div>
        <div class="col-sm-12 text-right">
			<wt:page
				url="${pageContext.request.contextPath}/findStudentScore.action"></wt:page>
		</div>
	</div>

	<!--底部-->
	<div class="footer">
		<p class="text-center">2018 &copy; 贾金磊.</p>
	</div>
</body>
</html>
