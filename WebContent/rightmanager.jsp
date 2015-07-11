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
	height: 25px;
}
</style>

</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<br>
	<center>
		<a href="RightAction_addRight">增加权限</a> <br>
		<s:if test="allRights.isEmpty()">
			您暂时没有任何权限
		</s:if>
		<s:else>
			<table border="">
				<tr>
					<td>id</td>
					<td>权限名称</td>
					<td>权限URL</td>
					<td>权限描述</td>
					<td>公共资源</td>
					<td>权限码</td>
					<td>权限位</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
				<s:form action="RightAction_UpdateRights">
					<s:iterator value="allRights" var="right" status="st">
						<tr>
							<td><s:textfield name="allRights[%{#st.index}].id"
									readonly="true"></s:textfield></td>
							<td><s:textfield name="allRights[%{#st.index}].rightName"></s:textfield></td>
							<td><s:textfield name="allRights[%{#st.index}].rightUrl"></s:textfield></td>
							<td><s:textfield name="allRights[%{#st.index}].rightDesc"></s:textfield></td>
							<td><s:checkbox  name="allRights[%{#st.index}].common" ></s:checkbox></td>
							<td><s:textfield name="allRights[%{#st.index}].rightCode"
									readonly="true"></s:textfield></td>
							<td><s:textfield name="allRights[%{#st.index}].rightPos"
									readonly="true"></s:textfield></td>

							<td><s:a href="RightAction_editRight?id=%{id }">修改</s:a></td>
							<td><s:a href="RightAction_deleteRight?id=%{id }">删除</s:a></td>
						</tr>
					</s:iterator>
					<tr>
						<td><s:submit></s:submit></td>
					</tr>
				</s:form>
			</table>
		</s:else>
	</center>
</body>
</html>