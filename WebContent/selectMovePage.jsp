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
		<table border="1" cellpadding="10" cellspacing="0">
			<s:iterator value="mySurveys" var="s">
				<tr>
					<td><s:property value="#s.title" /></td>
				</tr>

				<s:iterator value="#s.pages" var="p">
					<s:set value="#p.id" var="pid"></s:set>
					<s:if test="srcpid == #pid">
						<s:set var="bgcolor" value='"red"'></s:set>
					</s:if>
					<s:else>
						<s:set var="bgcolor" value='"white"'></s:set>
					</s:else>
					
					<tr bgcolor='<s:property value="#bgcolor" />'>
						<td><s:property value="title" /></td>
						<s:if test="srcpid != #pid">
							<td>
								<s:form action="CopyOrMoveAction_doMove">
									<s:hidden name="srcpid"></s:hidden>
									<s:hidden name="tagpid" value="%{#pid}"></s:hidden>
									<s:hidden name="sid" value="%{#s.id}"></s:hidden>
									<s:radio list="#{0:'之前',1:'之后'}" listKey="key" listValue="value" name="pos"></s:radio>
									<s:submit value="确认"></s:submit>
								</s:form>
							</td>
						</s:if>
					</tr>
				</s:iterator>

			</s:iterator>

		</table>
	</center>
</body>
</html>