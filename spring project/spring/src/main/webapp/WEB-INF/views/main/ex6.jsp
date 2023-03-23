<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-fluid">
	<h1>스프링</h1>
	<form method="post">
		<c:forEach begin="0" end="2" var="i">
			<div class="box">
				<input type="text" name="list[${i}].bo_num" value="${i+1}">
			</div>
		</c:forEach>
		<button type="submit">전송</button>
	</form>
</div>

