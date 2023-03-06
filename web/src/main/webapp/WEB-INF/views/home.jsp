<<<<<<< Updated upstream
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
<input type="text" name="id"> <br>
<input type="password" name="pw"> 
<button>°¡ÀÔ</button>
</form>
<%=request.getAttribute("msg")%>
=======
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
<a href="<%=request.getContextPath()%>/signup">íšŒì›ê°€ì…</a>

<%
int num1 = 10, num2 = 20;
int sum = num1 + num2;
%>
<%= sum%>
>>>>>>> Stashed changes
</body>
</html>