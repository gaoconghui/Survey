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
		<table>
			<tr>
				<td></td>
				<s:iterator value="qsm.question.matrixColTitleArr">
					<td><s:property /></td>
				</s:iterator>
			</tr>
			<s:iterator value="qsm.question.matrixRowTitleArr" status="rowst">
				<tr>
					<td><s:property /></td>
					<s:iterator value="qsm.question.matrixColTitleArr" status="colst">
						<td><s:property value="optionStr[#rowst.index][#colst.index]" /></td>
					</s:iterator>
				</tr>
			</s:iterator>
		</table>

	</center>
</body>
</html>