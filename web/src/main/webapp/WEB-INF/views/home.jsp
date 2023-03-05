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
<button>가입</button>
</form>
<%=request.getAttribute("msg")%>
</body>
</html>