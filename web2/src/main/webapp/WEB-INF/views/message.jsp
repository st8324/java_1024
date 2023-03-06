<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web</title>
</head>
<body>
<script>
alert('<%=request.getAttribute("msg")%>');
location.href = '<%=request.getContextPath() +request.getAttribute("url") %>'
</script>
</body>
</html>