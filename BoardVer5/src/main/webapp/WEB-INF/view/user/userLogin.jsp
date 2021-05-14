<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<div>${errMsg }</div>
	<form action="userLogin" method="post">
		<div><input type="text" name="uid" placeholder="아이디"></div>
		<div><input type="password" name="upw" placeholder="비밀번호"></div>
		<div><input type="submit" value="로그인"></div>
	</form>	
	<div><a href="userJoin">회원가입</a></div>
</body>
</html>