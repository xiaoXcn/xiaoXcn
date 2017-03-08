<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${xpath }/css/xknowledge/kno-common.css" />
<link type="text/css" rel="stylesheet" href="${xpath }/css/xknowledge/bookList.css" />
</head>
<body>
<div class="container">
<form id="searchForm" name="searchForm" action="/xknowledge/queryBookPageServlet" method="POST">
	<div class="subnav">查询</div>
	<input type="hidden" name="currentPage" value="${pager.currentPage }" />
	<input type="hidden" name="totalPage" value="${pager.totalPage }" />
	<table class="search-table">
		<tr>
			<td>书名:<input type="text" id="searchByName" name="name" /></td>
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
	<div class="subnav">书籍列表</div>
	<div class="overallOperate">
		<input type="button" id="addBtn" name="addBtn" value="新增" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" id="bathDelBtn" name="bathDelBtn" value="批量删除" />
	</div>
	<hr />
<form id="delForm" name="delForm" action="/xknowledge/delBookInfoServlet" method="POST">
	<table class="list-table">
		<tr>
			<th><input type="checkbox" id="ckAll" /></th>
			<th>书名</th>
			<th>作者</th>
			<th>出版时间</th>
			<th>类型</th>
			<th>操作</th>
		</tr>
		<c:forEach	items="${pager.list }" var="book">
		<tr>
			<td><input type="checkbox" name="ck" value="${book.id }" /></td>
			<td>${book.name }</td>
			<td>${book.author }</td>
			<td>${book.publishDate }</td>
			<td>${book.type }</td>
			<td>
				<a href="${xpath }/xknowledge/queryBookSigleServlet?id=${book.id }&operType=query">详细</a>
				<a href="${xpath }/xknowledge/queryBookSigleServlet?id=${book.id }&operType=edit">修改</a>
				<a href="${xpath }/xknowledge/delBookInfoServlet?id=${book.id }">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</form>
</div>
<div class="page-div">
<a id="lastPage" href="#">上一页</a>&nbsp;第${pager.currentPage }页/共${pager.totalPage }页&nbsp;<a id="nextPage" href="#">下一页</a>
</div>
<script type="text/javascript">
	window.onload=function(){
		var addBtnEle = document.getElementById("addBtnEle");
		addBtnEle.onclick=function(){
			location.href=webRootPath+"/xknowledge/addBookSkipServlet";
		}
		var ckAllEle = document.getElementById("ckAll");
		var ckEles = document.getElementsByName("ck");
		ckAllEle.onclick = function(){
			for(var i=0;i<ckEles.length;i++){
				ckEles[i].checked = ckAllEle.checked;
			}
		}
		
		var bathDelBtnEle = document.getElementById("bathDelBtn");
		bathDelBtnEle.onclick = function(){
			var delFormEle = document.getElementById("delForm");
			delFormEle.submit();
		}
		
		//翻页
		var lastPageEle = document.getElementById("lastPage");
		var currentPageEle = document.getElementById("currentPage");
		lastPageEle.onclick = function(){
			var currentPage = currentPageEle.value;
			if(currentPage>1){
				currentPageEle.value = currentPage-1;
			}
			var searchFormEle = document.getElementById("searchForm");
			searchFormEle.submit();
		}
		
		var nextPageEle = document.getElementById("nextPage");
		var totalPageEle = document.getElementById("totalPage");
		nextPageEle.onclick = function(){
			var currentPage = currentPageEle.value;
			var totalPage = totalPageEle.value;
			if(currentPage<totalPage){
				currentPageEle.value = currentPage+1;
			}
			var searchFormEle = document.getElementById("searchForm");
			searchFormEle.submit();
		}
		
		var searchByNameEle = document.getElementById("searchByName");
		searchByNameEle.onkeypress = function(){
			var name = searchByNameEle.value;
			
		}
	}
</script>
</body>
</html>