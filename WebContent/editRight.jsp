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
		<br>
		<p align="left"> 保存/更新权限</p>
		<s:form action="RightAction_saveOrUpdateRight">
			<table>
			<s:hidden name="id"></s:hidden>
				<tr>
					<td>权限名称:</td>
					<td><s:textfield name="rightName"></s:textfield></td>
				</tr>
				<tr>
					<td>权限URL:</td>
					<td><s:textfield name="rightUrl"></s:textfield></td>
				</tr>
				<tr>
					<td>权限描述:</td>
					<td><s:textfield name="rightDesc"></s:textfield></td>
				</tr>
				<tr>
					<td><s:submit value="提交"></s:submit></td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>