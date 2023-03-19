<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "errorNullPointer.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<form action="" method="post">
<input type="text" name="id"> <br>
<input type="password" name="pw"> 
<button>가입</button>
</form>
<%=request.getAttribute("msg")%>
<%@ include file="footer.html" %>
<%
	String str = null;
	str.charAt(0);
%>
</body>
</html>