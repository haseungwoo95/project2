<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>작성일시</th>
	</tr>
	<c:forEach items="${requestScope.list }" var="item">
		<tr>
			<td>${item.iboard }</td>
			<td>${item.title }</td>
			<td>${item.writerNm }</td>
			<td>${item.regdt }</td>
		</tr>
	</c:forEach>
</table>