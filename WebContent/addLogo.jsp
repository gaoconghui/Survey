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

	<br>
	<br>
	<center>
		<s:form action="SurveyAction_addLogo.action" enctype="multipart/form-data">
		<s:hidden name="sid"></s:hidden>
			<s:file name="logoPhoto" ></s:file>
			<br>
			<s:fielderror name="logoPhoto"></s:fielderror>
			<br>
			<s:submit></s:submit>
		</s:form>
	</center>
</body>
</html>