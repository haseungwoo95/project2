<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title }</title>
<script defer src="/res/js/boardDetail.js"></script>
</head>
<body>
	<h1>디테일</h1>
	<a href="list">돌아가기</a>
	<div>게시판 번호 : ${vo.iboard }</div>
	<div>작성자 : ${vo.unm } | 작성일 : ${vo.regdt }</div>
	<c:if test="${loginUser.iuser == vo.iuser}">
		<a href="mod?iboard=${vo.iboard }">수정</a>
		<a href="del?iboard=${vo.iboard }">삭제</a>
	</c:if>
	<div>제목 : ${vo.title }</div>
	<div>${vo.ctnt }</div>
	<h3>댓글</h3>
	<div>
		<form action="cmt" method="post">
			<input type="hidden" name="iboard"	value="${vo.iboard }">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th colspan=2>비고</th>
			</tr>
			<c:forEach items="${requestScope.cmtList}" var="item">
				<tr>
					<td>${item.cmt }</td>
					<td>${item.unm }</td>
					<td>${item.regdate }</td>
					<td>
					<c:if test="${loginUser.iuser == item.iuser }">
						<button>수정</button>
					</c:if>
					</td>
					<td>
					<c:if test="${loginUser.iuser == item.iuser || loginUser.iuser == vo.iuser}">
						<button onclick="delCmt(${vo.iboard}, ${item.icmt });">삭제</button>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>