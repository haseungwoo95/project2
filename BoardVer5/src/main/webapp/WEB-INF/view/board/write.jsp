<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>
	<h1>글쓰기</h1>
	<a href="list">돌아가기</a>
	<form action="write" method="post">
		<div><input type="text" name="title" placeholder="제목"></div>
		<div><textarea rows="10" cols="30" name="ctnt"></textarea></div>
		<div><input type="submit" value="작성하기"></div>
		<div><input type="reset" value="취소"></div>
	</form>
</body>
</html>