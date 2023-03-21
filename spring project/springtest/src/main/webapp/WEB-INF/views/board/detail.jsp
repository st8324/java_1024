<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>게시글 상세</h1>
<div class="form-group">
	<label>제목</label>
	<div class="form-control">${board.bo_title }</div>
</div>
<div class="form-group">
	<label>게시판</label>
	<div class="form-control">${board.bt_name }</div>
</div>
<div class="form-group">
	<label>작성자</label>
	<div class="form-control">${board.bo_me_id }</div>
</div>
<div class="form-group">
	<label>작성일</label>
	<div class="form-control">${board.bo_register_date_str }</div>
</div>
<c:if test="${board.bo_update_date != null }">
	<div class="form-group">
		<label>수정일</label>
		<div class="form-control">${board.bo_update_date_str }</div>
	</div>
</c:if>
<div class="form-group">
	<label>조회수</label>
	<div class="form-control">${board.bo_views }</div>
</div>
<div>
	<c:if test="${like == null || like.li_state != 1}">
		<button class="btn btn-outline-success btn-up" data-state="1">추천(<span class="count">${board.bo_up}</span>)</button>
	</c:if>
	<c:if test="${like != null && like.li_state == 1}">
		<button class="btn btn-success btn-up" data-state="1">추천(<span class="count">${board.bo_up}</span>)</button>
	</c:if>
	<c:if test="${like == null || like.li_state != -1}">
		<button class="btn btn-outline-danger btn-down" data-state="-1">비추천(<span class="count">${board.bo_down}</span>)</button>
	</c:if>
	<c:if test="${like != null && like.li_state == -1}">
		<button class="btn btn-danger btn-down" data-state="-1">비추천(<span class="count">${board.bo_down}</span>)</button>
	</c:if>
</div>
<div class="form-group">
	<label>내용</label>
	<div class="form-control" style="min-height: 400px">${board.bo_content}</div>
</div>
<c:if test="${fileList != null && fileList.size() != 0 }">
	<div class="form-group">
		<label>첨부파일</label>
		<c:forEach items="${fileList}" var="file">
			<a class="form-control" href="<c:url value='/file${file.fi_name}'></c:url>" download="${file.fi_ori_name}" >${file.fi_ori_name}</a>
		</c:forEach>
	</div>
</c:if>
<hr>
<h4>댓글</h4>
<hr>
<div class="comment-list">
	<div class="comment">
		<div class="comment-id">아이디</div>
		<div class="comment-date">시간</div>
		<div class="comment-content">내용</div>
		<div class="btn-group">
			<button type="button" class="btn btn-outline-success btn-reply" data-num="">답글</button>
			<button type="button" class="btn btn-outline-success btn-update" data-num="">수정</button>
			<button type="button" class="btn btn-outline-success btn-delete" data-num="">삭제</button>
		</div>
		<div class="input-group mb-3">
			<textarea class="form-control" placeholder="댓글을 입력하세요." name="co_content"></textarea>	
			<div class="input-group-append">
				<button class="btn btn-success btn-comment-insert" type="button">댓글 등록</button>
			</div>
		</div>
	</div>
</div>
<ul class="comment-pagination pagination justify-content-center">
	<li class="page-item">
		<a class="page-link" href="#">이전</a>
	</li>
    <li class="page-item">
    	<a class="page-link" href="#">1</a>
    </li>
    <li class="page-item">
    	<a class="page-link" href="#">다음</a>
    </li>
</ul>
<hr>
<div class="input-group mb-3">
	<textarea class="form-control" placeholder="댓글을 입력하세요." name="co_content"></textarea>	
	<div class="input-group-append">
		<button class="btn btn-success btn-comment-insert" type="button">댓글 등록</button>
	</div>
</div>
<a class="btn btn-success" href="<c:url value='/board/list'></c:url>">목록</a>
<c:if test="${user != null && user.me_id == board.bo_me_id }">
	<form action="<c:url value='/board/delete/${board.bo_num}'></c:url>" method="post" style="display: inline-block;">
		<button class="btn btn-outline-danger">삭제</button>
	</form>
	<a href="<c:url value='/board/update/${board.bo_num}'></c:url>" class="btn btn-outline-danger">수정</a>
</c:if>

<script>
$('.btn-up, .btn-down').click(function(){
	if('${user.me_id}' == ''){
		alert('로그인한 회원만 추천/비추천을 할 수 있습니다.');
		return;
	}
	
	let li_state = $(this).data('state');
	let bo_num = '${board.bo_num}';
	let url = '<c:url value="/board/like/"></c:url>'+bo_num+'/' + li_state;
	$.ajax({
        async:true,
        type:'get',
        url: url,
        dataType:"json",//서버에서 보낸 데이터의 타입. Map받으로 받을거기 때문에 json
        success : function(data){
        	//추천수 수정
            $('.btn-up>.count').text(data.board.bo_up);
        	//비추천수 수정
            $('.btn-down>.count').text(data.board.bo_down);
        	
        	//기본 추천/비추천 버튼으로 설정
        	$('.btn-up').removeClass('btn-success')
        		.addClass('btn-outline-success');
        	$('.btn-down').removeClass('btn-danger')
        		.addClass('btn-outline-danger');
        	
        	//state를 이용하여 알림창 및 버튼 색상 처리
        	if(data.state == 1){
        		alert('추천했습니다.');
        		$('.btn-up').addClass('btn-success')
        			.removeClass('btn-outline-success');
        	}else if(data.state == -1){
        		alert('비추천했습니다.');
        		$('.btn-down').addClass('btn-danger')
        			.removeClass('btn-outline-danger');
        	}else{
        		if(li_state == 1)
        			alert('추천을 취소했습니다.')
        		else
        			alert('비추천을 취소했습니다.')
        	}
        }
    });
});
</script>
<script>
//댓글과 관련된 전역 변수들
const bo_num = '${bo_num}';
let cri = {
	page : 1,
	perPageNum : 5
};
$('.btn-comment-insert').click(function(){
	if('${user.me_id}' == ''){
		if(confirm('댓글은 회원만 작성할 수 있습니다.\n로그인 페이지로 이동하겠습니까?')){
			location.href = '<c:url value="/login"></c:url>';
		}
		return;
	}
	let co_content = $('[name=co_content]').val();
	if(co_content.trim().length == 0){
		alert('댓글을 입력하세요.');
		$('[name=co_content]').focus();
		return;
	}
	
	let comment = {
		co_bo_num : bo_num,
		co_content : co_content
	}
	insertComment(comment, 1);
	
});


selectCommentList(cri);

function listSuccess(data){
	console.log(data);
	addCommentList(data.list);
	addPagination(data.pm);
}
function addCommentList(list){
	str = ''
	for(i = 0; i<list.length; i++){
		str += createComment(list[i]);
	}
	$('.comment-list').html(str);
	//답글 클릭 이벤트 추가
	$('.btn-reply').click(function(){
		//다른 답글 입력창을 제거
		$('.reply-box').remove();
		
		//다른 버튼들을 보여줌
		$('.btn-group').show();
		
		//버튼들을 감춤
		$(this).parent().hide();
		
		//답글입력창을 추가(버튼을 포함)
		str = '';
		str +=
		'<div class="reply-box input-group mb-3">'+
			'<textarea class="form-control" placeholder="댓글을 입력하세요." name="co_content"></textarea>'+	
			'<div class="input-group-append">'+
				'<button class="btn btn-success btn-reply-insert" type="button" data-num="'+$(this).data('num')+'">답글 등록</button>'+
			'</div>'+
		'</div>';
		$(this).parent().after(str);
		//답글 등록 클릭이벤트
		$('.btn-reply-insert').click(function(){
			let co_ori_num = $(this).data('num');
			let co_content = $(this).parents('.reply-box').find('[name=co_content]').val();
			if('${user.me_id}' == ''){
				if(confirm('로그인한 회원만 댓글 답글을 추가할 수 있습니다.\n로그인하시겠습니까?')){
					location.href= '<c:url value="/login"></c:url>';
				}
				return;
			}
			if(co_content.trim().length == 0){
				alert('답글을 입력하세요.');
				return;
			}
			let comment = {
				co_content : co_content,
				co_bo_num : bo_num,
				co_ori_num : co_ori_num
			}
			console.log(comment)
			insertComment(comment, cri.page);
		})
	});
	//삭제 클릭 이벤트 추가
	$('.btn-delete').click(function(){
		if('${user.me_id}' == ''){
			if(confirm('작성자만 댓글을 삭제할 수 있습니다.\n로그인하시겠습니까?')){
				location.href= '<c:url value="/login"></c:url>';
			}
			return;
		}
		let co_num = $(this).data('num');
		let comment = {
			co_num : co_num
		}
		ajaxPost(comment, '<c:url value="/comment/delete"></c:url>', deleteSuccess);
	})
	//수정 클릭 이벤트 추가
	
}
function deleteSuccess(data){
	if(data.res == -1)
		alert('작성자만 삭제할 수 있습니다.');
	else if(data.res == 0)
		alert('댓글 삭제에 실패했습니다.');
	else
		alert('댓글 삭제에 성공했습니다.');
	selectCommentList(cri);
}
function createComment(comment){
	str = '';
	str += 
	'<div class="comment">'+
		'<div class="comment-id">'+comment.co_me_id+'</div>'+
		'<div class="comment-date">'+comment.co_register_date_str+'</div>'+
		'<div class="comment-content">'+comment.co_content+'</div>'+
		'<div class="btn-group">'+
			'<button type="button" class="btn btn-outline-success btn-reply" data-num="'+comment.co_num+'">답글</button>'+
			'<button type="button" class="btn btn-outline-success btn-update" data-num="'+comment.co_num+'">수정</button>'+
			'<button type="button" class="btn btn-outline-success btn-delete" data-num="'+comment.co_num+'">삭제</button>'+
		'</div>'+
	'</div>';
	return str;
}
function addPagination(pm){
	let prev = pm.prev ? '' : 'disabled';
	let next = pm.next ? '' : 'disabled';
	str = '';
	str += 
	'<li class="page-item '+prev+'">'+
		'<a class="page-link" href="#" data-page="'+(pm.startPage-1)+'">이전</a>'+
	'</li>';
	for(i=pm.startPage; i<=pm.endPage; i++){
		let page = pm.cri.page == i ? 'active' : '';
		str +=
		'<li class="page-item '+page+'">'+
			'<a class="page-link" href="#" data-page="'+i+'">'+i+'</a>'+
		'</li>';
	}
	str +=
	'<li class="page-item '+next+'">'+
		'<a class="page-link" href="#" data-page="'+(pm.endPage+1)+'">다음</a>'+
	'</li>';
	$('.comment-pagination').html(str);
	//페이지네이션 이벤트 등록
	$('.comment-pagination .page-link').click(function(e){
		e.preventDefault();
		let page = $(this).data('page');
		cri.page = page;
		selectCommentList(cri);
	});
}

function selectCommentList(cri){
	ajaxPost(cri, '<c:url value="/comment/list/'+bo_num+'"></c:url>', listSuccess);
}
function insertComment(comment, page){
	ajaxPost(comment, '<c:url value="/comment/insert"></c:url>', insertSuccess);
	cri.page = page;
	selectCommentList(cri);	
}

function insertSuccess(data){
	if(data.res){
		alert('댓글을 등록했습니다.');
		$('[name=co_content]').val('');
	}else{
		alert('댓글을 등록하지 못했습니다.');
	}
}

function ajaxPost(obj, url, successFunction){
	$.ajax({
		async:false,
		type: 'POST',
		data: JSON.stringify(obj),
		url: url,
		dataType:"json",
		contentType:"application/json; charset=UTF-8",
		success : successFunction
	});
}
</script>


