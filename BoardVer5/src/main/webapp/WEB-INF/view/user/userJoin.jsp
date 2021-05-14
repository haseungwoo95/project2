<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div><a href="userLogin">돌아가기</a></div>
	<form action="userJoin" method="post">
		<div><input type="text" name="uid" placeholder="아이디"></div>
		<div><input type="text" name="upw" placeholder="비밀번호"></div>
		<div><input type="text" name="unm" placeholder="이름"></div>
		<div>
			<label><input type="radio" name="gender" value="0" checked>남자</label>
			<label><input type="radio" name="gender" value="1">여자</label>
		</div>
		<div><input type="submit" value="회원가입"></div>
		<div><input type="reset" value="취소"></div>
	</form>
</body>
</html>