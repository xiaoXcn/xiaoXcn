<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" href="common/js/dtree/dtree.css" type="text/css" />
<script type="text/javascript" src="common/js/dtree/dtree.js"></script>
</head>
<frameset rows="10%,75%,15%">
	<frame src="${xpath}/common/top.jsp" name="top">
	<frameset cols="20%,80%">
		<frame src="${xpath}/common/left.jsp">
		<frame src="${xpath}/common/main.jsp">
	</frameset>
	<frame src="${xpath}/common/buttom.jsp">
</frameset>

<body>

</body>
</html>