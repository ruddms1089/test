<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>시스템 관리자</title>
<!-- 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  --> 
</head>

<style>
.navbar-brand img {
	width: 100px; /* 원하는 너비로 조절 */
	height: 68px; /* 원하는 높이로 조절 */
}
</style>

<body class="p-3 m-0 border-0 bd-example m-0 border-0">
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a class="navbar-brand" href="#"> 
					<img src="img/atozsystem_Logo.png" alt="atoz_Logo" width="30" height="24">
				</a>
			</li>
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false">기업 관리</a>
				<ul class="dropdown-menu" style="">
					<li><a class="dropdown-item" href="#">기업 등록 관리</a></li>
					<li><a class="dropdown-item" href="#">기업 목록 인쇄</a></li>
					<li><a class="dropdown-item" href="#">기업 관리자 기능</a></li>
				</ul></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false">코드 관리</a>
				<ul class="dropdown-menu" style="">
					<li><a class="dropdown-item" href="#">코드 등록 관리</a></li>
					<li><a class="dropdown-item" href="#">코드 목록 인쇄</a></li>
				</ul></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false">비콘 관리</a>
				<ul class="dropdown-menu" style="">
					<li><a class="dropdown-item" href="#">비콘 등록 관리</a></li>
					<li><a class="dropdown-item" href="#">비콘 목록 인쇄</a></li>
				</ul></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false">통계 관리</a>
				<ul class="dropdown-menu" style="">
					<li><a class="dropdown-item" href="#">통계 프로그램 등록 관리</a></li>
					<li><a class="dropdown-item" href="#">통계 프로그램 목록 인쇄</a></li>
				</ul></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false">고객 센터</a>
				<ul class="dropdown-menu" style="">
					<li><a class="dropdown-item" href="#">Q/A 게시판</a></li>
					<li><a class="dropdown-item" href="#">문의 목록 인쇄</a></li>
				</ul></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false">자료 관리</a>
				<ul class="dropdown-menu" style="">
					<li><a class="dropdown-item" href="#">DB 자료 관리</a></li>
					<li><a class="dropdown-item" href="#">DB 관리 내용 목록 인쇄</a></li>
				</ul></li>
			<form class="d-flex ms-auto" role="search">
				<button type="button" class="btn btn-primary mb-2 me-1">회원
					정보</button>
				<button type="button" class="btn btn-primary mb-2 ">로그아웃</button>
			</form>
		</ul>
</body>
</html>
