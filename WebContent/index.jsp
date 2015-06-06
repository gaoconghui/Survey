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
		<h3>this is indexPage</h3>
		<s:if test="#session['user']!=null">
		<p>你好，${ session['user'].nickName}</p>
		</s:if>
		<s:else>
		<s:form action="LoginAction_doLogin.action">
			<table>
			<tr>
				<td>email</td>
				<td><s:textfield name="email" value="381147882@qq.com"></s:textfield></td>
				<s:actionerror/>
			</tr>
			<tr>
				<td>password</td>
				<td><s:password name="password" value="123456"></s:password></td>
			</tr>
			<tr>
				<td><s:submit></s:submit></td>
			</tr>
			</table>
		</s:form>
		</s:else>
	</center>
</body>
</html>