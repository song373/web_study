<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form action="<c:url value='/user/signup'/>" method="post">
    <input type="text" name="id" placeholder="아이디" value="${id}" required><br>
    <input type="password" name="pw" placeholder="비밀번호" required><br>
    <input type="text" name="name" placeholder="이름" value="${name}" required><br>
    <input type="email" name="email" placeholder="이메일" value="${email}" required><br>
    <input type="text" name="phone" placeholder="전화번호" value="${phone}" required><br>
    <button type="submit">회원가입</button>
</form>
<div style="color:red"><c:if test="${not empty msg}">${msg}</c:if></div>
<a href="<c:url value='/user/login'/>">로그인 화면으로</a>
</body>
</html>
