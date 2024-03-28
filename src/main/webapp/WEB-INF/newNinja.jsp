<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<div>
		<form:form action="/ninjas/create" method="POST" modelAttribute="ninja">
			<form:label path="dojo">Dojo: </form:label>
			<form:select path="dojo">
	        <c:forEach var="dojoOne" items="${dojos}">
	            <form:option value="${dojoOne.id}" path="dojo">
	                <c:out value="${dojoOne.name}"/>
	            </form:option>
	        </c:forEach>
	    	</form:select>
			
			<form:label path="firstName">First Name: </form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"></form:input>
			
			<form:label path="lastName">Last Name: </form:label>
			<form:errors path="lastName"></form:errors>
			<form:input path="lastName"></form:input>
			
			<form:label path="age">Age: </form:label>
			<form:errors path="age"></form:errors>
			<form:input type="number" path="age"></form:input>
			<input type="submit" value="Create" />
		</form:form>
	</div>
	<c:forEach var="dojo" items="${dojos}">
		<p>Students in: <a href="/dojo/${dojo.id}"><c:out value="${dojo.name}"></c:out></a></p>
	</c:forEach>
		
</body>
</html>