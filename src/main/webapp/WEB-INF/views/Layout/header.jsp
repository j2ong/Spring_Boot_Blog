<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/> <!-- 값이 principal에 저장되어 30줄의 JSTL문법안의 principal 사용가능 -->
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- 반응형, 크기를 줄이면 같이 반응하기 위함 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script> <!-- 라이브러리 실행 후 JS 실행되어야 라이브러리를 읽음 -->
</head>
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">	
		<a class="navbar-brand" href="/">JJH</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
		
		<!-- JSTL 문법 -->
		<c:choose>
			<c:when test="${empty sessionScope.principal }">				<!--  세션이 비어(empty) 있다면 이거하고(로그인 안 되어있다면) -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/loginForm">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="/joinForm">Join</a></li>
			</ul>
			</c:when>
			
			<c:otherwise>																					<!--  아니면 이거해라(로그인 되어있다면) -->
		<!-- JSTL 문법 -->
			
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/board/Form">글쓰기</a></li>
				<li class="nav-item"><a class="nav-link" href="/user/Form">회원정보</a></li>
				<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
			</ul>
			</c:otherwise>
		</c:choose>
			
			
			
			
		</div>	
	</nav>
	<br />