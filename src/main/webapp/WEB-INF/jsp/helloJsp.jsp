<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<script type="text/javascript" src="webjars/jquery/1.11.3/jquery.js"></script>
	</head>

	<body class="color_1">
	    helloJsp
	    <hr>
	    ${hello}
	</body>
	
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript">
		$(function(){
			test1();
		})
	</script>
	
</html>