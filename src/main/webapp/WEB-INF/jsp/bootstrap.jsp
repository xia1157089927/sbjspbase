<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   	<head>
    	<title>Bootstrap 模板</title>
      	<meta name="viewport" content="width=device-width, initial-scale=1.0">
      	<!-- 引入 Bootstrap -->
      	<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
 
      	<!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      	<!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      	<!--[if lt IE 9]>
         	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      	<![endif]-->
   	</head>
	<body>
		<h1>Hello, world!</h1>
	 
		<h1>我是标题1 h1</h1>
		<h2>我是标题2 h2</h2>
		<h3>我是标题3 h3</h3>
		<h4>我是标题4 h4</h4>
		<h5>我是标题5 h5</h5>
		<h6>我是标题6 h6</h6>

		<h2>引导主体副本</h2>
		<p class="lead">
			这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。
			这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。
	  	</p>
	      
		<small>本行内容是在标签内</small><br>
		<strong>本行内容是在标签内</strong><br>
		<em>本行内容是在标签内，并呈现为斜体</em><br>
		<p class="text-left">向左对齐文本</p>
		<p class="text-center">居中对齐文本</p>
		<p class="text-right">向右对齐文本</p>
		<p class="text-muted">本行内容是减弱的</p>
		<p class="text-primary">本行内容带有一个 primary class</p>
		<p class="text-success">本行内容带有一个 success class</p>
		<p class="text-info">本行内容带有一个 info class</p>
		<p class="text-warning">本行内容带有一个 warning class</p>
		<p class="text-danger">本行内容带有一个 danger class</p>
		      
		</body>
	    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
	    <script type="text/javascript" src="webjars/jquery/1.11.3/jquery.js"></script>
	    <!-- 包括所有已编译的插件 -->
	    <script src="js/bootstrap/bootstrap.min.js"></script>
</html>