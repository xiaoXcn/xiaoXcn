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
<form action="/xknowledge/editSaveBookInfoServlet" method="POST">
<input type="hidden" id="id" name="id" value="${book.id }" />
<table>
	<tr>
		<td>书名:<input type="text" name="name" value="${book.name }" /></td>
		<td>作者:<input type="text" name="author" value="${book.author }" /></td>
	</tr>
	<tr>
		<td>书英文名:<input type="text" name="enName" value="${book.enName }" /></td>
		<td>出版时间:<input type="text" name="publishDate" value="${book.publishDate }" /></td>
	</tr>
	<tr>
		<td>
			<select name="type">
				<option value="Java">Java</option>
				<option value="WEB前端" <c:if test="${book.type }=='WEB前端' "> selected="selected" </c:if>>WEB前端</option>
				<option value="Linux" <c:if test="${book.type }=='Linux' "> selected="selected" </c:if>>Linux</option>
				<option value="C#" <c:if test="${book.type }=='C#' "> selected="selected" </c:if>>C#</option>
				<option value="其他" <c:if test="${book.type }=='其他' "> selected="selected" </c:if>>其他</option>
			</select>
		</td>
		<td></td>
	</tr>
</table>
<div class="subnav">资源信息</div>
<table>
	<tr>
		<td>百科:<input type="text" name="urlBaike" value="${book.urlBaike }" /></td>
		<td>豆瓣:<input type="text" name="urlDouban" value="${book.urlDouban }" /></td>
	</tr>
	<tr>
		<td>云盘:<input type="text" name="urlYunpan" value="${book.urlYunpan }" /></td>
		<td>密码:<input type="text" name="downloadPwd" value="${book.downloadPwd }" /></td>
	</tr>
</table>

<div>
	<input type="button" id="retBtn" name="retBtn" value="重置" />
	<input type="submit" name="subBtn" value="提交" />
</div>
</form>
</div>
<script type="text/javascript">
	window.onload=function(){
		var retBtnEle = document.getElementById("retBtn");
		retBtnEle.onclick = function(){
			var idEle = document.getElementById("id");
			var id = idEle.value;
			location.href = webRootPath+"/xknowledge/queryBookSigleServlet?id="+id+"&operType=edit";
		}
		
	}
</script>
</body>
</html>