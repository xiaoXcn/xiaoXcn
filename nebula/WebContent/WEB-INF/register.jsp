<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
</head>
<body>
<div>
	<div>
		Sign up
	</div>
	<div>
		<form action="/entAccount/doRegister.do" method="post">
			Account:<input type="text" name="entAccount" />
			Email:<input type="text" name="entEmail" />
			Password:<input type="password" name="accountPwd" />
			repeat Password:<input type="password" name="accountPwdRepeat" />
		</form>
	</div>
	<div>
	other
	</div>
</div>
</body>
</html>