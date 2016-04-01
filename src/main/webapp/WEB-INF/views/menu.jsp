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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:directive.include file="common.jsp" />
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="<c:url value='/' />">
      	IMIT-Alumni Application
      	<span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li class="active"><a href="<c:url 
      		value='/member-batch-year-list' />">
      		Search <span class="sr-only">(current)</span></a></li>
        <li><a href="<c:url value='/edit' />">
        	Edit Profile <span class="sr-only"></span></a></li>
        <li><a href="<c:url value='/admin' />">Admin <span class="sr-only"></span></a></li>
      </ul>
    </div>
  </div>
</nav> 
	<c:url value="/logout" var="logoutUrl" />

		<!-- csrt support -->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" 
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<div class="panel panel-primary">
					Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</div>


				
	</c:if>
</body>
</html>