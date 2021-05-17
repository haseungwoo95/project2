<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 페이지</title>
<script defer src="/res/js/boardList.js?ver=1"></script>
<link href="/res/css/boardList.css?ver=2" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>리스트 페이지</h1>
	<div>${sessionScope.loginUser.unm } (${sessionScope.loginUser.uid })님 환영합니다. <a href="/user/logout"><button>Logout</button></a></div>
	<div><a href="write">글쓰기</a></div>
	<table>
		<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="item">
			<tr class="record" onclick="moveToDetail(${item.iboard })">
				<td>${item.iboard }</td>
				<td>${item.title }</td>
				<td>${item.unm }</td>
				<td>${item.regdt }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>