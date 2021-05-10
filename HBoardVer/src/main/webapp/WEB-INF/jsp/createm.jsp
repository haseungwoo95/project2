<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.koreait.hboard.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	table, th, td {
		border : 1px solid black;
		border-collapse : collapse;
	} 
	
</style>
</head>
<h1>회원가입</h1>
	<form action="/createm" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="Idd" name="Id" value="${param.id }"></td>
				<td><input type="button" value="중복확인" onclick="chkId();"></td>
				<td><input type="hidden" name="idchko" value="${param.idchko }"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td colspan="2"><input type="text" id="Pww" name="Pw" value="${param.pw }"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td colspan="2"><input type="text" id="Pwchkk" name="Pwchk" value="${param.pwchk }"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td colspan="2"><input type="text" id="Nmm" name="Nm" value="${param.nm }"></td>
			</tr>
		</table>
		<input type="submit" value="회원가입">
		<input type="reset" value="취소" >
	</form>
	<a href="/login"><Button>돌아가기</Button></a>
	<script>
		function chkId(){
			var Id = document.getElementById("Idd").value;
			/*var Pw = document.getElementById("Pww").value;
			var Pwchk = document.getElementById("Pwchkk").value;
			var Nm = document.getElementById("Nmm").value;*/
			if(Id != ''){
			location.href='/idcheck?id='+Id;//+'&pw='+Pw+'&pwchk='+Pwchk+'&nm='+Nm;
			} else {
				alert('아이디를 입력하세요');
			}
		}
	</script>
</body>
</html>

