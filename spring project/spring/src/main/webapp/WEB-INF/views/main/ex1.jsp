<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

