<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
			forward는 그냥 메인. 으로 던져버림(위임: 니가해) -> 새로운 일이 되버림:response와 request 두번 만듬(페이지 전환시 사용?),
			dispatcher는 ->위탁받은일을 위임(무슨일을 하는지 앎)  request를 매번 만드는 것은 같지만 이전의 request를 담는다
			서버에 호출할 때마다 항상 서버가 response와 request를 만듬(session은 처음에 한번 만듬)
			-->
	<!-- jsp action 부분  -->
	<jsp:forward page="main.do" />

</body>
</html>