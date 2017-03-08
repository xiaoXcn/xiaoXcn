<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
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
<form action="${xpath }/xknowledge/addSaveBookInfoServlet" method="POST">
<table>
	<tr>
		<td>书名：<input type="text" name="name" /></td>
		<td>作者：<input type="text" name="author" /></td>
	</tr>
	<tr>
		<td>书英文名：<input type="text" name="enName" /></td>
		<td>出版时间：<input type="text" name="publishDate" /></td>
	</tr>
	<tr>
		<td>
			类型：<select name="type">
				<option value="">==请选择类型==</option>
				<option value="Java">Java</option>
				<option value="WEB前端">WEB前端</option>
				<option value="Linux">Linux</option>
				<option value="C#">C#</option>
				<option value="其他">其他</option>
			</select>
		</td>
		<td></td>
	</tr>
</table>
<div class="subnav">资源信息</div>
<table>
	<tr>
		<td>百科：<input type="text" name="urlBaike" /></td>
		<td>豆瓣：<input type="text" name="urlDouban" /></td>
	</tr>
	<tr>
		<td>云盘：<input type="text" name="urlYunpan" /></td>
		<td>密码：<input type="text" name="downloadPwd" /></td>
	</tr>
</table>

<div class="subDiv">
	<input type="reset" name="retBtn" value="重置" />&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="subBtn" value="提交" />
</div>
</form>
</div>
</body>
</html>