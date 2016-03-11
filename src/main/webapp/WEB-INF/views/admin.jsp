<!-- 
Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
With inputs from 
Biajay Sahoo			batch-2001
Sundeep Mohanty (Tutu)	batch-2001
Sambit Satpathy			batch-2000
Soumya Mohanty (Bapi) 	batch-2001
Kamalesh Nayak			batch-2001
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage members</title>
<jsp:directive.include file="menu.jsp" />
</head>
<body>
<div class="panel">
	message : ${success}
	<br/>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h1>Page to manage members</h1>
		<ul>
			<li><a href="<c:url value='/admin-member-new-list' />">
				List of newly registered members</a></li>
			<li><a href="<c:url value='/admin-member-list' />">
				Manage members (takes to list and allow edit on all fields)</a></li>
		</ul>
	</sec:authorize>
</div>
</body>
</html>