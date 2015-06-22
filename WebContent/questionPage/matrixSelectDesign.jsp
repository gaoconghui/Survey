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
	<jsp:include page="/top.jsp"></jsp:include>

	<center>
		<h3>矩阵型问题设计</h3>
		<s:form action="QuestionAction_updateQuestion">
			<s:hidden name="sid"></s:hidden>
			<s:hidden name="pid"></s:hidden>
			<s:hidden name="id"></s:hidden>
			<s:hidden name="questionType"></s:hidden>
			<table>
				<tr>
					<td>问题标题：</td>
					<td><s:textfield name="title"></s:textfield></td>
				</tr>
				<tr>
					<td>行标题标签组：</td>
					<td><s:textarea cols="30" rows="5" name="matrixRowTitle"></s:textarea></td>
				</tr>
				<tr>
					<td>列标题标签组：</td>
					<td><s:textarea cols="30" rows="5" name="matrixColTitle"></s:textarea></td>
				</tr>
				<tr>
					<td>下拉列表选项：</td>
					<td><s:textarea cols="30" rows="5" name="matrixSelectOptions"></s:textarea></td>
				</tr>
				<tr>
					<td><s:submit></s:submit></td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>