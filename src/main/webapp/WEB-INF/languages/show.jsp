<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
</head>
	<body>
		<a href="/languages">Dashboard</a>
		<h2><c:out value="${language.name}"/></h2>
		<h2><c:out value="${language.creator}"/></h2>
		<h2><c:out value="${language.version}"/></h2>
	</body>
	
	<form action="/languages/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
	
	<a href="/languages/edit/${language.id}">edit</a>

</html>