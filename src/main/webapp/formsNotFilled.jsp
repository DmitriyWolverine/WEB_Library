<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>

<style>
body {
       color: rgb(128,0,255)
}
</style>

<body>
 	
	<p align="left"><h3> Ooops, Something has gone wrong... </h3>
	<p align="left"><h3> One or more fields are empty. Fill them and try again!</h3>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="show_books_edit"/></p>
		<p align="left"><input type="submit" value="to previous page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_first_page"/></p>
		<p align="left"><input type="submit" value="back to main page"/>
	</form>
	
</body>
