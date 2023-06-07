<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 외부에서 사용하는 라이브러리중 내부 페이지에 영향을 주는 것 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 목록</h1>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="100">순번</th>
						<th width="150">작성자</th>
						<th width="200">제목</th>
						<th width="150">작성일자</th>
						<th width="100">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${notices }" var="n">
						<tr onclick="noticeChois(${n.noticeId })">
							<td align="center">${n.noticeId }</td>
							<td align="center">${n.noticeWriter }</td>
							<td>${n.noticeTitle }</td>
							<td align="center">${n.noticeWdate }</td>
							<td align="center">${n.noticeHit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br>
		<div>
			<c:if test="${not empty id }">
				<button type="button" onclick="location.href='noticeInsertForm.do'">새글작성</button>
			</c:if>
		</div>
		<div>
			<form id="frm" action="noticeSelect.do" method="post">
				<input type="hidden" id="noticeId" name="noticeId">
			</form>
		</div>
	</div>

	<script type="text/javascript">
	function noticeChois(id){
		let frm = document.getElementById("frm");
		frm.noticeId.value = id;
		frm.submit();
	}
</script>
</body>
</html>