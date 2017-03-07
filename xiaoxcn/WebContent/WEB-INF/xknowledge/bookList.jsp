<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${xpath }/css/xknowledge/bookList.css" />
</head>
<body>
<div class="contaier">
<form>
	<table class="search-table">
		<caption>查询</caption>
		<tr>
			<td>书名:<input type="text" name="name" /></td>
			<td>作者:<input type="text" name="author" /></td>
		</tr>
		<tr>
			<td>出版日期:<input type="text" name="startTime" />-<input type="text" name="endTime" /></td>
			<td>类型:<input type="text" name="type" /></td>
		</tr>
	</table>
	<div class="search-btn">
		<input type="reset" name="resetForm" value="重置" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submitForm" value="查询" />
	</div>
</form>
	<table class="search-table">
		<caption>查询</caption>
	</table>
</div>
<table>
</table>
<div>
</div>
</body>
</html>