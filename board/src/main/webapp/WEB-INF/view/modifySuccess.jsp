<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
게시글을 수정했습니다.
<br>
<a href="${pageContext.request.contextPath}/article/list.do">[게시글 목록보기]</a>
<a href="${pageContext.request.contextPath}/article/read.do?no=${modReq.articleNumber}">[게시글 내용보기]</a>
</body>
</html>