<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		<a class="navbar-brand" href="/blog">JJH</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
		
		<c:choose>
			<c:when test="${empty sessionScope.principal }">				<!--  세션이 비어(empty) 있다면 이거하고(로그인 안 되어있다면) -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/blog/user/loginForm">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="/blog/user/joinForm">Join</a></li>
			</ul>
			</c:when>
			
			<c:otherwise>																					<!--  아니면 이거해라(로그인 되어있다면) -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/blog/user/board/writeForm">글쓰기</a></li>
				<li class="nav-item"><a class="nav-link" href="/blog/user/userForm">회원정보</a></li>
				<li class="nav-item"><a class="nav-link" href="/blog/user/logout">로그아웃</a></li>
			</ul>
			</c:otherwise>
		</c:choose>
			
			
			
			
		</div>	
	</nav>
	<br />