<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand/logo -->
	<a class="navbar-brand" href="<c:url value='/'></c:url>">
		<img src="<c:url value='/resources/img/bird.jpg'></c:url>" alt="logo" style="width:40px;">
	</a>
	
	<!-- Links -->
	<ul class="navbar-nav">
		<c:if test="${user == null}">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value='/signup'></c:url>">회원가입</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value='/login'></c:url>">로그인</a>
			</li>
		</c:if>
		<c:if test="${user != null }">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value='/logout'></c:url>">로그아웃</a>
			</li>
		</c:if>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/board/list'></c:url>">게시글</a>
		</li>
		<c:if test="${user != null && user.me_authority >= 9}">
		    <li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
				  관리자 메뉴
				</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="<c:url value='/admin/board/type/list'></c:url>">게시글 타입 관리</a>
					<a class="dropdown-item" href="#">Link 2</a>
					<a class="dropdown-item" href="#">Link 3</a>
				</div>
		    </li>
	    </c:if>
	</ul>
</nav>
