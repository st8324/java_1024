<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h1>게시글 타입 리스트</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>타입</th>
				<th>게시글명</th>
				<th>읽기/쓰기 권한</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="bt">
				<tr>
					<td>${bt.bt_num }</td>
					<td>${bt.bt_type }</td>
					<td>${bt.bt_name }</td>
					<td>${bt.bt_r_authority_str }이상/${bt.bt_w_authority_str }이상</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

