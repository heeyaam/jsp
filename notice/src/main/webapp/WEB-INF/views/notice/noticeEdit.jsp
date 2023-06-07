<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><h1>게시글 수정</h1></div>
	<div>
		<form id="frm" action="noticeEdit.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">작성자</th>
						<td width="150">
							${notice.noticeWriter }
						</td>
						<th>작성일자</th>
						<td width="150">
							<input type="date" id="noticeWdate" name="noticeWdate" value="${notice.noticeWdate }">
						</td>
					</tr>
					
					<tr>
						<th>제목</th>
						<td width="150">
							<input type="text" id="noticeTitle" name="noticeTitle" value="${notice.noticeTitle }">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td width="150">
							<input type="text" id="noticeSubject" name="noticeSubject" value="${notice.noticeSubhect }" >
						</td>
					</tr>
				</table>
			</div>
			<div>
				<input type="hidden" value="${notice.noticeId }"> 
			</div>
			<div>
			<button type="submit" onclick="location.href='noticeUpdate.do'">수정</button>
			<button type="reset">취소</button>
			<button type="button" onclick="location.href='noticeList.do'">목록</button>
			</div>
		</form>
	</div>
</body>
</html>