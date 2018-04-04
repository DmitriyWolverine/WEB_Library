<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Our books</title>
	<link a href="css/userBooksList_style.css" type="text/css" rel="stylesheet">
</head>

<body>
	<h3 align="left">Books:</h3>
	
	<h3 align="left">${message}</h3>
	
	<c:forEach items="${list}" var="item">
		<h5><c:out value="${item}"/></h5>
		<form action="MainServlet" method="post">
			<input type="hidden" name="action" value="take_book"/>
			<input type="hidden" name="bookid" value="${item.getId()}"/>
			<input type="submit" value="take book"/>
		</form>
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