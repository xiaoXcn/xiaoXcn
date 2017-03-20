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
<form action="/xknowledge/editSaveBookInfoServlet" enctype="multipart/form=data" method="POST">
<input type="hidden" id="id" name="id" value="${book.id }" />
<table>
<c:if test=""></c:if>
	<tr>
		<td>书名：<input type="text" name="name" value="${book.name }" /></td>
		<td>作者：<input type="text" name="author" value="${book.author }" /></td>
	</tr>
	<tr>
		<td>书英文名：<input type="text" name="enName" value="${book.enName }" /></td>
		<td>出版时间：<input type="text" name="publishDate" value="${book.publishDate }" onClick="WdatePicker({readOnly:true,dateFmt:'yyyy',maxDate:'%y'})"/></td>
	</tr>
	<tr>
		<td>
			类型：
				<select name="type">
					<option value="">==请选择类型==</option>
					<c:forEach items="${applicationScope.bookClassifyList }" var="bookClassify">
					<option value="${bookClassify.classifyCode }" <c:if test="${book.type == bookClassify.classifyCode}">selected="selected"</c:if>>${bookClassify.classifyName }</option>
					</c:forEach>
				</select>
		</td>
		<td>封面：<input type="file" name="cover"/></td>
	</tr>
</table>
<div class="subnav">资源信息</div>
<table>
	<tr>
		<td>百科:<input type="text" name="urlBaike" value="${book.bookPlus.urlBaike }" /></td>
		<td>豆瓣:<input type="text" name="urlDouban" value="${book.bookPlus.urlDouban }" /></td>
	</tr>
	<tr>
		<td>云盘:<input type="text" name="urlYunpan" value="${book.bookPlus.urlYunpan }" /></td>
		<td>密码:<input type="text" name="downloadPwd" value="${book.bookPlus.downloadPwd }" /></td>
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