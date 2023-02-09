<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>예제4</title>
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
	<h1>예제4</h1>
	<p>서버에서 화면으로 데이터를 보내는 예제</p>
	<p>${name}의 나이는 ${age}살입니다.</p>
</div>
</body>
</html>
