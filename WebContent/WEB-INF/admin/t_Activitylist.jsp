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
<link rel="icon" type="${pageContext.request.contextPath}/images/png"
	href="${pageContext.request.contextPath}/images/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath}/images/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
<SCRIPT type="text/javascript">
	function del() {
		if (confirm("真的要删除该条记录吗?")) {
			return true;

		} else {
			return false;
		}
	}
</SCRIPT>

<SCRIPT type="text/javascript">
	function find() {
		if (true) {

			document.forms.form2.action = " ${pageContext.request.contextPath}/t_Activity/findT_Activitylist.action";
			document.forms.form2.submit();

			return true;

		} else {
			return false;
		}
	}
</SCRIPT>
</head>
<body>
	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->
</head>

<body>
	<header class="am-topbar admin-header">

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
		<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

			<li class="am-dropdown tognzhi" data-am-dropdown></li>




		</ul>
	</div>
	</header>

	<div class="am-cf admin-main">

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

			<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
				<ul>
				<form id="form2" method="post">
						<li >
						<input type="text" name="type"
							style="width: 100%" class="am-form-field am-input-sm am-input-xm"
							placeholder="类型"    value="${t.type }" />
							
							</li>
							<li >
								 <input
								type="text" name="title" style="width: 200px"
								class="am-form-field am-input-sm am-input-xm"
								placeholder="标题" value="${t.title }"  />
						</li>
						<li >
						 <input type="text" name="state" style="width: 200px"
							class="am-form-field am-input-sm am-input-xm"
							placeholder="状态" value="${t.state }" />
						</li>
						<li >
						 <input type="text" name="user_id" style="width: 200px"
							class="am-form-field am-input-sm am-input-xm"  value="${t.user_id }"
							placeholder="发布者ID " />
						</li>

						<li><button onClick="return find()"
								class="am-btn am-radius am-btn-xs am-btn-success"
								style="margin-top: -1px;">搜索</button></li>
					</form>
				
				</ul>
			</div>


			<form class="am-form am-g">
				<table width="100%"  id="tb_3"
					class="am-table am-table-bordered am-table-radius am-table-striped">
					<thead>
						<tr class="am-success">

							<th class="table-id">ID</th>
							<th class="table-title">类型</th>
							<th class="table-type">标题</th>
							<th class="table-type">活动时间</th>
							<th class="table-type">内容</th>
							<th class="table-type">状态</th>
							<th class="table-type">发布者id</th>
							<th class="table-type">点击数</th>
							<th class="table-type">赞次数</th>
							<th class="table-type">创建时间</th>
							<th width="163px" class="table-set">操作</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${queryByPage.list}" var="t">
							<tr>

								<td>${t.aid}</td>
								<td>${t.type}</td>
								<td>${t.title}</td>
								<td>${ t.time}</td>
								<td>${ t.content}</td>
								<td>${ t.state}</td>
								<td>${t.user_id}</td>
								<td>${ t.clicks_count}</td>
								<td>${ t.zan_count}</td>
								<td>${ t.create_time}</td>

								<td><div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs">
											<a
												href="${pageContext.request.contextPath }/t_Activity/updatePage.action?aid=${t.aid}"
												class="am-btn am-btn-default am-btn-xs am-text-warning  am-round">
												<span class="am-icon-pencil-square-o"></span>
											</a> <a type="button" onClick="return del()"
												href="${pageContext.request.contextPath }/t_Activity/deleteT_Activity.action?aid=${t.aid}"
												class="am-btn am-btn-default am-btn-xs am-text-danger am-round">
												<span class="am-icon-trash-o"></span>
											</a>
										</div>
									</div></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>


				<div class="am-btn-group am-btn-group-xs"></div>

				<ul class="am-pagination am-fr">
				
				
				<li>第${ queryByPage.pageNum}/${ queryByPage.lastPage}页          总记录数${ queryByPage.total}条</a></li>
				
				<c:if test="${queryByPage.pageNum!=1 }">
							<li><a href="${pageContext.request.contextPath }/t_Activity/findT_Activitylist.action?type=${t.type}&title=${t.title }&state=${t.state }&user_id=${t.user_id}&pageNo=1&pageSize=10">首页</a></li>
								<li><a href="${pageContext.request.contextPath }/t_Activity/findT_Activitylist.action?type=${t.type}&title=${t.title }&state=${t.state }&user_id=${t.user_id}&pageNo=${ queryByPage.pageNum-1}&pageSize=10">上一页</a></li>
			</c:if>
			
			<c:if test="${queryByPage.pageNum!= queryByPage.lastPage}">
					<li><a href="${pageContext.request.contextPath }/t_Activity/findT_Activitylist.action?type=${t.type}&title=${t.title }&state=${t.state }&user_id=${t.user_id}&pageNo=${ queryByPage.pageNum+1}&pageSize=10">下一页</a></li>
					<li><a href="${pageContext.request.contextPath }/t_Activity/findT_Activitylist.action?type=${t.type}&title=${t.title }&state=${t.state }&user_id=${t.user_id}&pageNo=${ queryByPage.lastPage}&pageSize=10">尾页</a></li>
			</c:if>
				</ul>




				<hr />
				<p>注：.....</p>
			</form>




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

	<script src="${pageContext.request.contextPath}/js/polyfill/rem.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/polyfill/respond.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/amazeui.legacy.js"></script>

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/amazeui.min.js"></script>
	<!--<![endif]-->

	<script type="text/javascript">
		var tTD; //用来存储当前更改宽度的Table Cell,避免快速移动鼠标的问题
		var table = document.getElementById("tb_3");
		for (j = 0; j < table.rows[0].cells.length; j++) {
			table.rows[0].cells[j].onmousedown = function() {
				//记录单元格
				tTD = this;
				if (event.offsetX > tTD.offsetWidth - 10) {
					tTD.mouseDown = true;
					tTD.oldX = event.x;
					tTD.oldWidth = tTD.offsetWidth;
				}
				//记录Table宽度
				//table = tTD; while (table.tagName != ‘TABLE') table = table.parentElement;
				//tTD.tableWidth = table.offsetWidth;
			};
			table.rows[0].cells[j].onmouseup = function() {
				//结束宽度调整
				if (tTD == undefined)
					tTD = this;
				tTD.mouseDown = false;
				tTD.style.cursor = 'default';
			};
			table.rows[0].cells[j].onmousemove = function() {
				//更改鼠标样式
				if (event.offsetX > this.offsetWidth - 10)
					this.style.cursor = 'col-resize';
				else
					this.style.cursor = 'default';
				//取出暂存的Table Cell
				if (tTD == undefined)
					tTD = this;
				//调整宽度
				if (tTD.mouseDown != null && tTD.mouseDown == true) {
					tTD.style.cursor = 'default';
					if (tTD.oldWidth + (event.x - tTD.oldX) > 0)
						tTD.width = tTD.oldWidth + (event.x - tTD.oldX);
					//调整列宽
					tTD.style.width = tTD.width;
					tTD.style.cursor = 'col-resize';
					//调整该列中的每个Cell
					table = tTD;
					while (table.tagName != 'TABLE')
						table = table.parentElement;
					for (j = 0; j < table.rows.length; j++) {
						table.rows[j].cells[tTD.cellIndex].width = tTD.width;
					}
					//调整整个表
					//table.width = tTD.tableWidth + (tTD.offsetWidth – tTD.oldWidth);
					//table.style.width = table.width;
				}
			};
		}
	</script>

</body>
</html>