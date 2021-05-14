<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 페이지</title>
</head>
<body>
	<h1>리스트 페이지</h1>
	<div>${loginUser.unm } (${loginUser.uid })님 환영합니다. <a href="/user/logout"><button>Logout</button></a></div>
	<div><a href="write">글쓰기</a></div>
	<table>
		<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="item">
			<tr onclick="moveToDetail(${item.iboard })">
				<td>${item.iboard }</td>
				<td>${item.title }</td>
				<td>${item.unm }</td>
				<td>${item.regdt }</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		function moveToDetail(iboard){
			location.href='detail?iboard=' + iboard;
		}
	</script>
</body>
</html>