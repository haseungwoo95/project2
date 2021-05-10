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
	<form action="mod" method="post">
		<div>
		제목 : <input type="text" name="title" value="${data.title }">
		</div>
		<div>
		내용 : <textarea name="ctnt" rows="10" cols="10">${data.ctnt }</textarea>
		</div>
		<div> <input type="hidden" name="iboard" value="${param.iboard }"></div>
		<div>
			<input type="submit" value="수정">
			<a href="/detail?iboard=${param.iboard }"><button>돌아가기</button></a>
		</div>
	</form>
</body>
</html>