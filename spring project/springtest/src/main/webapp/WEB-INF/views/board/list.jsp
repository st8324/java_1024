<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>추천/비추천</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.bo_num}</td>
				<td>
					<a href="<c:url value='/board/detail/${board.bo_num }'></c:url>">
					${board.bo_title }
					</a>
				</td>
				<td>${board.bo_me_id }</td>
				<td>${board.bo_register_date }</td>
				<td>${board.bo_up}/${board.bo_down }</td>
				<td>${board.bo_views}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>