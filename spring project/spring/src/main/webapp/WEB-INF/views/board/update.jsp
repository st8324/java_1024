<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="<c:url value='/resources/css/summernote-bs4.min.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/summernote-bs4.min.js'></c:url>"></script>
<div class="container">
	<h1>게시글 수정</h1>
	<form action="<c:url value='/board/update/${board.bo_num}'></c:url>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="type">게시판:</label>
			<select class="form-control" name="bo_bt_num" id="type">
				<option value="0">게시판을 선택하세요.</option>
				<c:forEach items="${btList}" var="bt">
					<option value="${bt.bt_num}" <c:if test="${board.bo_bt_num == bt.bt_num }">selected</c:if>>${bt.bt_name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="title">제목:</label>
			<input type="text" class="form-control" id="title" name="bo_title" value="${board.bo_title }">
		</div>
		<div id="common" style="display: none">
			<div class="form-group">
				<label for="content">내용:</label>
			</div>
			<textarea id="content" name="bo_content"></textarea>
			<div class="form-group mt-3 files">
				<label>첨부파일:</label>
				<c:forEach items="${files}" var="file">
					<a class="form-control" href="<c:url value='/download${file.fi_name}'></c:url>" download="${file.fi_ori_name}">
						${file.fi_ori_name}
						<i class="btn-times" style="color:red;" data-num="${file.fi_num}">X</i>
					</a>
				</c:forEach>
				<c:forEach begin="1" end="${3 - files.size()}">
					<input type="file" class="form-control" name="files">
				</c:forEach>
			</div>
		</div>
		<div id="image" style="display: none">
			<div class="form-group mt-3">
				<label>첨부파일:</label>
				<input type="file" class="form-control" name="files" accept="image/*">
				<input type="file" class="form-control" name="files" accept="image/*">
				<input type="file" class="form-control" name="files" accept="image/*">
			</div>
		</div>
		<button class="btn btn-outline-success col-12 mt-3">게시글 작성</button>
	</form>
</div>
<script>
$('#content').summernote({
	placeholder: '내용을 입력하세요.',
	tabsize: 2,
	height: 400
});

$('#type').change(function(){
	let val = $(this).val();
	$('#common').hide();
	$('#image').hide();
	if(val == 0)
		return;
	if(common.indexOf(val) >= 0){
		$('#common').show();
	}else{
		$('#image').show();
	}
});
$('form').submit(function(){
	let bo_bt_num = $('[name=bo_bt_num]').val();
	if(bo_bt_num  == 0){
		alert('게시판을 선택하세요.');
		$('[name=bo_bt_num]').focus();
		return false;
	}
	let bo_title = $('[name=bo_title]').val();
	if(bo_title.trim().length  == 0){
		alert('제목을 입력하세요.');
		$('[name=bo_title]').focus();
		return false;
	}
	let bo_content = $('[name=bo_content]').val();
	if(bo_content.trim().length  == 0){
		alert('내용을 입력하세요.');
		return false;
	}
});
//게시판 타입이 일반인 게시판들의 기본키를 저장하는 common 배열
let common = [];
//게시판 타입이 일반인 게시판들의 기본키를 저장하는 작업
<c:forEach items="${btList}" var="bt">
	<c:if test="${bt.bt_type == '일반'}">common.push('${bt.bt_num}')</c:if>
</c:forEach>
//현재 수정하려는 게시글의 게시판이 일반이면 일반 게시판이, 이미지면 이미지 게시판이 보이도록 하는 작업
if(common.includes('${board.bo_bt_num}'))
	$('#common').show();
else
	$('#image').show();
$('#content').summernote('code','${board.bo_content}');
$('.btn-times').click(function(e){
	e.preventDefault();
	$('.files').append('<input type="file" class="form-control" name="files">');
	$('.files').append('<input type="hidden" name="fileNums" value="'+$(this).data('num')+'">');
	$(this).parent().remove();
});
</script>
