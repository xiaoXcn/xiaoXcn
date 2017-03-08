<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<frameset rows="10%,85%,5%">
	<frame src="${xpath}/common/top.jsp" name="top">
	<frameset cols="20%,80%">
		<frame src="${xpath}/common/left.jsp" name="left">
		<frame src="${xpath}/common/main.jsp" name="main">
	</frameset>
	<frame src="${xpath}/common/bottom.jsp" name="bottom">
</frameset>

<body>

</body>
</html>