<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="/spring">
    <img src="/spring/resources/img/bird.jpg" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 3</a>
    </li>
  </ul>
</nav>
<div class="container-fluid">
	<h1>스프링</h1>
	<a href="/spring/ex1">데이터 전송 예제1</a> <br>
	<a href="/spring/ex2">데이터 전송 예제2</a> <br>
	<a href="/spring/ex3">데이터 전송 예제3</a> <br>
</div>
</body>
</html>
