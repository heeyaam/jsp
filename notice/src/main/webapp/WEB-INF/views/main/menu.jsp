<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#topMenu{
		background: black;
		width: 1000px;
		margin: 0 auto;
	}
	#topMenu ul{
		list-style:none;
		display: flex;
		justify-content: space-around;
		margin:0;
		padding: 0;
	}
	#topMenu li{
		margin: 0;
		padding: 10px;
	}
	.menuLink{
		color: white;
		text-decoration: none;
	}
</style>
</head>
<body>
	<div>
		<nav id="topMenu">
			<ul>
				<li><a class="menuLink" href="main.do">Home</a></li>
				<li><a class="menuLink" href="noticeList.do">Notice</a></li>
				<c:if test="${empty id }">
					<li><a class="menuLink" href="memberJoin.do">MemberJoin</a></li>
				</c:if>
				<li><a class="menuLink" href="memberList.do"></a>Member</li>
				<li><a class="menuLink" href="productList.do">제품관리</a></li>
				<li><a class="menuLink" href="보류">2보류</a></li>
				<c:if test="${not empty id }">
					<li><a class="menuLink" href="memberLogout.do">Logout</a></li>    <!-- 로그인 전후 다르게 하는거 el표현식으로할수 있다 -->
				</c:if>
				<c:if test="${not empty name }">
					<li><a class="menuLink" href="#">${name }님 로그인</a></li>    <!-- 로그인 전후 다르게 하는거 el표현식으로할수 있다 -->
				</c:if>
			</ul>
		</nav>
	</div>
</body>
</html>