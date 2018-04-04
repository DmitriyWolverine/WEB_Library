<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Admin page</title>
	<link a href="css/adminPage_style.css" type="text/css" rel="stylesheet">
</head>

<body>	
	<h1 align="center"><c:out  value="Hello,  ${login}, from admin page"/></h1>
	
	<c:forEach items="${list}" var="item">
		<p><h5><c:out value="${item}"/></h5>
			<c:choose>
				<c:when test="${current_book_id == item.getId()}">
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
		<input type="submit" value="Find book"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="show_books_edit"/></p>
		<p align="left"><input type="submit" value="Show all books"/></p>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_first_page"/></p>
		<p align="left"><input type="submit" value="back to main page"/>
	</form>
	
	
</body>
</html>