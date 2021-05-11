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
	<table>
		<tr>
			<td>제목</td>
			<td>${data.title }</td>
			<td>작성일</td>
			<td> ${data.regdt }</td>
			<td>조회수</td>
			<td>${data.boardcount }</td>
		</tr>
		<tr>
			<td colspan=6>${data.ctnt }</td>
		</tr>
		<tr>	
			<td><a href="/mod?iboard=${param.iboard }"><Button>수정하기</Button></a></td>
			<td><a href="/del?iboard=${param.iboard }"><Button>삭제하기</Button></a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th colspan=2>댓글창</th>
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