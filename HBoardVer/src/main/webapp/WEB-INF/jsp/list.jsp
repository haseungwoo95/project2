<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="com.koreait.hboard.*" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	table, th, td {
		border : 1px solid black;
		border-collapse : collapse;
	}
	
	.record{
		cursor : pointer;
	}
	
	.record:hover{
		background-color: #ecf0f1;
	}
</style>
</head>
<body>
	<h1>리스트</h1>
	<div>
		<a href="/write"><Button>글쓰기</Button></a><input type="text" id="searchl" name="searchl"><input type="button" value="검색하기" onclick="searchTo()">
	</div>
	
	<table>
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="item">
		<tr class="record" onclick="moveTo(${item.iboard});">		
			<td>${item.iboard }</td>
			<td>${item.title }</td>
			<td>${item.regdt }</td>
			<td>${item.boardcount}</td>
		</tr>
		</c:forEach>
	</table>
	<script>
		function moveTo(iboard){
			location.href='/detail?iboard='+iboard;
		}
		function searchTo(){
			var searchl = document.getElementById("searchl").value;
			location.href='/list?searchl=' + searchl + '&chksearch=' + 1;
		}
	</script>
</body>
</html>