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
		<h3>this is designPage</h3>

		<!-- 问卷层面 -->
		<s:if test="photoExists()">
		<img  src='<s:url value="%{logopath}"></s:url>' width="50" height="25">
		</s:if>
		<s:property value="title" />
		<s:a href='SurveyAction_editServey?sid=%{#sid}'>编辑问卷</s:a>
		<s:a href='SurveyAction_toAddLogo?sid=%{#sid}'>添加logo</s:a>
		<s:a href='PageAction_addPage?sid=%{#sid}'>增加页面</s:a>
 
		<!-- 页面层面 -->
		<s:iterator value="pages" var="page">
			<br>
			<s:property value="#page.title" />
			<s:set var="pid" value="#page.id"></s:set>
			<s:a href='PageAction_editPage?sid=%{#sid}&pid=%{#pid}'>编辑页面</s:a>
			<s:a href='CopyOrMoveAction_toSelectMovePage?srcpid=%{#pid}'>移动</s:a>
			<s:a href='QuestionAction_selectQuestionType?sid=%{#sid}&pid=%{#pid}'>增加问题</s:a>
			<s:a href='PageAction_deletePage?sid=%{#sid}&pid=%{#pid}'>删除页面</s:a>
			<br>
			<!-- 问题层面 -->
			<s:iterator value="#page.questions" var="question">
				<s:set var="qid" value="#question.id"></s:set>
				<br>
				<!-- 问题标题 -->
				<s:property value="#question.title" />
				<s:a href='QuestionAction_editQuestion?sid=%{#sid}&qid=%{#qid}&pid=%{#pid}'>编辑问题</s:a>
				<s:a href='QuestionAction_deleteQuestion?sid=%{#sid}&qid=%{#qid}'>删除问题</s:a>
				<br>
				<!-- 问题选项 -->
				<s:set var="questiontype" value="#question.questionType"></s:set>
				
				<!-- 0，1，2，3， -->
				<s:if test="#questiontype < 4">
					<s:iterator value="#question.optionArr" var="v">
						<s:property value="#v"/>
						<input type="<s:property value="#questiontype > 1 ?'checkbox':'radio'" />"/>
						<s:if test="#questiontype == 1 || #questiontype == 3"><br></s:if>
					</s:iterator>
					<s:if test="other">
					其他
						<input type="<s:property value="#questiontype > 1 ?'checkbox':'radio'" />"/>
						<s:if test="#question.otherStyle == 1">
							<input type="text" />
						</s:if>
						<s:elseif test="#question.otherStyle == 2">
							<s:select list="#question.otherSelectOptionArr"></s:select>
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
						<s:iterator value="#question.matrixColTitleArr">
							<td><s:property/></td>
						</s:iterator>
						</tr>
						<s:iterator value="#question.matrixRowTitleArr">
						<tr>
							<td><s:property/></td>
							<s:iterator value="#question.matrixColTitleArr">
							<td>
								<s:if test="#questiontype == 6">
									<input type="radio" />
								</s:if>
								<s:if test="#questiontype == 7">
									<input type="checkbox" />
								</s:if>
								<s:if test="#questiontype == 8">
									<s:select list="#question.matrixSelectOptionArr"></s:select>
								</s:if>
							</td>
							</s:iterator>
						</tr>
						</s:iterator>
					</table>
				</s:else>
			
			<br><br>
			</s:iterator>
			<br><br>
		</s:iterator>
 

	</center>
</body>
</html>