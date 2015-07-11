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

	<s:set var="sid" value="id"></s:set>
	<jsp:include page="top.jsp"></jsp:include>
	<center>
		<h3>this is analysisSurvey Page</h3>


		<table>
			<s:iterator value="pages" var="page">
				<tr>
					<td><s:property value="#page.title" /></td>
				</tr>
				<s:iterator value="#page.questions" var="question" status="qst">
					<s:set var="qid" value="#question.id"></s:set>
					<s:set var="questionType" value="#question.questionType"></s:set>
					<tr>
						<td><s:property value="#qst.index + '.' + #question.title" /></td>
						<td><s:if test="#questionType > 5">
								<s:form action="MartixSattisticsAction">
									<s:hidden name="qid" value="%{#qid}"></s:hidden>
									<s:submit value="查看矩阵型统计结果"></s:submit>
								</s:form>
							</s:if> <s:else>
								<s:form action="ChartOutputAction">
									<s:select
										list="#{0:'平面饼图',2:'立体饼图',3:'横向平面柱状图',
													  4:'纵向平面柱状图',5:'横向立体柱状图',6:'纵向立体柱状图',7:'立体折线图' }"
										listKey="key" listValue="value"></s:select>
									<s:hidden name="qid" value="%{#qid}"></s:hidden>
									<s:submit value="查看"></s:submit>
								</s:form>
							</s:else></td>
					</tr>
				</s:iterator>
			</s:iterator>
		</table>


	</center>
</body>
</html>