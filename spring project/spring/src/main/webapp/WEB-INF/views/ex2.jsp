<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>예제2</title>
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
	<h1>예제2</h1>
	<p>화면에서 서버로 데이터를 post방식으로 전달하는 예제</p>
	<form method="post" action="/spring/ex2">
		<input type="text" name="name"> <br>
		<input type="text" name="age"> <br>	
		<button>전송</button>
	</form>
	<p>post 방식으로 서버에 데이터를 보내는 경우</p>
	<ol>
		<li>url에 데이터가 노출되면 안되는 경우 : 로그인, 회원가입</li>
		<li>서버에 보내는 데이터가 많은 경우 : 게시글 작성</li>
		<li>파일을 전송하는 경우</li>
	</ol>
</div>
</body>
</html>
