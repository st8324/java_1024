<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
	  	<a class="navbar-brand" href="#" style="padding:0">
	  		<img height="40" alt="로고" src="<c:url value="/resources/img/bird.jpg"></c:url>">
	  	</a>
	  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    	<span class="navbar-toggler-icon"></span>
	  	</button>
	  	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	    	<ul class="navbar-nav">
	    		<c:if test="${user == null}">
			      	<li class="nav-item">
			      		<a class="nav-link" href="<c:url value='/signup'></c:url>">회원가입</a>
			      	</li>
			      	<li class="nav-item">
			        	<a class="nav-link" href="<c:url value='/login'></c:url>">로그인</a>
			      	</li>
		      	</c:if>
		      	<c:if test="${user != null}">
			      	<li class="nav-item">
			      		<form action="<c:url value='/logout'></c:url>" method="post">
			        		<button class="nav-link" style="background: transparent;border: 0">로그아웃</button>
			        	</form>
			      	</li> 
		      	</c:if>   
	    	</ul>
		</div> 
	</div> 
</nav>