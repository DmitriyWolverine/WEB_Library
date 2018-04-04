<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edit book page</title>
	<link a href="css/editor_style.css" type="text/css" rel="stylesheet">
</head>

<body>
	<h1 >Book editor!</h1>
	
	<form action="MainServlet" method="post">
		<label>Title:<input type="text" name="title" size="28" maxlength="100" value="${value}" ></label>

		 <select name="author" >
		 	<option disabled>Choose author</option>
			<c:forEach items="${autList}" var="autItem">
				<option  value="${autItem.getId()}" > ${autItem} </option>
			</c:forEach>
		</select>
		
		Date:<input type="date" name="date" />
		<p align="left"><input type="hidden" name="action" value="update_book"/></p>
		<p align="left"><input type="submit" value="Set"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="show_books_edit"/></p>
		<p align="left"><input type="submit" value="to previous page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_first_page"/></p>
		<p align="left"><input type="submit" value="back to main page"/>
	</form>
	
</body>
</html>