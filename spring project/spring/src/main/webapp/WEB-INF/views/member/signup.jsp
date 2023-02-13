<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h1>회원가입</h1>
	<form action="<c:url value='/signup'></c:url>" method="post">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="id">
		</div>
		<div class="form-group">
			<label for="pw">비번:</label>
			<input type="password" class="form-control" id="pw" name="pw">
		</div>
		<div class="form-group">
			<label for="pw2">비번확인:</label>
			<input type="password" class="form-control" id="pw2" name="pw2">
		</div>
		<div class="form-group">
			<label for="email">이메일:</label>
			<input type="text" class="form-control" id="email" name="email">
		</div>
		<div class="form-group">
			<label for="birthday">생년월일</label>
			<input type="text" class="form-control" id="birthday" name="birthday">
		</div>
	</form>
</div>