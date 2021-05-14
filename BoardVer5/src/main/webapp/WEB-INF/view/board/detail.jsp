<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title }</title>
</head>
<body>
	<h1>디테일</h1>
	<a href="list">돌아가기</a>
	<div>게시판 번호 : ${vo.iboard }</div>
	<div>작성자 : ${vo.unm }</div>
	<div>작성일 : ${vo.regdt }</div>
	<c:if test="${loginUser.iuser == vo.iuser}">
		<a href="mod?iboard=${vo.iboard }">수정</a>
		<a href="del?iboard=${vo.iboard }">삭제</a>
	</c:if>
	<div>제목 : ${vo.title }</div>
	<div>${vo.ctnt }</div>
</body>
</html>