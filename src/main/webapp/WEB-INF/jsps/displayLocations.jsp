<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<h2>Locations:</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>NAME</th>
			<th>TYPE</th>
		</tr>

		<c:forEach items="${locations}" var="location">  <!--To use core tag libraries 1)add jstl dependency 2)add Core Tag lib,page-->
		<tr>
			<td>${location.id}</td>
			<td>${location.code}</td>
			<td>${location.name}</td>
			<td>${location.type}</td>
			<td><a href="deletelocation?id=${location.id}">delete</a></td>
			
			<td><a href="showupdate?id=${location.id}">edit</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<br/>
	<a href="showcreate">Add Location</a>



</body>
</html>