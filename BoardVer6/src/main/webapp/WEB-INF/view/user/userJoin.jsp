<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div>
	<div>
		<a href="login">login으로 이동</a>
	</div>
	<form id="frm">
		<div>
			<input type="text" name="uid" placeholder="아이디">
		</div>
		<div>
			<input type="text" name="upw" placeholder="비밀번호">
		</div>
		<div>
			<input type="text" name="unm" placeholder="이름">
		</div>
		<div>
			성별 : <label>여성<input type="radio" name="gender" value="0"
				checked></label> <label>남성<input type="radio" name="gender"
				value="1"></label>
		</div>
	</form>
	<input type="button" value="회원가입" onclick="join();">

	<script>
		function join() {
			var frmElem = document.querySelector('#frm');
			var uid = frmElem.uid.value;
			var upw = frmElem.upw.value;
			var unm = frmElem.unm.value;
			var gender = frmElem.gender.value;

			var param = {uid, upw, unm, gender};
			
			ajax(param);
		}
		
		function ajax(param){
			const init = {
					method: 'POST',
					body: new URLSearchParams(param)
			}
			fetch('/user/join', init)
			.then(function(res) { return res.json(); })
			.then(function(myJson) {
				switch(myJson.result){
				case 0:
					alert('회원가입 실패');
					break;
				case 1:
					location.href = '/user/login';
				}
			});		
		}
	</script>
</div>