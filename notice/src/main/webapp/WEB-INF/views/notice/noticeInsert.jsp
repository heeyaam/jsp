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
		<h1>게시글 등록</h1>
	</div>
	<div>
		<form id="frm" action="noticeInsert.do" method="post">
			<div>
				<table>
					<tr>
						<th>작성자</th>
						<td width="150"><input type="text" value="${name }"></td>
						<th>작성일자</th>
						<td width="150"><input type="date"></td>
					</tr>

					<tr>
						<th>제목</th>
						<td width="150"><input type="text"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td width="150"><input type="text"></td>
					</tr>
				</table>
			</div>
			<div>
				<button type="submit">등록</button>
				<button type="reset">취소</button>
				<button type="button" onclick="location.href='noticeList.do'">목록</button>
			</div>
		</form>
	</div>
</body>
</html>