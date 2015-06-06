<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.top{
border:2px solid red;
}
</style>

</head>

<body>


<div class="top">
<center>
<h2>welcome to gch's survey</h2>
<br>
<s:a href="RegAction_toReg.action">注册页面</s:a>
<s:a href="LoginAction_toLogin.action">登陆</s:a>
<s:a href="SurveyAction_toMySurvey.action">我的调查</s:a>
<s:a href="SurveyAction_newSurvey.action">新建调查</s:a>

</center>
</div>


</body>
</html>