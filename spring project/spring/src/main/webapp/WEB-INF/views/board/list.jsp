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
	
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">
			<li class="page-item">
				<a class="page-link" href="<c:url value='/board/list?page=${pm.startPage-1}&search=${pm.cri.search}&type=${pm.cir.type}'></c:url>">이전</a>
			</li>
		</c:if>
		<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
			<li class="page-item <c:if test="${pm.cri.page == i}"> active</c:if>">
				<a class="page-link" href="<c:url value='/board/list?page=${i}&search=${pm.cri.search}&type=${pm.cri.type}'></c:url>">${i}</a>
			</li>
		</c:forEach>
		
		<c:if test="${pm.next}">
			<li class="page-item">
				<a class="page-link" href="<c:url value='/board/list?page=${pm.endPage+1}&search=${pm.cri.search}&type=${pm.cri.type}'></c:url>">다음</a>
			</li>
		</c:if>
	</ul>
	
	<form class="input-group mb-3" action="<c:url value='/board/list'></c:url>">
		<select class="input-group-prepend" name="type">
			<option value="0">전체</option>
			<c:forEach items="${typeList }" var="type">
				
				<option value="${type.bt_num}" <c:if test="${pm.cri.type == type.bt_num }"> selected</c:if>>${type.bt_name}</option>
			</c:forEach>
		</select>
		<input type="text" class="form-control" placeholder="Search" name="search" value="${pm.cri.search}">
		<div class="input-group-append">
			<button class="btn btn-success" type="submit">검색</button>
		</div>
	</form>

	<c:if test="${user != null }">
		<a href="<c:url value="/board/insert"></c:url>">
			<button class="btn btn-outline-primary btn-ins">글쓰기</button>
		</a>
	</c:if>
</div>

