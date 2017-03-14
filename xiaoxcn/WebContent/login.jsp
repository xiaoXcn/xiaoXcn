<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sign in</title>
<link rel="stylesheet" type="text/css" href="${xpath }/css/login.css" />
</head>
<body>
<div class="logindiv">
	<div class="logintitle">sign in</div>
	<div>${msg }</div>
<form action="${xpath }/xiaoxcn/loginServelt" method="post">
	<table>
	<tr>
		<td class="left-td">user:</td><td class="right-td"><input type="text" name="user" /><br /></td>
	</tr>
	<tr>
		<td class="left-td">password:</td><td class="right-td"><input type="password" name="password" /> <br /></td>
	</tr>
	<tr>
		<td class="left-td">&nbsp;</td>
		<td class="right-td"><input type="reset" value="重置" />&nbsp;<input type="submit" value="登录" /></td>
	</tr>
	</table>
	<div class="logintips">还没有帐号？<a href="${xpath }/register.jsp">点击注册</a></div>
</form>
</div>
</body>
</html>