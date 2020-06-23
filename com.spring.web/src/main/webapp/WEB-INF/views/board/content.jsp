<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>${boardNo}번 게시물 내용</h2>
	
	<p>
		# 글번호: ${boardNo} <br>
		# 작성자: ${article.writer} <br>
		# 제목: ${article.title} <br>
		# 내용: <textarea row="3" readonly>${article.content}</textarea> <br>
	</p>
	
	<a href="/web/board/list">글 목록보기</a> &nbsp;
	<a href="/web/board/modify?boardNo=${boardNo}">글 수정하기</a>
	
</body>
</html>