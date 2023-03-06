<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web</title>
</head>
<body>
<h1>Hello</h1>
<a href="<%=request.getContextPath()%>/signup">회원가입</a>

<%
int num1 = 10, num2 = 20;
int sum = num1 + num2;
%>
<%= sum%>

</body>
</html>