<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/main.css">
<title>Dojo with Students</title>
</head>
<body>
	<h1><c:out value="${dojo.name}"></c:out> Location Ninjas</h1>
	<table>
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="ninja" items="${ninjas}">
		<tr>
			<td><c:out value="${ninja.firstName}"></c:out></td>
			<td><c:out value="${ninja.lastName}"></c:out></td>
			<td><c:out value="${ninja.age}"></c:out></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<a href="/ninjas/new"><button>Go Back</button></a>
</body>
</html>