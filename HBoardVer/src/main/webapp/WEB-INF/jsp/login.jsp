<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<div>
		<div>
			<form action="/login" method="post">
				<div>
					<input type="text" name="Id" placeholder="아이디">
				</div>
				<div>
					<input type="password" name="Pw" placeholder="비밀번호">
				</div>
				<input type="submit" value="로그인">
			</form>
		</div>
		<div>
			<a href="/createm"><Button>회원가입</Button></a>
		</div>
	</div>
</body>
</html>