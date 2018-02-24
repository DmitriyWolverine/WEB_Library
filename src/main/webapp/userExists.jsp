<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration error</title>
</head>
<style>
h3 {
       color: rgb(128,200,255)
}
</style>

<body>
	<h3><c:out  value="Login ${login} does exist..."/></h3>
	<h3><c:out  value="Try another login"/></h3>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="registration"/></p>
		<p align="left"><input type="submit" value="to previous page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_first_page"/></p>
		<p align="left"><input type="submit" value="back to main page"/>
	</form>
	
	
</body>
</html>
