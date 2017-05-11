<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html class="no-js">
	<head>
		<meta charset="utf-8">
	  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	  	<title>查询车型数据</title>
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<meta name="renderer" content="webkit">
	  	<meta http-equiv="Cache-Control" content="no-siteapp" />
	  	<link rel="icon" type="image/png" href="amaze_ui/assets/i/favicon.png">
	  	<link rel="apple-touch-icon-precomposed" href="amaze_ui/assets/i/app-icon72x72@2x.png">
	  	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	  	<link rel="stylesheet" href="amaze_ui/assets/css/amazeui.min.css"/>
	  	<link rel="stylesheet" href="amaze_ui/assets/css/admin.css">
	</head>
	<body>
		<!--[if lte IE 9]>
		<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
		  以获得更好的体验！</p>
		<![endif]-->
		<header class="am-topbar am-topbar-inverse admin-header">
		  <div class="am-topbar-brand">
		    <strong>Amaze UI</strong> <small>后台管理-车型</small>
		  </div>
		
		  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>
		
		  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
		
		    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
		      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
		      <li class="am-dropdown" data-am-dropdown>
		        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
		          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
		        </a>
		        <ul class="am-dropdown-content">
		          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
		          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
		          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
		        </ul>
		      </li>
		      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
		    </ul>
		  </div>
		</header>
		
		<div class="am-cf admin-main">
			<!-- sidebar start -->
		  	<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
		   		<div class="am-offcanvas-bar admin-offcanvas-bar">
		      		<ul class="am-list admin-sidebar-list">
		        		<li><a href="admin-index.html"><span class="am-icon-home"></span> 首页</a></li>
		        		<li class="admin-parent">
		          			<a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
		          			<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
				            	<li><a href="admin-user.html" class="am-cf"><span class="am-icon-check"></span> 个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
					            <li><a href="admin-help.html"><span class="am-icon-puzzle-piece"></span> 帮助页</a></li>
					            <li><a href="admin-gallery.html"><span class="am-icon-th"></span> 相册页面<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
					            <li><a href="admin-log.html"><span class="am-icon-calendar"></span> 系统日志</a></li>
					            <li><a href="admin-404.html"><span class="am-icon-bug"></span> 404</a></li>
				            </ul>
		        		</li>
		        		<li><a href="admin-table.html"><span class="am-icon-table"></span> 表格</a></li>
		        		<li><a href="admin-form.html"><span class="am-icon-pencil-square-o"></span> 表单</a></li>
		        		<li><a href="#"><span class="am-icon-sign-out"></span> 注销</a></li>
		      		</ul>
				</div>
				<!-- sidebar end -->
			</div>
			
			<!-- content start -->
	  		<div class="admin-content">
	  			<div class="admin-content-body">
					<div class="am-cf am-padding am-padding-bottom-0">
			        	<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">表格</strong> / <small>省市区数据</small></div>
			      	</div>
	  			</div>
		        <div class="am-g">
		        	<div class="am-u-sm-12 am-u-md-6">
			        	<div class="am-btn-toolbar">
				            <div class="am-btn-group am-btn-group-xs">
			              		<button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
				              	<button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
				              	<button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 审核</button>
				              	<button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
				            </div>
			          	</div>
			        </div>
			        <div class="am-u-sm-12 am-u-md-3">
			        	<div class="am-form-group">
				            <select data-am-selected="{btnSize: 'sm'}">
					            <option value="option1">所有类别</option>
					            <option value="option2">IT业界</option>
					            <option value="option3">数码产品</option>
					            <option value="option3">笔记本电脑</option>
					            <option value="option3">平板电脑</option>
					            <option value="option3">只能手机</option>
					            <option value="option3">超极本</option>
				            </select>
			        	</div>
			        </div>
			        <div class="am-u-sm-12 am-u-md-3">
		          		<div class="am-input-group am-input-group-sm">
			            	<input type="text" class="am-form-field">
			          		<span class="am-input-group-btn">
		           	 			<button class="am-btn am-btn-default" type="button">搜索</button>
			          		</span>
			          	</div>
			        </div>
		        </div>
	  			
	  			<div class="am-g">
        			<div class="am-u-sm-12">
          				<form class="am-form">
          					<table class="am-table am-table-striped am-table-hover table-main">
          						<thead>
             				 		<tr>
                						<th class="table-check"><input type="checkbox" /></th>
                						<th class="table-id">ID</th><th class="table-title">标题</th>
                						<th class="table-type">类别</th>
                						<th class="table-author am-hide-sm-only">作者</th>
                						<th class="table-date am-hide-sm-only">修改日期</th>
                						<th class="table-set">操作</th>
			              			</tr>
			              		</thead>
			              		<tbody>
			              			<c:forEach begin="1" end="100" step="1" var="stepIndex">
			              				<tr>
	                						<th class="table-check"><input type="checkbox" /></th>
	                						<th class="table-id">ID</th><th class="table-title">标题_${stepIndex}</th>
	                						<th class="table-type">类别_${stepIndex}</th>
	                						<th class="table-author am-hide-sm-only">作者_${stepIndex}</th>
	                						<th class="table-date am-hide-sm-only">修改日期_${stepIndex}</th>
	                						<th class="table-set">操作_${stepIndex}</th>
				              			</tr>
			              			</c:forEach>
			              		</tbody>
          					</table>
          				</form>
        			</div>
       			</div>
	  			
		  		<footer class="admin-content-footer">
			      <hr>
			      <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
			    </footer>
		  	</div>
		  	<!-- content end -->
		</div>
	  	
	  	<!--[if lt IE 9]>
		<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
		<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
		<![endif]-->
		
		<!--[if (gte IE 9)|!(IE)]><!-->
		<script type="text/javascript" src="webjars/jquery/1.11.3/jquery.js"></script>
		<!--<![endif]-->
		<script src="amaze_ui/assets/js/amazeui.min.js"></script>
		<script src="amaze_ui/assets/js/app.js"></script>
	</body>
</html>