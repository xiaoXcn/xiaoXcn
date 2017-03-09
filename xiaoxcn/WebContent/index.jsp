<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>


<input type="text" id="startTime" name="startTime" onClick="WdatePicker({readOnly:true,dateFmt:'yyyy',maxDate:'%y'})"/>
-<input type="text" id="endTime" name="endTime" onClick="WdatePicker({readOnly:true,dateFmt:'yyyy',maxDate:'2020',minDate:'#F{$dp.$D(\'startTime\')}'})"/>
</body>
</html>