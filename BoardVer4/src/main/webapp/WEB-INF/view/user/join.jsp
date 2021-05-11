<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div>
		<a href="login">로그인 돌아가기</a>
	</div>
	<div>
		<form action="join" method="post">
			<div>
				<input type="text" name="uid" placeholder="아이디">
			</div>
			<div>
				<input type="text" name="upw" placeholder="비밀번호">
			</div>
			<div>
				<input type="text" name="unm" placeholder="이름">
			</div>
			<div>
				<label>여자<input type="radio" name="gender" value="0" checked></label>
				<label>남자<input type="radio" name="gender" value="1"></label>
			</div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
</body>
</html>