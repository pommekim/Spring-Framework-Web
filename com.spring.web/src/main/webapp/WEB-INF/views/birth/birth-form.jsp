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
		1. BirthController를 생성 후,
		다음 생년월일을 받아서 콘솔에 출력하는 메서드를 생성 (url: /birth : POST)
		조건) BirthVO 커맨드객체 사용, 콘솔에 전송된 값을 붙여서 출력합니다. ex)19921013
		2. birth-result.jsp 페이지에 "당신의 생일은 ~~~~년 ~~월 ~~일 입니다."를 출력하세요.
	 --%>
	 

	<form action="<c:url value='/birth' />" method="post">
		<fieldset>
			<legend>생일 등록 양식</legend>
			<p>
				# 생년월일:
				<input type="text" name="year" size="6" maxlength="4" placeholder="연도(4자리)">
				
					<select name="month">
						<c:forEach var="m" begin="1" end="12">
							<%-- option value속성을 통해 필요한 숫자만 얻어올 수 있게 함!!! --%>
							<option value="${m}">${m}월</option>
						</c:forEach>
					</select>
				
				<input type="text" name="day" size="4" maxlength="2" placeholder="일(1-31)">
				<input type="submit" value="확인">
			</p>
		</fieldset>
	</form>

</body>
</html>