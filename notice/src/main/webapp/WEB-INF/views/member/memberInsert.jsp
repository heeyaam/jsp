<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<ul>
			<li>메뉴</li>
		</ul>

		<div>
			<h1>회 원 가 입</h1>

		<div>
			<form id="frm" action="memberInsert.do" onsubmit="formCheck()" method="post">
				<table>
					<tr>
						<th>*아이디</th>
						<td><input type="email" id="memberId" name="memberId">
							<button type="button" id="checkId" value="No" onclick="idCheck()">중복체크</button>
						</td>
					</tr>
					<tr>
						<th>*비밀번호</th>
						<td><input type="password" id="memberPassword"
							name="memberPassword"></td>
					</tr>
					<tr>
						<th>*비밀번호 확인</th>
						<td><input type="password" id="Passwordcheck"
							name="Passwordcheck"></td>
					</tr>
					<tr>
						<th>*이름</th>
						<td><input type="text" id="memberName" name="memberName" required="required"> <!-- 단일항목비교 -->
						</td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="text" id="memberAge" name="memberAge">
						</td>
					</tr>
					<tr>
						<th>*전화번호</th>
						<td><input type="tel" id="memberTel" name="memberTel">
						</td>
					</tr>
					<tr>
						<th>*성별</th>
						<td><input type="text" id="memberGender" name="memberGender" required="required">
						</td>
					</tr>
				</table>
				<div>
					<input type="submit" value="등록">
					<input type="reset" value="취소">
					<input type="button" onclick="location.href='main.do'" value="홈가기">
				</div>
			</form>
		</div>
	</div>
<script type="text/javascript">
	function formCheck(){
		let frm = document.getElementById("frm");
		if(frm.memberPassword.value != frm.Passwordcheck.value){
			alert("패스워드가 일치하지 않습니다")
			frm.memberPassword.value = "";
			frm.Passwordcheck.value="";
			frm.memberPassword.focus();
			return false;
		}if else(frm.checkId.value !="Yes"){
				alert("아이디 중복체크를 수행하세요");
				return false;
			}
		return true;
	}
	
	function idCheck(){
		let id= document.getElementById("memberId").value;
		let checkId = document.getElementById("checkId").value;
		let url = "ajaxCheckId.do?id="+id;
		fetch(url)
			.
	}
	
	
</script>
</body>
</html>