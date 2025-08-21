<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="<c:url value='/user/login'/>" method="post">
    <input type="text" name="id" placeholder="아이디" value="${id}" required><br>
    <input type="password" name="pw" placeholder="비밀번호" required><br>
    <button type="submit">로그인</button>
</form>
<a href="<c:url value='/user/signup'/>">회원가입</a>
<a href="<c:url value='/user/find'/>">아이디/비밀번호 찾기</a>
<div style="color:red"><c:if test="${not empty msg}">${msg}</c:if></div>
<!-- 간편 로그인 UI (동작X) -->
<button onclick="alert('아직 지원되지 않습니다');">네이버 로그인</button>
<button onclick="alert('아직 지원되지 않습니다');">카카오 로그인</button>
</body>
</html>
