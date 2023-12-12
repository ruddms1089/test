<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : NoticList.jsp
 * @Description : Notic List 화면
 * @Modification Information
 * 
 * @author kke
 * @since 2023-12-10
 * @version 1.0
 * @see
 *  
 * Copyright (C) All right reserved.
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- bootstrap css -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet" />

<title>공지사항 리스트 ex</title>
<!-- kke css
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/sas.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_backdrop.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_breakpoints.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_buttons.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_dropdown.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_navber.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_table.css">
 -->

<!--  egov 기본 css 
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>  -->
<script type="text/javaScript" language="javascript" defer="defer">
	/* 글 수정 화면 function */
	function fn_egov_select(num) {
		document.getElementById("listForm").num.value = num;
		document.getElementById("listForm").action = "<c:url value='/notic/updateNoticView.do'/>";
		document.getElementById("listForm").submit();
	}

	/* 글 등록 화면 function */
	function fn_egov_addView() {
		document.getElementById("listForm").action = "<c:url value='/notic/addNoticView.do'/>";
		document.getElementById("listForm").submit();
	}

	/* pagination 페이지 링크 function */
	function fn_egov_link_page(pageNo) {
		document.getElementById("listForm").pageIndex.value = pageNo;
		document.getElementById("listForm").action = "<c:url value='/notic/NoticList.do'/>";
		document.getElementById("listForm").submit();
	}
</script>
</head>
<body>
	<%@ include file="../include/topmenu3_m.jsp"%>
	<div class="table-container">
		<table class="table table-hover">
			<form:form modelAttribute="searchVO" name="listForm" id="listForm"
				method="post">
				<input type="hidden" name="num" />
				<div id="content_pop">
					<!-- 타이틀 -->
					<div class="d-flex justify-content-between align-items-center mb-2">
      					<div class="title" style="font-size: 24px;">{관리부} 공지사항</div>
      					<button type="button" class="btn btn-primary mb-2 me-1 mt-3">+신규등록</button>
    				</div>
					<!-- // 타이틀 -->
					<!-- List -->
					<div id="table">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<colgroup>
								<col />
								<col />
								<col />
								<col />
								<col />
								<col />
								<col />
							</colgroup>
							<tr>
								<th align="center">No</th>
								<th align="center">Title</th>
								<th align="center">Dates</th>
							</tr>
							<c:forEach var="result" items="${resultList}" varStatus="status">
								<tr>
									<td align="center" class="listtd"><a
										href="javascript:fn_egov_select('<c:out value="${result.num}"/>')"><c:out
												value="${result.num}" /></a>&nbsp;</td>
									<td align="center" class="listtd"><c:out
											value="${result.title}" />&nbsp;</td>
								
									<td align="center" class="listtd"><c:out
											value="${result.dates}" />&nbsp;</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<!-- /List -->
					<div id="paging">
						<ui:pagination paginationInfo="${paginationInfo}" type="image"
							jsFunction="fn_egov_link_page" />
						<form:hidden path="pageIndex" />
					</div>
				</div>
			</form:form>
</body>
</html>