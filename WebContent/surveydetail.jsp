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
	<s:set var="sid" value="id"></s:set>
	<center>
		<h3>this is surveyDetail</h3>
		<s:form action="SurveyAction_updateServey?sid=%{#sid}">

			<table>
				<s:hidden name="id"></s:hidden>
				<s:hidden name="createTime"></s:hidden>
				<tr>
					<td>调查标题</td>
					<td><s:textfield name="title"></s:textfield></td>
				</tr>
				<tr>
					<td>上一步</td>
					<td><s:textfield name="preText"></s:textfield></td>
				</tr>
				<tr>
					<td>下一步</td>
					<td><s:textfield name="nextText"></s:textfield></td>
				</tr>
				<tr>
					<td>退出</td>
					<td><s:textfield name="editTest"></s:textfield></td>
				</tr>
				<tr>
					<td>完成</td>
					<td><s:textfield name="doneText"></s:textfield></td>
				</tr>
				<tr>
					<td><s:submit></s:submit></td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>