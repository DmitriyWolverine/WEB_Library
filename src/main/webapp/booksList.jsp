<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Our books</title>
</head>
<style>
body {
       color: rgb(50,60,0)
}
h5 {
       color: rgb(50,60,0)
}
</style>
<body>
	<h2 align="left">Our books:</h2>
	
	<c:forEach items="${list}" var="item">
		<p><h5><c:out value="${item}"/></h5>
	</c:forEach> 
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_user_page"/></p>
		<p align="left"><input type="submit" value="to previous page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_first_page"/></p>
		<p align="left"><input type="submit" value="back to main page"/>
	</form>
	
</body>
</html>