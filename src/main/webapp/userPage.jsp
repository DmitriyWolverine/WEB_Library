<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Logged-in Page</title>
	<link a href="css/userPage_style.css" type="text/css" rel="stylesheet">
</head>

<body>
	<h1 ><c:out  value="Hello, ${login}, from user page"/></h1>
	<h2 ><c:out  value="Your book card:"/></h1>
	
	
	<c:forEach items="${list}" var="item">
		<p><h5><c:out value="${item}"/></h5>
			<c:choose>
				<c:when test="${!item.isAvailable()}">
					<form action="MainServlet" method="post">
						<input type="hidden" name="action" value="return_book"/>
						<input type="hidden" name="bookid" value="${item.getId()}"/>
						<input type="submit" value="return book"/>
					</form>
				</c:when>
			</c:choose>
	</c:forEach> 
	
	
	<form action="MainServlet" method="post">
		<label>Title:<input type="text" name="title" size="28" maxlength="100" ></label>
		<label>Author:<input type="text" name="author" size="28" maxlength="100" ></label>
		Date:<input type="date" name="date" />
		<input type="hidden" name="action" value="find_books"/>
		<input type="submit" value="Find"/>
	</form>
	
		
	<form action="MainServlet" method="post">
			<p ><input type="hidden" name="action" value="show_books"/></p>
			<p ><input type="submit" value="Show all books"/></p>
	</form>
	
	<form action="MainServlet" method="post">
		<p><input type="hidden" name="action" value="to_first_page"/></p>
		<p ><input type="submit" value="back to main page"/>
	</form>
</body>
</html>