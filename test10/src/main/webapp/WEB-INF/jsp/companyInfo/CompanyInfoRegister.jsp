<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : CompanyInfoRegister.jsp
  * @Description : CompanyInfo Register 화면
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

<c:set var="registerFlag" value="${empty companyInfoVO.comNumber ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="companyInfoVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/companyInfo/CompanyInfoList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/companyInfo/deleteCompanyInfo.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/companyInfo/addCompanyInfo.do' : '/companyInfo/updateCompanyInfo.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form modelAttribute="companyInfoVO" name="detailForm" id="detailForm" >
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images//title_dot.gif'/>" alt="" /><c:out value="${registerFlag}"/></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" >
		<colgroup>
			<col width="150"/>
			<col width=""/>
		</colgroup>
			
		<c:if test="${registerFlag == '수정'}">
	   <tr>
			<th>COM_NUMBER *</th>
			<td>
				<form:input path="comNumber" cssClass="essentiality" readonly="true" />
			</td>			
		</tr>	
		</c:if>
		<c:if test="${registerFlag == '등록'}">
	   <tr>
			<th>COM_NUMBER *</th>
			<td>
				<form:input path="comNumber" cssClass="txt" readonly="false" />
			</td>			
		</tr>	
		</c:if>		
		<tr>
			<th>NUM</th>
			<td>
				<form:input path="num" cssClass="txt"/>
				&nbsp;<form:errors path="num" />
			</td>
		</tr>	
		<tr>
			<th>COM_NAME</th>
			<td>
				<form:input path="comName" cssClass="txt"/>
				&nbsp;<form:errors path="comName" />
			</td>
		</tr>	
		<tr>
			<th>COM_CI</th>
			<td>
				<form:input path="comCi" cssClass="txt"/>
				&nbsp;<form:errors path="comCi" />
			</td>
		</tr>	
		<tr>
			<th>COM_EMAIL</th>
			<td>
				<form:input path="comEmail" cssClass="txt"/>
				&nbsp;<form:errors path="comEmail" />
			</td>
		</tr>	
		<tr>
			<th>CEO_NAME</th>
			<td>
				<form:input path="ceoName" cssClass="txt"/>
				&nbsp;<form:errors path="ceoName" />
			</td>
		</tr>	
		<tr>
			<th>ZIP_CODE</th>
			<td>
				<form:input path="zipCode" cssClass="txt"/>
				&nbsp;<form:errors path="zipCode" />
			</td>
		</tr>	
		<tr>
			<th>ADDRESS1</th>
			<td>
				<form:input path="address1" cssClass="txt"/>
				&nbsp;<form:errors path="address1" />
			</td>
		</tr>	
		<tr>
			<th>ADDRESS2</th>
			<td>
				<form:input path="address2" cssClass="txt"/>
				&nbsp;<form:errors path="address2" />
			</td>
		</tr>	
		<tr>
			<th>NOTE</th>
			<td>
				<form:input path="note" cssClass="txt"/>
				&nbsp;<form:errors path="note" />
			</td>
		</tr>	
		<tr>
			<th>CEO_PHONE</th>
			<td>
				<form:input path="ceoPhone" cssClass="txt"/>
				&nbsp;<form:errors path="ceoPhone" />
			</td>
		</tr>	
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();">List</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<c:if test="${registerFlag == '수정'}">
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();">삭제</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			</c:if>
			<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();">Reset</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li></ul>
	</div>
</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
</form:form>
</body>
</html>

