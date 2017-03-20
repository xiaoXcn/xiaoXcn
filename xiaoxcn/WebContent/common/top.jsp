<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.bar{background-color:#000000;color:#FFFFFF;line-height:30px;}
.logo{margin-left:20px;float:left;}
.logo-text{margin-left:90%;}
.page-title{font-size:45px;text-align:center;}
</style>
</head>
<body>
<div class="bar">
	<div class="logo">xiaoXcn for all system</div>
	<div class="logo-text">欢迎您!${sessionScope.name }</div>
</div>
<div class="page-title">xiaoXcn后台管理系统</div>
</body>
</html>