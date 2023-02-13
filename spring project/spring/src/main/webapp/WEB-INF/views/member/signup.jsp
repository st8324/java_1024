<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
label.error{color:red;}
</style>
<link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui.min.css'></c:url>">
<div class="container">
	<h1>회원가입</h1>
	<form action="<c:url value='/signup'></c:url>" method="post">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<button class="btn btn-outline-success col-12" type="button" onclick="alert('추후 구현')">아이디 중복체크</button>
		<div class="form-group">
			<label for="pw">비번:</label>
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		<div class="form-group">
			<label for="pw2">비번확인:</label>
			<input type="password" class="form-control" id="pw2" name="me_pw2">
		</div>
		<div class="form-group">
			<label for="email">이메일:</label>
			<input type="text" class="form-control" id="email" name="me_email">
		</div>
		<div class="form-group">
			<label for="birthday">생년월일</label>
			<input type="text" class="form-control" id="birthday" name="me_birthday">
		</div>
		<button class="btn btn-outline-success col-12">회원가입</button>
	</form>
</div>
<script src="<c:url value='/resources/js/jquery.validate.min.js'></c:url>"></script>
<script src="<c:url value='/resources/js/additional-methods.min.js'></c:url>"></script>
<script src="<c:url value='/resources/js/jquery-ui.min.js'></c:url>"></script>
<script>
	$('form').validate({
		rules:{
			me_id : {
				required : true,
				regex : /^[a-zA-Z][a-zA-Z0-9!@#$]{4,12}$/
			},
			me_pw : {
				required : true,
				regex : /^[a-zA-Z0-9!@#$]{8,20}$/
			},
			me_pw2 : {
				equalTo : pw
			},
			me_email : {
				required : true,
				email : true
			},
			me_birthday : {
				required : true,
				date : true
			}
		},
		messages:{
			me_id : {
				required : '필수 항목입니다.',
				regex : '아이디는 영문자로 시작하며, 영문,숫자,!@#$를 이용하여 5~13까지 가능합니다.'
			},
			me_pw : {
				required : '필수 항목입니다.',
				regex : '비번은 영문,숫자,!@#$를 이용하여 8~20까지 가능합니다.'
			},
			me_pw2 : {
				equalTo : '비번과 일치하지 않습니다.'
			},
			me_email : {
				required : '필수 항목입니다.',
				email : '이메일 형식이 아닙니다.'
			},
			me_birthday : {
				required : '필수 항목입니다.',
				date : '날짜 형식이 아닙니다.'
			}
		}
	});
	$.validator.addMethod(
		"regex",
		function(value, element, regexp) {
			var re = new RegExp(regexp);
			return this.optional(element) || re.test(value);
		},
		"Please check your input."
	);
	$( function() {
	    $( "#birthday" ).datepicker({
	    	dateFormat : 'yy-mm-dd'
	    });
	});
</script>

