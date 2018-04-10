<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



</head>

<body>
	<div class="nav-navicon admin-main admin-sidebar">


		<div class="sideMenu am-icon-dashboard"
			style="color: #aeb2b7; margin: 10px 0 0 0;">欢迎系统管理员：${user.user.nickname}</div>
		<c:if test="${user!=null }">
			<a href="${pageContext.request.contextPath }/user/loginout.action"
				style="font-weight: bold; color: #b52a2a; font-size: 14px; margin-left: 10px; font-family: '微软雅黑'"
				target="">注销</a>
		</c:if>
		<div class="sideMenu">
			<h3 class="am-icon-flag">
				<em></em> <a href="#">用户管理</a>
			</h3>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/user/finduserlist.action?pageNo=1&pageSize=10">用户列表</a>
				</li>


			</ul>
			<h3 class="am-icon-cart-plus">
				<em></em> <a href="#"> 赛事和活动管理</a>
			</h3>
			<ul>
				<li><a type="button"
					href="${pageContext.request.contextPath }/t_Activity/findT_Activitylist.action?pageNo=1&pageSize=10">活动列表</a>
				</li>
				<li><a type="button"
					href="${pageContext.request.contextPath }/t_Activity/insertPage.action">
						添加賽事或活动</a></li>
			</ul>
			<h3 class="am-icon-cart-plus">
				<em></em> <a href="#"> 部位训练推送管理</a>
			</h3>
			<ul>
				<li><a type="button"
					href="${pageContext.request.contextPath }/train/findTrainlist.action?pageNo=1&pageSize=10">推送部位训练列表</a>
				</li>
				<li><a type="button"
					href="${pageContext.request.contextPath }/train/insertPage.action">
						添加部位训练推送</a></li>
			</ul>

			<h3 class="am-icon-cart-plus">
				<em></em> <a href="#"> 课表管理</a>
			</h3>
			<ul>
				<li><a type="button"
					href="${pageContext.request.contextPath }/course/findCourselist.action?pageNo=1&pageSize=10">课表列表</a>
				</li>
				<li><a type="button"
					href="${pageContext.request.contextPath }/course/insertPage.action">
						添加课表</a></li>
			</ul>
			
			<h3 class="am-icon-cart-plus">
				<em></em> <a href="#"> 原始数据管理</a>
			</h3>
			<ul>
				<li><a type="button"
					href="${pageContext.request.contextPath }/user/findOriginallist.action?pageNo=1&pageSize=10">原始数据列表</a>
				</li>
			</ul>
			
			
		</div>
</body>
</html>
