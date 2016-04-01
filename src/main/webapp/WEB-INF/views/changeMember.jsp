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
	<form:form method="POST" modelAttribute="memberForm" enctype="multipart/form-data" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>
		<table class="table table-responsive">
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td><label for="userName">Username (login): </label> </td>
				<td><form:input path="userName" id="userName"/></td>
				<td><form:errors path="userName" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td><label for="password">Password: </label> </td>
				<td><form:password path="password" id="password"/>
					<form:input type="hidden" path="previousPassword" id="previousPassword"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
		    </tr>
		    <c:if test="${memberForm.admin}">
			    <tr>
					<td><label for="enabled">Enabled: </label> </td>
					<td><form:select path="enabled" id="enabled" >
						<form:option value="0" >Disabled</form:option>
						<form:option value="1" >Enabled</form:option>
						</form:select>
					</td>
					<td><form:errors path="enabled" cssClass="error"/></td>
			    </tr>
			    <tr>
					<td><label for="role">Role: </label> </td>
					<td><form:select path="role" id="role" >
						<form:option value="ROLE_USER" >USER</form:option>
						<form:option value="ROLE_ADMIN" >ADMIN</form:option>
						</form:select>
					</td>
					<td><form:errors path="role" cssClass="error"/></td>
			    </tr>
			</c:if>
		    <tr>
				<td><label for="rollNumber">Roll No.: </label> </td>
				<td><form:input path="rollNumber" id="rollNumber"/></td>
				<td><form:errors path="rollNumber" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td><label for="batchYear">Batch Year: </label> </td>
				<td><form:input path="batchYear" id="batchYear"/></td>
				<td><form:errors path="batchYear" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td><label for="contactEmail">Contact Email: </label> </td>
				<td><form:input path="contactEmail" id="contactEmail"/></td>
				<td><form:errors path="contactEmail" cssClass="error"/></td>
		    </tr>
		    <tr><td><label for="location">Location: </label>
		    	</td><td><form:input path="location" id="location"/></td>
				<td><form:errors path="location" cssClass="error"/></td></tr>
		    <tr><td><label for="photo">Profile Picture: </label>
		    	</td>
		    	<td><img src="<c:url value='/image/${memberForm.id }' />" 
		    		width="300" alt="profile photo"/>
		    	</td>
		    	<td>
		    		<label class="col-xs-2 control-lable" for=file>Upload profile picture</label>
                    <div class="col-xs-4">
                        <form:input type="file" path="file" id="file" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="file" class="help-inline"/>
                        </div>
                    </div>
                </td></tr>
            <tr><td><label for="aboutYou">About you: </label>
		    	</td><td><form:input path="aboutYou" id="aboutYou"/></td>
				<td><form:errors path="aboutYou" cssClass="error"/></td></tr>
			<tr><td><label for="profession">Profession: </label>
		    	</td><td><form:input path="profession" id="profession"/></td>
				<td><form:errors path="profession" cssClass="error"/></td></tr>
			<tr><td><label for="hobby">Hobby: </label>
		    	</td><td><form:input path="hobby" id="hobby"/></td>
				<td><form:errors path="hobby" cssClass="error"/></td></tr>
            <tr><td><label for="displayContact">Display Contact</label></td>
            		<td><form:select path="displayContact" id="displayContact" >
						<form:option value="0" >No</form:option>
						<form:option value="1" >Yes</form:option>
						</form:select>
					</td>
					<td><form:errors path="displayContact" cssClass="error"/></td>
		    <tr><td><label for="contactAddress">Contact Address: </label>
		    	</td><td><form:input path="contactAddress" id="contactAddress"/></td>
				<td><form:errors path="contactAddress" cssClass="error"/></td></tr>
		    <tr><td><label for="contactNumber">Contact Phone: </label>
		    	</td><td><form:input path="contactNumber" id="contactNumber"/></td>
				<td><form:errors path="contactNumber" cssClass="error"/></td></tr>
		    <tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Submit"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>