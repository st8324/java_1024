<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<form action="/spring/login" method="post">
	<input type="text" name="id"> <br>
	<input type="password" name="pw"> <br>
	<button>로그인</button>
</form>
</body>
</html>
