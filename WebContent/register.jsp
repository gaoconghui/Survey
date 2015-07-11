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
		<h3>this is registerPage</h3>
		<s:form action="RegAction_doReg.action">
			<table cellpadding="10" cellspacing="0">
				<tr>
					<td>邮箱</td>
					<td><s:textfield name="email"></s:textfield></td>
					<td><s:fielderror>
							<s:param>email</s:param>
						</s:fielderror></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><s:password name="password"></s:password></td>
					<td><s:fielderror>
							<s:param>password</s:param>
						</s:fielderror></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><s:password name="confirmPassword"></s:password></td>
					<td><s:fielderror>
							<s:param>confirmPassword</s:param>
						</s:fielderror></td>
				</tr>
				<tr>
					<td>昵称</td>
					<td><s:textfield name="nickName"></s:textfield></td>
					<td><s:fielderror>
							<s:param>nickName</s:param>
						</s:fielderror></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit></s:submit></td>
				</tr>
			</table>

		</s:form>
	</center>
</body>
</html>