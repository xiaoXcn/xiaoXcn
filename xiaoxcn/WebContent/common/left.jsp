<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.xiaoxcn.domain.*,java.util.*"%>
<%@ include file="taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" href="${xpath }/common/js/dtree/dtree.css" type="text/css" />
<script type="text/javascript" src="${xpath }/common/js/dtree/dtree.js"></script>
</head>
<body>
<div class="dtree">

	<!-- <p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p> -->

	<script type="text/javascript">
		<!--

		d = new dTree('d');
		<% 
		List<NodeEntity> nodeList = (List<NodeEntity>)application.getAttribute("nodeList");
		if(nodeList!=null&&nodeList.size()>0){
			
			for(NodeEntity nodeEntity:nodeList){
				String outPrint = "d.add(";
				if(nodeEntity.getNodeId()!=null&&nodeEntity.getNodeId()!=""){
					outPrint += ("\""+nodeEntity.getNodeId()+"\"");
				}
				outPrint += ",";
				if(nodeEntity.getParentNodeId()!=null&&nodeEntity.getParentNodeId()!=""){
					outPrint += ("\""+nodeEntity.getParentNodeId()+"\"");
				}else{
					outPrint += null;
				}
				outPrint += ",";
				if(nodeEntity.getNodeName()!=null&&nodeEntity.getNodeName()!=""){
					outPrint += ("\""+nodeEntity.getNodeName()+"\"");
				}else{
					outPrint += null;
				}
				outPrint += ",";
				if(nodeEntity.getSkipUrl()!=null&&nodeEntity.getSkipUrl()!=""){
					outPrint += (("\""+request.getContextPath()+nodeEntity.getSkipUrl()+"\""));
				}else{
					outPrint += null;
				}
				outPrint += ",";
				if(nodeEntity.getTitle()!=null&&nodeEntity.getTitle()!=""){
					outPrint += ("\""+nodeEntity.getTitle()+"\"");
				}else{
					outPrint += null;
				}
				outPrint += ",";
				if(nodeEntity.getTarget()!=null&&nodeEntity.getTarget()!=""){
					outPrint += ("\""+nodeEntity.getTarget()+"\"");
				}else{
					outPrint += null;
				}
				outPrint += ");";
				out.println(outPrint);
			}
		}
		%>
		document.write(d);

		//-->
	</script>

</div>

</body>
</html>