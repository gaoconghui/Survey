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
		<table>
			<tr>
				<td>name</td>
				<td>email</td>
				<td>nickName</td>
				<td></td>
				<td></td>
			</tr>
			<s:iterator value="allUsers">
				<tr>
					<td><s:property value="name" /></td>
					<td><s:property value="email" /></td>
					<td><s:property value="nickName" /></td>
					<td><s:a href="UserAuthorizeAction_editUser?id=%{id}">查看</s:a></td>
					<td><s:a href="UserAuthorizeAction_clearAuthorize?id=%{id}">清除权限</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</center>
</body>
</html>