<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title }</title>
<style>
	 table, th, td {
		border : 1px solid black;
		border-collapse : collapse;		
	}	
</style>
</head>
<body>
	<h1>디테일 페이지</h1>
	<div><a href="list">리스트</a></div>
	<div>${param.iboard }</div>
	<div>제목 : ${data.title }</div>
	<div>글쓴이 : ${data.unm }</div>
	<div>작성일 : ${data.regdt }</div>
	<div>${data.ctnt }</div>
	<c:if test="${loginUser.iuser == data.iuser}">
	<div>
		<a href="del?iboard=${param.iboard }&delnum=1">삭제</a>
		<a href="mod?iboard=${param.iboard }">수정</a>
	</div>
	</c:if>
	<table>
		<tr>
			<th colspan=3>댓글창</th>
		</tr>
		<tr>
		<c:forEach items="${commList }" var="item">
			<tr>
				<td>${item.comm }</td>
				<td>${item.unm }</td>
				<td>${item.regdt }</td>
				<c:if test="${loginUser.iuser == item.iuser}">
					<td><a href="">수정</a></td>
				</c:if>
				<c:if test="${loginUser.iuser == item.iuser || loginUser.iuser == data.iuser}">
					<td><a href="del?icomm=${item.icomm }&delnum=2&iboard=${item.iboard}">삭제</a></td>
				</c:if>
			</tr>
		</c:forEach>	
	</table>
	<form action="detail" method="post">
		<textarea cols='30' rows='5' name="comm"></textarea>
		<input type="hidden" name="iboard" value="${param.iboard }">
		<input type="submit" value="댓글작성">
	</form>
</body>
</html>