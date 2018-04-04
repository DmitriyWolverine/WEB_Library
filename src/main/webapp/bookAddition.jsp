<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add new book</title>
	<link a href="css/bookAddition_style.css" type="text/css" rel="stylesheet">
</head>

<body>
	
	<h4 > Enter attributes of new book: </h4>
	<form action="MainServlet" method="post">
	
		<p><label>Title:<input type="text" name="title" size="20" maxlength="100" >		</label></p>
		<p><label>Author surname:<input type="text" name="aSurname" size="20" maxlength="100" ></label></p>
		<p><label>Author name:<input type="text" name="aName" size="20" maxlength="100" >	</label></p>
		<p ><label>Author birthday:<input type="text" name="aBirthday" size="20" maxlength="100" pattern="[0-9]{,4}-[0-1]{1}[0-9]{1}-[0-3]{1}[0-9]{1}" title="year-month-day">	</label></p>
		<p ><label>Published year:<input type="text" name="pubYear" size="20" maxlength="100" >	</label></p>
		
		<p ><input type="hidden" name="action" value="add_book"/></p>
		<p><input type="submit" value="Add"/></p>
	</form>
	
	<form action="MainServlet" method="post">
		<p ><input type="hidden" name="action" value="show_books_edit"/></p>
		<p ><input type="submit" value="to previous page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p><input type="hidden" name="action" value="to_first_page"/></p>
		<p ><input type="submit" value="back to main page"/>
	</form>
	
</body>
</html>