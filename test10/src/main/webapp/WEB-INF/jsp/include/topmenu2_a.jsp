<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
      rel="stylesheet"
    />
    <title>기업 관리자</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body class="p-3 m-0 border-0 bd-example m-0 border-0">
    <!-- Example Code -->

    <ul class="nav nav-tabs">
      <li class="nav-item">
        <a class="nav-link" href="#">근태현황보드</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">공지사항관리</a>
      </li>
      <li class="nav-item dropdown">
        <a
          class="nav-link dropdown-toggle"
          data-bs-toggle="dropdown"
          href="#"
          role="button"
          aria-expanded="false"
          >회사정보관리</a
        >
        <ul class="dropdown-menu" style="">
          <li><a class="dropdown-item" href="#">회사 정보 관리</a></li>
          <li><a class="dropdown-item" href="#">부서 그룹 관리</a></li>
          <li><a class="dropdown-item" href="#">부서 그룹 현황 인쇄</a></li>
          <li><a class="dropdown-item" href="#">직원 등록 관리</a></li>
          <li><a class="dropdown-item" href="#">직원 목록 인쇄</a></li>
        </ul>
      </li>
      <li class="nav-item dropdown">
        <a
          class="nav-link dropdown-toggle"
          data-bs-toggle="dropdown"
          href="#"
          role="button"
          aria-expanded="false"
          >근태 관리</a
        >
        <ul class="dropdown-menu" style="">
          <li><a class="dropdown-item" href="#">근태 일정 관리</a></li>
          <li><a class="dropdown-item" href="#">근태 일정 등록</a></li>
          <li><a class="dropdown-item" href="#">근태 일정 인쇄</a></li>
          <li><a class="dropdown-item" href="#">근태 통계</a></li>
        </ul>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">접속 로그</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">고객 센터</a>
      </li>
      <form class="d-flex ms-auto" role="search">
        <button type="button" class="btn btn-primary mb-2 me-1">회원 정보</button>
        <button type="button" class="btn btn-primary mb-2 ">로그아웃</button>
      </form>

      </ul>
  </body>
</html>
