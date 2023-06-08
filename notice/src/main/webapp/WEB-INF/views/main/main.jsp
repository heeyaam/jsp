<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<jsp:include page="menu.jsp"/>
</div>
<div align="center"> 
	<h1>Welcome to My Home</h1>
	<a href="noticeList.do">게시글 목록</a><br>
	<a href="memberList.do">맴버목록 보기</a>
	<a href="memberLoginForm.do">로그인</a>
</div>
<div>
<img alt="배경화면" src="img/cat.jpg" width="100%">
</div>
<div>
	<jsp:include page="footter.jsp"></jsp:include>
</div>
</body>
</html>