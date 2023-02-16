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
				<th>읽기 권한</th>
				<th>쓰기 권한</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="bt">
				<tr>
					<td class="form-group">${bt.bt_num }</td>
					<td class="form-group">
						<select class="form-control">
							<option <c:if test="${bt.bt_type == '일반' }">selected</c:if>>일반</option>
							<option <c:if test="${bt.bt_type == '이미지' }">selected</c:if>>이미지</option>
						</select>
					</td>
					<td>
						<input type="text" class="form-control" value="${bt.bt_name}">
					</td>
					<td>
						<select class="form-control">
							<option value="0" <c:if test="${bt.bt_r_authority == 0 }">selected</c:if>>비회원이상</option>
							<option value="1" <c:if test="${bt.bt_r_authority == 1 }">selected</c:if>>회원이상</option>
							<option value="9" <c:if test="${bt.bt_r_authority == 9 }">selected</c:if>>관리자이상</option>
						</select>
					</td>
					<td>
						<select class="form-control">
							<option value="1" <c:if test="${bt.bt_w_authority == 1 }">selected</c:if>>회원이상</option>
							<option value="9" <c:if test="${bt.bt_w_authority == 9 }">selected</c:if>>관리자이상</option>
						</select>
					</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<form action="<c:url value='/admin/board/type/insert'></c:url>" method="post">
					<td class="form-group"></td>
					<td class="form-group">
						<select class="form-control" name="bt_type">
							<option>일반</option>
							<option>이미지</option>
						</select>
					</td>
					<td>
						<input type="text" class="form-control" name="bt_name">
					</td>
					<td>
						<select class="form-control" name="bt_r_authority">
							<option value="0">비회원이상</option>
							<option value="1">회원이상</option>
							<option value="9">관리자이상</option>
						</select>
					</td>
					<td>
						<select class="form-control" name="bt_w_authority">
							<option value="1">회원이상</option>
							<option value="9">관리자이상</option>
						</select>
					</td>
					<td><button class="btn btn-outline-success">등록</button></td>
				</form>
			</tr>
		</tfoot>
	</table>
</div>
<!-- c:forech를 이용한 1부터 10까지 출력 예제 -->
<!-- 
<c:forEach begin="1" end="10" step="1" var="i">
${i }<br>
</c:forEach>
 -->
<!-- c:foreach를 이용한 리스트의 순번을 출력하는 예제 -->
<!-- 
<c:forEach items="${list }" var="bt" varStatus="vs">
${bt} <br>
${vs.index }/${vs.count } <br>
</c:forEach>
 -->