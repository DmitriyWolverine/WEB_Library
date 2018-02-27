<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Such book exists</title>
<style>

body {
       color: rgb(255,0,0)
}
</style>
<body>
	<h1 align="left"><c:out  value="${title} has already been added before."/></h1>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_admin_page"/></p>
		<p align="left"><input type="submit" value="to admin page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_first_page"/></p>
		<p align="left"><input type="submit" value="back to main page"/>
	</form>

</body>
</html>