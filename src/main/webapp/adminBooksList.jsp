<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Admins books list</title>
	<link a href="css/adminBooksList_style.css" type="text/css" rel="stylesheet">
</head>

<body>
<h3>Admins books:</h3>
<h3>${message}</h3>

	<c:forEach items="${list}" var="item">
	<div id="book">
		<c:out value="${item}"/>
		<form action="MainServlet" method="post">
			<input type="hidden" name="action" value="edit_book"/>
			<input type="hidden" name="bookid" value="${item.getId()}"/>
			<input type="submit" value="EDIT"/>
		</form>
		
		<form action="MainServlet" method="post">
			<input type="hidden" name="action" value="delete_book"/>
			<input type="hidden" name="bookid" value="${item.getId()}"/>
			<input type="submit" value="DELETE"/>
		</form>
		
		<form action="MainServlet" method="post">
			<input type="hidden" name="action" value="take_book"/>
			<input type="hidden" name="bookid" value="${item.getId()}"/>
			<input type="submit" value="TAKE BOOK"/>
		</form>
	</div>
	</c:forEach> 

	<div id="field">
	<form action="MainServlet" method="post">
		<label>Title:<input type="text" name="title" size="28" maxlength="100" ></label>
		 
		<select name="author" >
			<option disabled>Choose author</option>
			<c:forEach items="${autList}" var="autItem">
					<option  value="${autItem.getId()}" > ${autItem} </option>
			</c:forEach>
		</select>
	
		Date:<input type="date" name="date" />
		<input type="hidden" name="action" value="add_book_select"/>
		<input type="submit" value="Add this book"/>
	</form>
	</div>	
	<form action="MainServlet" method="post">
		<p ><input type="hidden" name="action" value="add_new_book"/></p>
		<p ><input type="submit" value="Add new book"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p ><input type="hidden" name="action" value="to_admin_page"/></p>
		<p ><input type="submit" value="to previous page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p><input type="hidden" name="action" value="to_first_page"/></p>
		<p ><input type="submit" value="back to main page"/>
	</form>

</body>
</html>