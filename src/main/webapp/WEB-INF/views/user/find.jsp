<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>아이디/비밀번호 찾기</h1>
<form action="<c:url value='/user/findId'/>" method="post">
    <input type="email" name="email" placeholder="이메일" required>
    <button type="submit">아이디 찾기</button>
</form>
<form action="<c:url value='/user/findPw'/>" method="post">
    <input type="text" name="id" placeholder="아이디" required>
    <input type="email" name="email" placeholder="이메일" required>
    <button type="submit">비밀번호 찾기</button>
</form>
<div style="color:blue"><c:if test="${not empty findId}">아이디: ${findId}</c:if></div>
<div style="color:green"><c:if test="${not empty msg}">${msg}</c:if></div>
<a href="<c:url value='/user/login'/>">로그인</a>
</body>
</html>
