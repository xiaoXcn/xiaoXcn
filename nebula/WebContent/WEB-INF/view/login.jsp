<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<form action="${path}/entAccount/doLogin.do" method="post">
	user:<input type="text" name="account" />
	password:<input type="password" name="accountPwd" />
	<input type="submit" value="Sign in" />
</form>
</div>
</body>
</html>