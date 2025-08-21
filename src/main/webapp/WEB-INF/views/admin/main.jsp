<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>관리자 메인 페이지</h1>
<p>환영합니다 관리자 ${admin}님!</p>

<a href="${pageContext.request.contextPath}/admin/logut">로그아웃</a>
</body>
</html>