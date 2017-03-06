<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Signup</title>
</head>
<body>
<div class="sign-up-div">
	<div>
		Sign up
	</div>
	<div>
		<form action="${path}/entAccount/doRegister.do" method="post">
			Account:<input type="text" name="account" />
			Password:<input type="password" name="accountPwd" />
			repeat Password:<input type="password" name="accountPwdRepeat" />
			<input type="submit" value="submit" />
		</form>
	</div>
	<div>
	${path}
	</div>
</div>
</body>
</html>