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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up Form</title>
<style>

	.error {
		color: #ff0000;
	}
</style>
<jsp:directive.include file="menu.jsp" />
</head>
<body>
	message : ${success}
		<table class="table table-responsive">
			<tr>
				<td><label for="name">Name: </label> </td>
				<td>${memberForm.name }</td>
				<td></td>
		    </tr>
		    <tr>
				<td><label for="userName">Username (login): </label> </td>
				<td>${memberForm.userName }</td>
				<td></td>
		    </tr>
		    <tr>
				<td><label for="password">Password: </label> </td>
				<td>${memberForm.password }
					</td>
				<td></td>
		    </tr>
		    <tr>
				<td><label for="rollNumber">Roll No.: </label> </td>
				<td>${memberForm.rollNumber }</td>
				<td></td>
		    </tr>
		    <tr>
				<td><label for="batchYear">Batch Year: </label> </td>
				<td>${memberForm.batchYear }</td>
				<td></td>
		    </tr>
		    <tr>
				<td><label for="contactEmail">Contact Email: </label> </td>
				<td>${memberForm.contactEmail }</td>
				<td></td>
		    </tr>
		    <tr><td><label for="location">Location: </label>
		    	</td><td>${memberForm.location }</td>
				<td></td></tr>
		    <tr><td><label for="photo">Profile Picture: </label>
		    	</td>
		    	<td><img src="<c:url value='/image/${memberForm.id }' />" 
		    		width="300" alt="profile photo"/>
		    	</td>
		    	<td>
                </td></tr>
            <tr><td><label for="aboutYou">About you: </label>
		    	</td><td>${memberForm.aboutYou }</td>
				<td></td></tr>
			<tr><td><label for="profession">Profession: </label>
		    	</td><td>${memberForm.profession }</td>
				<td></td></tr>
			<tr><td><label for="hobby">Hobby: </label>
		    	</td><td>${memberForm.hobby }</td>
				<td></td></tr>
		    <c:if test="${memberForm.displayContact}">
		    <tr><td><label for="contactAddress">Contact Address: </label>
		    	</td><td>${memberForm.contactAddress }</td>
				<td></td></tr>
		    <tr><td><label for="contactNumber">Contact Phone: </label>
		    	</td><td>${memberForm.contactNumber }</td>
				<td></td></tr>
			</c:if>
		</table>
</body>
</html>