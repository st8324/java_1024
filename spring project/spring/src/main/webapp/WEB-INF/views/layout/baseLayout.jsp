<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html> 
<html>
<head>
	<title>스프링</title>
	<link rel="stylesheet" href="/spring/resources/css/bootstrap.min.css">
	<script src="/spring/resources/js/jquery.min.js"></script>
	<script src="/spring/resources/js/popper.min.js"></script>
	<script src="/spring/resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
</body>
</html>