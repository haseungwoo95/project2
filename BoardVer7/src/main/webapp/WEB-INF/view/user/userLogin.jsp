<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>${requestScope.errMsg }</div>
<form action="login" method="post">
	<div>
		<input type="text" name="uid" placeholder="아이디">
	</div>
	<div>
		<input type="password" name="upw" placeholder="비밀번호">
	</div>
	<div>
		<input type="submit" value="로그인">
	</div>
</form>
<div>
	<a href="join">회원가입</a>
</div>