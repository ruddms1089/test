<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : CompanyInfoList.jsp
  * @Description : CompanyInfo List 화면
  * @Modification Information
  * 
  * @author kke
  * @since 23-12-07
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
<title>목록</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 수정 화면 function */


function fn_egov_select(comNumber) {
	document.getElementById("listForm").comNumber.value = comNumber;
   	document.getElementById("listForm").action = "<c:url value='/companyInfo/updateCompanyInfoView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/companyInfo/addCompanyInfoView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/companyInfo/CompanyInfoList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form modelAttribute="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="comNumber" />
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt="title" /> List </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
							</colgroup>		  
			<tr>
								<th align="center">ComNumber</th>
								<th align="center">Num</th>
								<th align="center">ComName</th>
								<th align="center">ComCi</th>
								<th align="center">ComEmail</th>
								<th align="center">CeoName</th>
								<th align="center">ZipCode</th>
								<th align="center">Address1</th>
								<th align="center">Address2</th>
								<th align="center">Note</th>
								<th align="center">CeoPhone</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
													<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.comNumber}"/>')"><c:out value="${result.comNumber}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.num}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.comName}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.comCi}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.comEmail}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ceoName}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.zipCode}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.address1}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.address2}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.note}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ceoPhone}"/>&nbsp;</td>
				    			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
	<div id="paging">
		<ui:pagination paginationInfo = "${paginationInfo}"
				   type="image"
				   jsFunction="fn_egov_link_page"
				   />
		<form:hidden path="pageIndex" />
	</div>
	<div id="sysbtn1">
		<ul>
			<li>
				<div id="sysbtn">
					<span class="btn_blue_l"><a href="javascript:fn_egov_addView();">등록</a><img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" alt="" />
					</span>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>
</html>
