<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid;
	border-collapse: collapse;
	text-align: center;
}

td {
	width: 125px;
	height: 25px;
}
</style>

</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<br>
	<center>
		<a href="RoleAction_addRole">增加角色</a> <br>
		<s:if test="allRoles.isEmpty()">
			暂时没有任何的角色
		</s:if>
		<s:else>
			<table>
				<tr>
					<td>roleName</td>
					<td>roleValue</td>
					<td>roleDesc</td>
					<td></td>
					<td></td>
				</tr>
				<s:iterator value="allRoles">
					<tr>
						<td><s:property value="roleName" /></td>
						<td><s:property value="roleValue" /></td>
						<td><s:property value="roleDesc" /></td>
						<td><s:a href="RoleAction_editRole?id=%{id}">查看</s:a></td>
						<td><s:a href="RoleAction_deleteRole?id=%{id}">删除</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</s:else>
	</center>
</body>
</html>