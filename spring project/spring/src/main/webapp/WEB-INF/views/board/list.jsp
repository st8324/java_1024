<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h1>게시글 리스트</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>게시판</th>
				<th>제목</th>
				<th>작성자</th>
				<th>추천/비추천</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="bo" varStatus="vs">
				<tr>
					<td class="form-group">${bo.bo_num }</td>
					<td>${bo.bt_name }</td>
					<td class="form-group">
						<a href="<c:url value='/board/detail/${bo.bo_num}'></c:url>">${bo.bo_title}</a>
					</td>
					<td>${bo.bo_me_id}</td>
					<td>${bo.bo_up}/${bo.bo_down}</td>
					<td>${bo.bo_register_date_str}</td>
					<td>${bo.bo_views }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
	
	<c:if test="${user != null }">
		<a href="<c:url value="/board/insert"></c:url>">
			<button class="btn btn-outline-primary btn-ins">글쓰기</button>
		</a>
	</c:if>
</div>

