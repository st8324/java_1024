<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>게시판 관리</h1>
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>타입</th>
			<th>게시판명</th>
			<th>읽기 권한</th>
			<th>쓰기 권한</th>
			<th>비고</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${btList}" var="bt" varStatus="vs">
			<tr>
				<form action="<c:url value='/admin/board/type/update'></c:url>" method="post">
					<th>${vs.count}<input type="hidden" value="${bt.bt_num}" name="bt_num"></th>
					<th>
						<div class="form-group">
							<select class="form-control" name="bt_type">
								<option <c:if test="${bt.bt_type == '일반'}">selected</c:if>>일반</option>
								<option <c:if test="${bt.bt_type == '이미지'}">selected</c:if>>이미지</option>
							</select>
						</div>
		  			</th>
					<th>
						<div class="form-group">
		  					<input type="text" class="form-control" name="bt_name" value="${bt.bt_name }">
		  				</div>
					</th>
					<th>
						<div class="form-group">
							<select class="form-control" name="bt_r_authority">
								<option value="0" <c:if test="${bt.bt_r_authority == 0 }">selected</c:if>>비회원이상</option>
								<option value="1" <c:if test="${bt.bt_r_authority == 1 }">selected</c:if>>회원이상</option>
								<option value="9" <c:if test="${bt.bt_r_authority == 9 }">selected</c:if>>관리자이상</option>
							</select>
						</div>
					</th>
					<th>
						<div class="form-group">
							<select class="form-control" name="bt_w_authority">
								<option value="1" <c:if test="${bt.bt_w_authority == 1 }">selected</c:if>>회원이상</option>
								<option value="9" <c:if test="${bt.bt_w_authority == 9 }">selected</c:if>>관리자이상</option>
							</select>
						</div>
					</th>
					<th>
						<button class="btn btn-outline-warning">수정</button>
						<button class="btn btn-outline-danger">삭제</button>
					</th>
				</form>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<form action="<c:url value='/admin/board/type/insert'></c:url>" method="post">
				<th></th>
				<th>
					<div class="form-group">
						<select class="form-control" name="bt_type">
							<option>일반</option>
							<option>이미지</option>
						</select>
					</div>
	  			</th>
				<th>
					<div class="form-group">
	  					<input type="text" class="form-control" name="bt_name" value="">
	  				</div>
				</th>
				<th>
					<div class="form-group">
						<select class="form-control" name="bt_r_authority">
							<option value="0">비회원이상</option>
							<option value="1">회원이상</option>
							<option value="9">관리자이상</option>
						</select>
					</div>
				</th>
				<th>
					<div class="form-group">
						<select class="form-control" name="bt_w_authority">
							<option value="1">회원이상</option>
							<option value="9">관리자이상</option>
						</select>
					</div>
				</th>
				<th>
					<button class="btn btn-outline-success">등록</button>
				</th>
			</form>
		</tr>
	</tfoot>
</table>