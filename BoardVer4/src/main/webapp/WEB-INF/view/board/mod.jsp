<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
	<h1>수정하기</h1>
	<div>
		<div><a href="detail?iboard=${data.iboard }">돌아가기</a></div>
		<form action="mod" method="post">
			<div><input type="text" name="title" placeholder="제목" value="${data.title }"></div>
			<div><textarea name="ctnt">${data.ctnt }</textarea></div>
			<div><input type="hidden" name="iboard" value="${data.iboard }"></div>
			<div>
				<input type="submit" value="수정하기">
			</div>
		</form>
	</div>
</body>
</html>