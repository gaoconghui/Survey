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
				<td>id</td>
				<td>operator</td>
				<td>operName</td>
				<td>operParams</td>
				<td>operResult</td>
				<td>resultMsg</td>
				<td>orerTime</td>
			</tr>
			<s:iterator value="allLog">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="operator" /></td>
					<td><s:property value="operName" /></td>
					<td><span title='<s:property value="operParams" />'> <s:property
								value="@com.survey.util.StringUtil@getDescString(operParams)" />
					</span></td>
					<td><span title='<s:property value="operResult" />'> <s:property
								value="@com.survey.util.StringUtil@getDescString(operResult)" />
					</span></td>
					<td><span title='<s:property value="resultMsg" />'> <s:property
								value="@com.survey.util.StringUtil@getDescString(resultMsg)" />
					</span></td>
					<td><s:property value="operTime" /></td>
				</tr>
			</s:iterator>
		</table>
	</center>
</body>
</html>