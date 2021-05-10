<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import ="com.koreait.hboard.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<style>
	table, th, td {
		border : 1px solid black;
		border-collapse : collapse;
		width: 400px;
	}
	
</style>
</head>
<body>
	<h1>디테일</h1>
	<a href="/list">리스트</a>
	<div>
		제목 : ${data.title }
	</div>
	<div>
		내용 : ${data.ctnt }
	</div>
	<div>
		작성일 : ${data.regdt }
	</div>
	<div>
		조회수 : ${data.boardcount }
	</div>
	<a href="/mod?iboard=${param.iboard }"><Button>수정하기</Button></a>
	<a href="/del?iboard=${param.iboard }"><Button>삭제하기</Button></a>
	
	<table>
		<tr>
			<th colspan="2">댓글창</th>
		</tr>
		<c:forEach items="${clist}" var="coml">
		<tr>
			<td>${coml.comm }</td>
			<td>${coml.regdt }</td>
		</tr>
		</c:forEach>
	</table>
	
	<form action="/detail" method="post">
		댓글 : <textarea name="comm" rows="4" cols="20"></textarea>
		<input type="hidden" name="iboard" value="${param.iboard }">
		<input type="submit" value="등록">
	</form>
</body>
</html>