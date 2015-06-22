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
		<h3>this is surveyListPage</h3>
		<s:if test="mySurveys.isEmpty() == true">
			您目前还没有任何问卷
		</s:if>
		<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>调查标题</td>
				<td>创建时间</td>
				<td>状态</td>
				<td>设计</td>
				<td>收集信息</td>
				<td>分析</td>
				<td>打开/关闭</td>
				<td>清除调查</td>
				<td>删除</td>
			</tr>
			<s:iterator value="mySurveys" var="s">
			<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="title"/></td>
				<td><s:date name="createTime" format="MM月dd日 HH:mm:ss"/></td>
				<td><s:property value="closed ?'关闭':'开启'"/></td>
				<td><a href="SurveyAction_designSurvey?sid=<s:property value="id"/>">设计</a></td>
				<td>收集信息</td>
				<td>分析</td>
				<td><a href="SurveyAction_switchClose?sid=<s:property value="id"/>">打开/关闭</a></td>
				<td><a href="SurveyAction_clearSurvey?sid=<s:property value="id"/>">清除调查</a></td>
				<td><a href="SurveyAction_deleteSurvey?sid=<s:property value="id"/>">删除</a></td>
			</tr>
			</s:iterator>
		</table>
		</s:else>
	</center>
</body>
</html>