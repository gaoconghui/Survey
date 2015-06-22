<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>

	<center>
		<h3>this is addPage</h3>
		<s:form action="PageAction_saveOrUpadatePage">
		<s:hidden name="sid"></s:hidden>
		<table>
				<s:hidden name="id"></s:hidden>
				<tr>
				<td>页面名称</td>
				<td><s:textfield name="title"></s:textfield></td>
			</tr>
			<tr>
				<td>描述信息</td>
				<td><s:textarea name="description" cols="13" rows="10" ></s:textarea></td>
			</tr>
			<tr>
				<td><s:submit></s:submit></td>
			</tr>
		</table>
		</s:form>
	</center>
</body>
</html>