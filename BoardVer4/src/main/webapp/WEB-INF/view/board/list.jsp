<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>로그인 성공</div>
	<div>${loginUser.unm}님 (${loginUser.uid }) 환영합니다. <a href="/user/logout">Logout</a>
	</div>
	<div>
		<a href="write">글쓰기</a>
	</div>
	<div>
		리스트
	</div>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성시간</th>
		</tr>
		<c:forEach items="${list }" var="item">
			<tr>
				<td>${item.iboard }</td>
				<td>${item.title }</td>
				<td>${item.unm }</td>
				<td>${item.regdt }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>