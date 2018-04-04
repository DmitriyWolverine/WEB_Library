<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Error Page</title>
	<link a href="css/smthWrong_style.css" type="text/css" rel="stylesheet">
</head>


<body>
 	
	<h3> Ooops, Something has gone wrong... </h3>
	<h3> Maybe one or more fields were not filled! </h3>
	
	<form action="MainServlet" method="post">
		<p><input type="hidden" name="action" value="show_books_edit"/></p>
		<p><input type="submit" value="to books page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p><input type="hidden" name="action" value="to_first_page"/></p>
		<p><input type="submit" value="back to main page"/>
	</form>
	
</body>
