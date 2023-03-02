<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="<c:url value='/resources/css/summernote-bs4.min.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/summernote-bs4.min.js'></c:url>"></script>
<style>
.file-box{
	width : 100px; height : 200px;
	border : 1px solid black; font-size : 50px;
	text-align: center; line-height: 200px; font-weight: bold;
	border-radius: 5px; 
	float: left; cursor: pointer;
}
#image>div::after{
	display: block; content: ''; clear: both;
}
#image [type=file]{
	display: none;
}
#image>div>div{
	float:left; margin-right: 20px;
}
</style>
<div class="container">
	<h1>게시글 작성</h1>
	<form action="<c:url value='/board/insert'></c:url>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="type">게시판:</label>
			<select class="form-control" name="bo_bt_num" id="type">
				<option value="0">게시판을 선택하세요.</option>
				<c:forEach items="${btList}" var="bt">
					<option value="${bt.bt_num}">${bt.bt_name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="title">제목:</label>
			<input type="text" class="form-control" id="title" name="bo_title">
		</div>
		<div id="common" style="display: none">
			<div class="form-group">
				<label for="content">내용:</label>
			</div>
			<textarea id="content" name="bo_content"></textarea>
			<div class="form-group mt-3">
				<label>첨부파일:</label>
				<input type="file" class="form-control" name="files">
				<input type="file" class="form-control" name="files">
				<input type="file" class="form-control" name="files">
			</div>
		</div>
		<div id="image" style="display: none;">
			<label>이미지:</label>
			<div class="form-group mt-3">
				<div>
					<div class="file-box">+</div>
					<input type="file" class="form-control" name="files" accept="image/*" onchange="readURL(this);">
					<img class="preview" height="200" width="auto">
				</div>
				<div>
					<div class="file-box">+</div>
					<input type="file" class="form-control" name="files" accept="image/*" onchange="readURL(this);">
					<img class="preview" height="200" width="auto">
				</div>
				<div>
					<div class="file-box">+</div>
					<input type="file" class="form-control" name="files" accept="image/*" onchange="readURL(this);">
					<img class="preview" height="200" width="auto">
				</div>
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
		$('#content').summernote('code','');
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
	if(bo_content.trim().length  == 0 && common.indexOf($('#type').val())>=0 ){
		alert('내용을 입력하세요.');
		return false;
	}
	//이미지 게시판에서 이미지가 1개이상 선택이 되어야 전송되도록 유효성 검사 
	if(common.indexOf($('#type').val()) < 0){
		let images = image.querySelectorAll('[type=file]');
		for(i = 0; i<images.length; i++){
			if(images[i].files && images[i].files[0])
				return true;
		}
		alert('이미지를 1개이상 선택하세요.');
		return false;
	}
});

let common = [];
<c:forEach items="${btList}" var="bt">
	<c:if test="${bt.bt_type == '일반'}">common.push('${bt.bt_num}')</c:if>
</c:forEach>

$('.file-box,.preview').click(function(){
	$(this).siblings('input').click();
});
function readURL(input){
	
	if(!input.files || !input.files[0]){
		input.nextElementSibling.src ='';
		input.previousElementSibling.style.display = 'block';
		return;
	}
	let reader = new FileReader();
	reader.onload = function(e){
		input.previousElementSibling.style.display = 'none';
		input.nextElementSibling.src = e.target.result;
	}
	reader.readAsDataURL(input.files[0]);
}
let t;
</script>
