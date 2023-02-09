<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>예제1</title>
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
	<h1>예제1</h1>
	<p>화면에서 서버로 데이터를 get방식으로 전달하는 예제</p>
	<h2>예제1-1</h2>
	<a href="/spring/ex1?name=홍길동&age=20">서버로 홍길동 전송</a>
	<h2>예제1-2</h2>
	<form method="get" action="/spring/ex1">
		<input type="text" name="name"> <br>
		<input type="text" name="age"> <br>	
		<button>전송</button>
	</form>
</div>
</body>
</html>
