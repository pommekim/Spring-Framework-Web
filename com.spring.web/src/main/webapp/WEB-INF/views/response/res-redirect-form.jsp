<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- ResponseController 사용 --%>
	<form method="post">
		<p>
			# ID: <input type="text" name="userId" size="10"> <br>
			# PW: <input type="password" name="userPw" size="10"> <br>
			# PW 확인: <input type="password" name="userPwChk" size="10"> <br>
			<input type="submit" value="로그인">
		</p>
	</form>
	
	<p style="color: red;">${msg}</p>

</body>
</html>