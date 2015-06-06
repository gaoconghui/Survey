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

<s:debug></s:debug>
	<center>
		<h3>this is designPage</h3>

		<!-- 问卷层面 -->
		<s:property value="title" />

		<!-- 页面层面 -->
		<s:iterator value="pages" var="page">
			<s:property value="#page.title" />

			<!-- 问题层面 -->
			<s:iterator value="#page.questions" var="question">

				<!-- 问题标题 -->
				<s:property value="#question.title" />
				<!-- 问题选项 -->
				<s:set var="questiontype" value="#question.questionType"></s:set>
				
				<!-- 0，1，2，3， -->
				<s:if test="#questiontype &lt; 4">
					<s:iterator value="#question.optionArr">
						<input type="<s:property value="#questiontype > 1 ?'checkbox':'radio'" />"/>
						<s:if test="#questiontype == 1 || #questiontype == 3"><br></s:if>
					</s:iterator>
					<s:if test="other">
						<input type="<s:property value="#questiontype > 1 ?checkbox:radio" />"/>
						<s:if test="#question.otherStyle == 1">
							<input type="text" />
						</s:if>
						<s:elseif test="#question.otherStyle == 2">
							<s:select list="#question.otherSelectOptionsArr" ></s:select>
						</s:elseif>
					</s:if>				
				</s:if>
				
				
				<!-- 4,5 -->
				<s:elseif test="#questiontype == 4 || #questiontype == 5">
					<s:if test="#questiontype == 4">
						<s:select list="#question.optionArr" ></s:select>
					</s:if>
					<s:elseif test="#questiontype == 5">
						<input type="text" />
					</s:elseif>
				</s:elseif>
				
				
				<!-- 6,7,8 -->
				<s:else>
					<table>
						<tr>
						<td></td>
						<s:iterator value="#question.matrixColTitle">
							<td><s:property/></td>
						</s:iterator>
						</tr>
						<s:iterator value="#question.matrixRowTitle">
						<tr>
							<td><s:property/></td>
							<s:iterator value="#question.matrixColTitle">
							<td>
								<s:if test="#questiontype == 6">
									<input type="radio" />
								</s:if>
								<s:if test="#questiontype == 7">
									<input type="checkbox" />
								</s:if>
								<s:if test="#questiontype == 8">
									<s:select list="#question.matrixSelectOptionsArr"></s:select>
								</s:if>
							</td>
							</s:iterator>
						</tr>
						</s:iterator>
					</table>
				</s:else>
			
			</s:iterator>
		</s:iterator>


	</center>
</body>
</html>