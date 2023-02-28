<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="<c:url value='/resources/css/summernote-bs4.min.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/summernote-bs4.min.js'></c:url>"></script>
<div class="container">
	<h1>게시글 확인</h1>
	<div class="form-group">
		<label>게시판:</label>
		<div class="form-control" >${board.bt_name}</div>
	</div>
	<div class="form-group">
		<label >제목:</label>
		<div class="form-control">${board.bo_title }</div>
	</div>
	<div class="form-group">
		<label>작성자:</label>
		<div class="form-control">${board.bo_me_id }</div>
	</div>
	<div class="form-group">
		<label for="title">작성일:</label>
		<div class="form-control">${board.bo_register_date}</div>
	</div>
	<div class="form-group">
		<label for="title">조회수:</label>
		<div class="form-control">${board.bo_views}</div>
	</div>
	<c:if test="${board.bt_type =='일반' }">
		<div id="common">
			<div class="form-group">
				<label for="content">내용:</label>
				<div class="form-control" style="min-height: 400px">${board.bo_content}</div>
			</div>
			
			<c:if test="${files.size() != 0 }">
				<div class="form-group mt-3">
					<label>첨부파일:</label>
					<c:forEach items="${files}" var="file">
						<a class="form-control" href="<c:url value='/download${file.fi_name}'></c:url>" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
					</c:forEach>
				</div>
			</c:if>
		</div>
	</c:if>
	
	<div id="image" style="display: none">
		<div class="form-group mt-3">
			<label>첨부파일:</label>
			<input type="file" class="form-control" name="files" accept="image/*">
			<input type="file" class="form-control" name="files" accept="image/*">
			<input type="file" class="form-control" name="files" accept="image/*">
		</div>
	</div>
	<div class="pagination justify-content-center" style="margin:20px 0">
		<c:if test="${likes != null && likes.li_state == 1}">
			<button class="btn btn-success btn-up">추천</button>
		</c:if>
		<c:if test="${likes == null || likes.li_state != 1}">
			<button class="btn btn-outline-success btn-up">추천</button>
		</c:if>
		<c:if test="${likes != null && likes.li_state == -1}">
			<button class="btn btn-danger btn-down ml-2">비추천</button>
		</c:if>
		<c:if test="${likes == null || likes.li_state != -1}">
			<button class="btn btn-outline-danger btn-down ml-2">비추천</button>
		</c:if>
	</div>
</div>
<script>
$(function(){
	$('.btn-up, .btn-down').click(function(){
		if('${user.me_id}' == ''){
			let res = confirm('로그인한 회원만 추천을 할 수 있습니다.\n로그인 페이지로 이동하겠습니까?');
			if(res){
				location.href="<c:url value='/login'></c:url>"
			}
		}
		let li_state = 1;
		if($(this).hasClass('btn-down'))
			li_state = -1;
		//ajax를 이용하여 추천/비추천 작업
		$.ajax({
			//비동기화 : 사용
			//동기화는 ajax 작업이 다 끝난 후 아래 코드가 실행
			//비동기화는 ajax가 작업이 끝나든 말든 아래 코드가 실행
	        async:true,
	        type:'GET',
	        //data:JSON.stringify(obj),
	        url:"<c:url value='/board/like/"+li_state+"/${board.bo_num}'></c:url>",
	        //서버에서 받는 데이터 타입
	        dataType:"json",
	        //서버에 보내는 데이터 타입
	        //contentType:"application/json; charset=UTF-8",
	        success : function(data){
	        	//추천 버튼 초기 상태로
	        	$('.btn-up').removeClass('btn-success').addClass('btn-outline-success');
	        	//비추천 버튼 초기 상태로
	        	$('.btn-down').removeClass('btn-danger').addClass('btn-outline-danger');
	            if(data.res == 1){
	            	alert('추천을 했습니다.');
	            	$('.btn-up').addClass('btn-success').removeClass('btn-outline-success');
	            }else if(data.res == -1){
	            	alert('비추천을 했습니다.');
	            	$('.btn-down').addClass('btn-danger').removeClass('btn-outline-danger');
	            }else{
	            	if(li_state == 1){
	            		alert('추천을 취소했습니다.')
	            	}else{
	            		alert('비추천을 취소했습니다.')
	            	}
	            }
	        }
	    });
		
	});
})
</script>
