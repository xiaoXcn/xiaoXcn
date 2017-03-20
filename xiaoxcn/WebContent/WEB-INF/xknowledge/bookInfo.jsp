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
<table>
	<tr>
		<td rowspan="2"><img src="${book.cover }" /><a href="${xpath }/xknowledge/downloadCoverServlet?cover=${book.cover }">下载</a></td>
		<td>书名:${book.name }</td>
	</tr>
	<tr>
		<td>作者:${book.author }</td>
	</tr>
	<tr>
		<td>书英文名:${book.enName }</td>
		<td>出版时间:${book.publishDate }</td>
	</tr>
	<tr>
		<td>类型:
				<c:forEach items="${applicationScope.bookClassifyList }" var="bookClassify">
					<c:if test="${bookClassify.classifyCode == book.type }">${bookClassify.classifyName }</c:if>
				</c:forEach>
		</td>
		<td></td>
	</tr>
</table>
<div class="subnav">资源信息</div>
<table>
	<tr>
		<td>百科:${book.bookPlus.urlBaike }</td>
		<td>豆瓣:${book.bookPlus.urlDouban }</td>
	</tr>
	<tr>
		<td>云盘:${book.bookPlus.urlYunpan }</td>
		<td>密码:${book.bookPlus.downloadPwd }</td>
	</tr>
</table>
</div>
<script type="text/javascript">
window.onload = function(){
}
</script>
</body>
</html>