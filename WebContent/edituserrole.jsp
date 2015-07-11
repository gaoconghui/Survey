<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
td {
	height: 25px;
}
</style>

</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<br>
	<center>
		<s:form action="UserAuthorizeAction_updateUserRole">
			<table
				style="border: 1px solid; border-collapse: collapse; text-align: center;">
				<tr>
					<td>名称</td>
					<td>昵称</td>
					<td>邮箱</td>
				</tr>
				<tr>
					<s:hidden name="id"></s:hidden>
					<td><s:textfield name="name" readonly="true"></s:textfield></td>
					<td><s:textfield name="nickName" readonly="true"></s:textfield></td>
					<td><s:textfield name="email" readonly="true"></s:textfield></td>
				</tr>
			</table>
			<br> <br>
			<div style="width: 300px; height: 225px; overflow: scroll;">
				<table>
					<tr>
						<td valign="top" align="left" width="80"><s:iterator
								value="inRangeRoles">
								<s:property value="roleName" />
								<input type="checkbox" name='userRole'
									value='<s:property value="id"/>' checked="checked"/>
								<br>
							</s:iterator></td>
						<td valign="top" align="right" width="80"><s:iterator
								value="outRangeRoles">
								<s:property value="roleName" />
								<input type="checkbox" name='userRole'
									value='<s:property value="id"/>' />
								<br>
							</s:iterator></td>
					</tr>
				</table>
			</div>
			<br>
			<s:submit></s:submit>
		</s:form>

	</center>
</body>
</html>