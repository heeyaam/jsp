<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id= "frm" action="MemberLogin.do" method="post">
		<div>
			<h1>로 그 인</h1>
		</div>
		<div>
			아이디 <input type="email" id="memberId" name="memberId" >
		    비밀번호 <input type="password" id="memberPassword" name="memberPassword">
			<button type="submit">로그인</button>
			<button type="reset"> 리셋</button>

		</div>
	</form>
</body>
</html>