<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${xpath }/css/xknowledge/kno-common.css" />
<link type="text/css" rel="stylesheet" href="${xpath }/css/xknowledge/addBook.css" />
</head>
<body>
<div class="container">
<div class="subnav">基本信息</div>
<table>
	<tr>
		<td>书名:${book.name }</td>
		<td>作者:${book.author }</td>
	</tr>
	<tr>
		<td>书英文名:${book.enName }</td>
		<td>出版时间:${book.publishDate }</td>
	</tr>
	<tr>
		<td>类型:${book.type }</td>
		<td></td>
	</tr>
</table>
<div class="subnav">资源信息</div>
<table>
	<tr>
		<td>百科:${book.urlBaike }</td>
		<td>豆瓣:${book.urlDouban }</td>
	</tr>
	<tr>
		<td>云盘:${book.urlYunpan }</td>
		<td>密码:${book.downloadPwd }</td>
	</tr>
</table>
</div>
</body>
</html>