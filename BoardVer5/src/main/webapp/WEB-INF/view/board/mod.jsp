<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title }</title>
</head>
<body>
	<h1>수정하기</h1>
	<a href="detail?iboard=${vo.iboard }">돌아가기</a>
	<form action="mod" method="post">
		<div><input type="hidden" name="iboard" value="${vo.iboard }"></div>
		<div><input type="text" name="title" value="${vo.title }"></div>
		<div><textarea rows="10" cols="30" name="ctnt">${vo.ctnt }</textarea></div>
		<div><input type="submit" value="수정하기"></div>
	</form>
</body>
</html>