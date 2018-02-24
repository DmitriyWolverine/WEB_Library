<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logged-in Page</title>
</head>
<style>
body {
       color: rgb(0,200,0)
}
</style>

<body>
	<h1 align="center"><c:out  value="Hello from user page"/></h1>
	
	<form action="MainServlet" method="post">
			<p align="center"><input type="hidden" name="action" value="show_books"/></p>
			<p align="center"><input type="submit" value="Show books"/></p>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="center"><input type="hidden" name="action" value="to_first_page"/></p>
		<p align="center"><input type="submit" value="back to main page"/>
	</form>
</body>
</html>