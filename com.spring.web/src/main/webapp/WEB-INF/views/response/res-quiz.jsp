<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		1. res-quiz 파일의 화면처리를 할 수 있는 메서드를 생성하세요. (res-quiz 맵핑)
		2. 폼 태그의 action URL은 res-login으로 설정하세요.
		3. ID: kim123, PW: kkk1234 라면 res-quiz-success.jsp 페이지로 이동해서
		"로그인 성공!" "(회원 ID)님 환영합니다!"를 출력.
		4. 아니라면 res-quiz-fail.jsp 페이지로 이동해서
		"로그인 실패!" "(회원 ID)는 회원이 아니거나 비밀번호가 다릅니다."를 출력.
	 --%>

	<form action="<c:url value='/response/res-login' />" method="post">
		<p>
			#ID: <input type="text" name="userId" size="10"> <br>
			#PW: <input type="password" name="userPw" size="10"> <br>
			<input type="submit" value="확인">
		</p>
	</form>

</body>
</html>