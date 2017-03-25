<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="${xpath }/css/login.css" />
</head>
<body>
<s:if test="hasFieldErrors()">
	<s:iterator value="fieldErrors">
		<s:property value="value[0]"></s:property>
	</s:iterator>
</s:if>
<div class="logindiv">
	<div class="logintitle">用户登录</div>
	<div id="errorTip"><s:fielderror/><s:actionerror/></div>
	<div id="messageTip"></div>
<form id="loginForm" action="${xpath }/xiaoxcn/AccountAction_login" method="post">
	<table>
	<tr>
		<td class="left-td">user:</td><td class="right-td"><input type="text" id="account" name="account.account" /><br /></td>
	</tr>
	<tr>
		<td class="left-td">password:</td><td class="right-td"><input type="password" id="password" name="account.password" /> <br /></td>
	</tr>
	<tr>
		<td class="left-td">&nbsp;</td>
		<td class="right-td"><input type="reset" value="重置" />&nbsp;<input type="submit" id="submitBtn"  value="登录" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="checkbox" name="autoLogin" value="autoLogin" />自动登录</td>
	</tr>
	</table>
	<div class="logintips">还没有帐号？<a href="${xpath }/register.jsp">点击注册</a></div>
</form>
</div>
<script type="text/javascript" src="${xpath }/common/js/commonValidate.js" ></script>

</body>
</html>