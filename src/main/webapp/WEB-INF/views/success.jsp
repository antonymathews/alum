<!-- 
Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
With inputs from 
Biajay Sahoo			batch-2001
Sundeep Mohanty (Tutu)	batch-2001
Sambit Satpathy			batch-2000
Soumya Ranjan Parida (Bapi) 	batch-2001
Kamalesh Nayak			batch-2001
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success page</title>
<jsp:directive.include file="menu.jsp" />


</head>
<body>
<div class="panel">
	message : ${success}
	<br/>
	<br/>
	<sec:authorize access="hasRole('ROLE_USER')">
		<h1>This is for role user</h1>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	Go back to 
	
	</sec:authorize>
</div>
</body>

</html>