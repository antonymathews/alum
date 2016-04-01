<!-- 
Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
With inputs from 
Biajay Sahoo			batch-2001
Sundeep Mohanty (Tutu)	batch-2001
Sambit Satpathy			batch-2000
Soumya Ranjan Parida  (Bapi) 	batch-2001
Kamalesh Nayak			batch-2001
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All members</title>
<jsp:directive.include file="menu.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

</head>
<body>
<div class="panel">
	<form:form method="POST" modelAttribute="searchMemberForm" class="form-horizontal">
		<form:select path="type" id="type" >
		<form:option value="batch" >Batch</form:option>
		<form:option value="name" >Name</form:option>
		<form:option value="location" >Location</form:option>
		</form:select>
		<form:input path="search" id="search"/>
		<input type="submit" value="Search"/>
	</form:form>
	<h2>List of Members</h2>	
	<table class="table" id="commonTable">
		<thead>
		<tr>
			<th>batch</th>
			<th>Name</th>
			<th>email</th>
			<th>roll no.</th>
			<th>contact no.</th>
			<th>contact address</th>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th>Regd dt</th>
				<th>Enabled</th>
				<th></th>
			</sec:authorize>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${members}" var="member" varStatus="cnt">
			<tr>
			<td>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="<c:url value='/admin-edit-${member.id}-member' />">edit</a>
				</sec:authorize>
				${member.batchYear}</td>
			<td>
				<a href="<c:url value='/member-${member.id}-view' />">${member.name}</a>
			</td>
			<td>${member.contactEmail}</td>
			<c:if test="${not empty member.contactEmail}" >
				<c:set var="emailList" value="${emailList}${cnt.first ? '' : ', '} ${member.contactEmail}" />
			</c:if>
			<td>${member.rollNumber}</td>
			<!--  if member.displayContact is true -->
			<td>
				<c:if test="${member.displayContact}">
					${member.contactNumber}
				</c:if>
			</td>
			<td>
				<c:if test="${member.displayContact}">
					${member.contactAddress}
				</c:if>
			</td>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<td>${member.registrationDate }</td>
				<td>${member.enabled }</td>
				<td><a href="<c:url value='/admin-delete-${member.id}-member' />">delete</a></td>
			</sec:authorize>
			</tr>
		</c:forEach>
		</tbody>
	</table>	
</div>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<div class="xs-12">Copy paste the email list below into an email tool 
		to send email to the above search result</div>
	<div class="xs-12">
		<b>Emails:</b> ${emailList}
	</div>
</sec:authorize>
</body>

</html>