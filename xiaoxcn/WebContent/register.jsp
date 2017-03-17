<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sign up</title>
<link rel="stylesheet" type="text/css" href="${xpath }/css/login.css" />
</head>
<body>
<div class="logindiv">
	<div class="logintitle">sign up</div>
<form action="/xiaoxcn/registerServlet" method="post">
	<table>
		<tr>
			<td class="left-td">帐号:</td>
			<td class="right-td"><input type="text" id="account" name="account" /><span id="accountMsg"></span></td>
		</tr>
		<tr>
			<td class="left-td">密码:</td>
			<td class="right-td"><input type="password" id="password" name="password" /><span id="passwordMsg"></span></td>
		</tr>
		<tr>
			<td class="left-td">确认密码:</td>
			<td class="right-td"><input type="password" id="passwordRep" name="passwordRep" /><span id="passwordRepMsg"></span></td>
		</tr>
		<tr>
			<td class="left-td">姓名:</td>
			<td class="right-td"><input type="text" id="name" name="name" /><span id="nameMsg"></span></td>
		</tr>
		<tr>
			<td class="left-td">性别:</td>
			<td class="right-td"><input type="radio" id="gender" name="gender" value="1" checked="checked" />男<input type="radio" name="gender" value="0" />女</td>
		</tr>
		<tr>
			<td class="left-td">出生日期:</td>
			<td class="right-td"><input type="text" id="birthday" name="birthday" onClick="WdatePicker({readOnly:true,dateFmt:'yyyy',maxDate:'%y'})" /></td>
		</tr>
		<tr>
			<td class="left-td">手机号:</td>
			<td class="right-td"><input type="text" id="phoneNumber" name="phoneNumber" /><span id="phoneNumberMsg"></span></td>
		</tr>
		<tr>
			<td class="left-td">邮箱:</td>
			<td class="right-td"><input type="text" id="email" name="email" /><span id="emailMsg"></span></td>
		</tr>
		<tr><td class="left-td"></td><td class="right-td"><input type="reset" name="reset" value="重置" />&nbsp;&nbsp;<input type="submit" id="submitBtn" name="submit" value="提交" /></td></tr>
		
		</table>
	</form>
	<span>已有帐号？<a href="${xpath }/login.jsp">点击登录</a></span>
</div>

<script type="text/javascript" src="${xpath }/" ></script>
</body>
</html>