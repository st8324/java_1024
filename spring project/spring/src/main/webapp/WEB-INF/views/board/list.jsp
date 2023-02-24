<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h1>게시글 리스트</h1>
	
	
	
	
	
	<c:if test="${user != null }">
		<a href="<c:url value="/board/insert"></c:url>">
			<button class="btn btn-outline-primary btn-ins">글쓰기</button>
		</a>
	</c:if>
</div>

