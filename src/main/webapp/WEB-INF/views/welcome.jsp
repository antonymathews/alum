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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumni Application</title>
<jsp:directive.include file="common.jsp" />
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value='/' />">
      	<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
      	IMIT-ALUMNI-APP
      </a>
    </div>
    <div class="navbar-header">
		<a href="<c:url value='/member-home' />" class="btn btn-default navbar-btn" role="button">Members</a>
	</div>
	<div class="navbar-header">
		<a href="<c:url value='/signup' />" class="btn btn-default navbar-btn" role="button">New User</a>
	</div>
  </div>
</nav>

<!--  show images here -->
</body>
</html>