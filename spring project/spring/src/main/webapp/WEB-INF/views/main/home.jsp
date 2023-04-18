<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-fluid">
	<h1>스프링</h1>
	<a href="/spring/ex1">데이터 전송 예제1</a> <br>
	<a href="/spring/ex2">데이터 전송 예제2</a> <br>
	<a href="/spring/ex3">데이터 전송 예제3</a> <br>
	<a href="/spring/ex4">데이터 전송 예제4</a> <br>
	<a href="/spring/ex5?num=2022123001">DB 연결 예제5</a> <br>
	<a href="/spring/ex6">화면에서 서버로 전송예제 리스트로</a> <br>
</div>
<<script type="text/javascript">
const sse = new EventSource("<c:url value='/connect'></c:url>");
sse.addEventListener('connect', (e) => {
	const { data: receivedConnectData } = e;
	console.log('connect event data: ',receivedConnectData);  // "connected!"
	console.log(new Date())
});
sse.addEventListener('count', e => {  
    const { data: receivedCount } = e;  
    console.log("count event data",receivedCount);  
});
</script>
