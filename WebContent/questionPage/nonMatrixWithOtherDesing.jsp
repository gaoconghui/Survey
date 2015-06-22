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
		<h3>非矩阵型问题设计</h3>
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
					<td>问题选项：</td>
					<td><s:textarea cols="30" rows="5"  name="options"></s:textarea></td>
				</tr>
				<tr>
					<td>是否含有其他选项：</td>
					<td><s:checkbox name="other"></s:checkbox></td>
				</tr>
				<tr>
					<td>其他项类型</td>
					<td><s:radio list="#{0:'无',1:'文本框',2:'下拉列表框' }" name="otherStyle" listKey="key" listValue="value"></s:radio></td>
				</tr>
				<tr>
					<td>其他项下拉表选项：</td>
					<td><s:textarea cols="30" rows="5"  name="otherSelectOptions"></s:textarea></td>
				</tr>
				<tr>
					<td><s:submit></s:submit></td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>