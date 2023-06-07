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
	<h1>${message }</h1>
	<button type="button" onclick="location.href='memberList.do'">맴버 목록</button>
	<jsp:include page="../main/footter.jsp"></jsp:include>
</div>
</body>
</html>