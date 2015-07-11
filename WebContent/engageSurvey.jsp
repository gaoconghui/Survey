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
		<br> <br>
		<s:if test="mySurveys.isEmpty()">
		您未参与调查
	</s:if>
		<s:else>
		<s:set var="index" value="0"></s:set>
		<s:set var="allSurvey" value="mySurveys.size()"></s:set>
			<table>
				<s:iterator begin="0" end="#allSurvey-1" step="5" var="no">
					<tr>
						<s:if test="#index < #allSurvey">
							<s:iterator begin="#index" end="#index +4 <#allSurvey-1?#index+4:#allSurvey-1" step="1">
								<td>
									<img  src='<s:url value="%{mySurveys[#index].getLogopath()}"></s:url>' width="50" height="25">
									<s:a href="EngageSurveyAction_doEngageSurvey?sid=%{mySurveys[#index].getId()}"><s:property value="mySurveys[#index].getTitle()"/></s:a>
								</td>
								<s:set var="index" value="#index +1"></s:set>
							</s:iterator>
						</s:if>
					</tr>
				</s:iterator>
			</table>
		</s:else>
	</center>
</body>
</html>