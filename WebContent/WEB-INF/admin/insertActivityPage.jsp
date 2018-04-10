<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Spinning后台系统</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="${pageContext.request.contextPath }/image/png"
	href="${pageContext.request.contextPath }/images/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath }/images/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/admin.css">
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/app.js"></script>
<script src="${pageContext.request.contextPath }/js/calendar.js"
	type="text/javascript" language="javascript"></script>
<SCRIPT type=text/javascript
	src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></SCRIPT>
<SCRIPT type=text/javascript
	src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></SCRIPT>
<SCRIPT type=text/javascript
	src="${pageContext.request.contextPath}/ueditor/ueditor.parse.js"></SCRIPT>

<SCRIPT type="text/javascript">
	function update() {
		if (confirm("确认修改？")) {

			document.forms.form1.action = " ${pageContext.request.contextPath}/t_Activity/updateT_Activity.action";
			document.forms.form1.submit();

			return true;

		} else {
			return false;
		}
	}

	function insert() {
		if (confirm("确认添加？")) {

			document.forms.form1.action = " ${pageContext.request.contextPath}/t_Activity/insertT_Activity.action";
			document.forms.form1.submit();
			return true;

		} else {
			return false;
		}
	}
</SCRIPT>


</head>



<body>
	<header class="am-topbar admin-header">

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
		<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">





		</ul>
	</div>
	</header>

	<div class="am-cf admin-main">

		<div class="nav-navicon admin-main admin-sidebar">


			<jsp:include page="/WEB-INF/admin/left.jsp"></jsp:include>
			<!-- sideMenu End -->

			<script type="text/javascript">
				jQuery(".sideMenu").slide({
					titCell : "h3", //鼠标触发对象
					targetCell : "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
					effect : "slideDown", //targetCell下拉效果
					delayTime : 300, //效果时间
					triggerTime : 150, //鼠标延迟触发时间（默认150）
					defaultPlay : true,//默认是否执行效果（默认true）
					returnDefault : true
				//鼠标从.sideMen移走后返回默认状态（默认false）
				});
			</script>








		</div>

		<div class=" admin-content">






			<div class="admin-biaogelist">

				<div class="listbiaoti am-cf">
					<ul class="am-icon-flag on">
					</ul>




				</div>

				<div class="fbneirong">
					<form class="am-form" id="form1" method="post">
						<div class="am-form-group am-cf">
							<div class="zuo">类型：</div>
							<div class="you">
								<select name="type">
									<option value="0"
										<c:if test="${t_Activity.type=='0'}">selected</c:if>>--请选择--</option>

									<option value="活动"
										<c:if test="${t_Activity.type eq  '活动'}">selected</c:if>>活动</option>
									<option value="阅读"
										<c:if test="${t_Activity.type eq ' 阅读'}">selected</c:if>>阅读</option>
									<option value="训练推荐"
										<c:if test="${t_Activity.type eq  '训练推荐'}">selected</c:if>>训练推荐</option>
									<option value="赛事"
										<c:if test="${t_Activity.type eq  '赛事'}">selected</c:if>>赛事</option>
								</select>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">标题：</div>
							<div class="you">
								<input type="text" class="am-input-sm" name="title"
									value="${t_Activity.title}" id="doc-ipt-pwd-1"
									placeholder="请输入标题名称">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">时间：</div>
							<div class="you">
								<input type="text" class="am-input-sm" name="time"
									onclick="SetDate(this,'yyyy-MM-dd hh:mm:ss')"
									value="${t_Activity.time}" id="doc-ipt-pwd-1"
									placeholder="请输入时间名称">
							</div>
						</div>










						<div class="am-form-group am-cf">
							<div class="zuo">初始化点击数：</div>
							<div class="you">
								<input type="number" class="am-input-sm" name="clicks_count"
									value="${t_Activity.clicks_count}" id="doc-ipt-pwd-1"
									placeholder="请输入点击数">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">初始化点赞数：</div>
							<div class="you">
								<input type="number" class="am-input-sm" name="zan_count"
									value="${t_Activity.zan_count}" id="doc-ipt-pwd-1"
									placeholder="请输入点赞数">
							</div>
							<input type="hidden" class="am-input-sm" name="user_id"
								value="${user.user_id}" id="doc-ipt-pwd-1">
						</div>

						<div class="am-form-group am-cf">
							<div class="zuo">发布：</div>
							<div class="you">
								<select name="state">
									<option value="审核通过"
										<c:if test="${t_Activity.state eq '审核通过' }">selected</c:if>>审核通过</option>

									<option value="待审核"
										<c:if test="${t_Activity.state eq '待审核'}">selected</c:if>>待审核</option>
									<option value="审核未通过"
										<c:if test="${t_Activity.state eq '审核未通过' }">selected</c:if>>审核未通过</option>
								</select>
							</div>
						</div>
						<div style="height: 400px;">
							<div class="zuo">内容：</div>
							<!-- <div class="you">
								<input type="text" class="am-input-sm" name="content"
									value="${t_Activity.content}" id="doc-ipt-pwd-1"
									placeholder="请输入内容">
							</div>
							 -->
							<TEXTAREA id=myEditor name="content"
								style="height: 400px; margin-left: 11%;">${t_Activity.content}</TEXTAREA>
							<SCRIPT type=text/javascript>
								var editor = new UE.ui.Editor();
								editor.render("myEditor");
								//1.2.4以后可以使用一下代码实例化编辑器 
								//UE.getEditor('myEditor')
							</SCRIPT>
							<div class="am-form-group am-cf">
								<c:if test="${t_Activity==null}">

									<div class="you" style="margin-left: 11%;">
										<button onClick="return insert()"
											class="am-btn am-btn-success am-radius">点击添加</button>
									</div>
								</c:if>

								<c:if test="${t_Activity!=null}">
									<input type="hidden" class="am-input-sm" name="aid"
										value="${t_Activity.aid}" />
									<div class="you" style="margin-left: 11%;">
										<button onClick="return update()"
											class="am-btn am-btn-success am-radius">点击修改</button>
									</div>
								</c:if>

							</div>
						</div>


					</form>
				</div>



				<div class="foods">
					<ul>版权所有@Spinning后台
					</ul>
					<dl>
						<a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
					</dl>
				</div>




			</div>

		</div>




	</div>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/amazeui.min.js"></script>
	<!--<![endif]-->



</body>
</html>