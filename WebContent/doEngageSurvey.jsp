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
		<s:form action="EngageSurveyAction_doSurvey">
			<s:hidden name="currPid" value='%{currentPage.id}'></s:hidden>
			<br>
			<s:property value="#session.current_survey.title" />
			<br>
			<!-- 问题层面 -->
			<s:iterator value="currentPage.questions" var="question">
				<s:set var="qid" value="#question.id"></s:set>
				<br>
				<!-- 问题标题 -->
				<s:property value="#question.title" />
				<br>
				<!-- 问题选项 -->
				<s:set var="questiontype" value="#question.questionType"></s:set>

				<!-- 0，1，2，3， -->
				<s:if test="#questiontype < 4">
					<s:iterator value="#question.optionArr" var="v" status="st">
						<s:property value="#v" />
						<input
							type="<s:property value="#questiontype > 1 ?'checkbox':'radio'" />"
							name='q<s:property value="#qid"/>'
							value='<s:property value="#st.index"/>'
							<s:property value="setTag('q'+#qid,#st.index,'checked')"/> />
						<s:if test="#questiontype == 1 || #questiontype == 3">
							<br>
						</s:if>
					</s:iterator>
					<s:if test="other">
					其他
						<input
							type="<s:property value="#questiontype > 1 ?'checkbox':'radio'" />"
							name='q<s:property value="#qid"/>' value="other"
							<s:property value="setTag('q'+#qid,'other','checked')"/> />
						<s:if test="#question.otherStyle == 1">
							<input type="text" name='q<s:property value="#qid"/>other'
								<s:property value="setText('q'+#qid+'other')"/> />
						</s:if>
						<s:elseif test="#question.otherStyle == 2">
							<select name='q<s:property value="#qid"/>other'>
								<s:iterator value="#question.otherSelectOptionArr" var="option"
									status="optst">
									<option value='<s:property value="#optst.index"/>'
										<s:property value="setTag('q'+#qid+'other',#optst.index,'selected')"/>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</s:elseif>
					</s:if>
				</s:if>


				<!-- 4,5 -->
				<s:elseif test="#questiontype == 4 || #questiontype == 5">
					<s:if test="#questiontype == 4">
						<select name='q<s:property value="#qid"/>'>
							<s:iterator value="#question.optionArr" var="option"
								status="optst">
								<option value='<s:property value="#optst.index"/>'
									<s:property value="setTag('q'+#qid,#optst.index,'selected')"/>>
									<s:property />
								</option>
							</s:iterator>
						</select>
					</s:if>
					<s:elseif test="#questiontype == 5">
						<input type="text" name='q<s:property value="#qid"/>'
							<s:property value="setText('q'+#qid)"/> />
					</s:elseif>
				</s:elseif>


				<!-- 6,7,8 -->
				<s:else>
					<table>
						<tr>
							<td></td>
							<s:iterator value="#question.matrixColTitleArr">
								<td><s:property /></td>
							</s:iterator>
						</tr>
						<s:iterator value="#question.matrixRowTitleArr" status="rowst">
							<tr>
								<td><s:property /></td>
								<s:iterator value="#question.matrixColTitleArr" status="colst">

									<td><s:if test="#questiontype == 6">
											<input type="radio"
												name='q<s:property value="#qid+'_'+#rowst.index"/>'
												value='<s:property value="#rowst.index+'_'+#colst.index"/>'
												<s:property value="setTag('q'+#qid+'_'+#rowst.index,#rowst.index+'_'+#colst.index,'checked')"/> />

										</s:if> <s:if test="#questiontype == 7">
											<input type="checkbox" name='q<s:property value="#qid"/>'
												value='<s:property value="#rowst.index+'_'+#colst.index"/>'
												<s:property value="setTag('q'+#qid,#rowst.index+'_'+#colst.index,'checked')"/> />

										</s:if> <s:if test="#questiontype == 8">
											<select name='q<s:property value="#qid"/>'>
												<s:iterator value="#question.matrixSelectOptionArr"
													var="option" status="optst">
													<option
														value='<s:property value="#rowst.index+'_'+#colst.index+'_'+#optst.index"/>'
														<s:property value="setTag('q'+#qid,#rowst.index+'_'+#colst.index+'_'+#optst.index,'selected')"/>
														>
														<s:property />
													</option>
												</s:iterator>
											</select>
										</s:if></td>
								</s:iterator>
							</tr>
						</s:iterator>
					</table>
				</s:else>

				<br>
				<br>
			</s:iterator>
			<br>
			<br>
			<s:if
				test="#session.current_survey.minOrderno != currentPage.orderno">
				<input type="submit" name="submit_pre"
					value='<s:property value="#session.current_survey.preText"/>' />
			</s:if>
			<s:if
				test="#session.current_survey.maxOrderno != currentPage.orderno">
				<input type="submit" name="submit_next"
					value='<s:property value="#session.current_survey.nextText"/>' />
			</s:if>
			<s:if
				test="#session.current_survey.maxOrderno == currentPage.orderno">
				<input type="submit" name="submit_done"
					value='<s:property value="#session.current_survey.doneText"/>' />
			</s:if>
		</s:form>
	</center>
</body>
</html>