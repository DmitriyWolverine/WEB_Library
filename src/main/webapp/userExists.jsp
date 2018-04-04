<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration error</title>
<link a href="css/smthWrong_style.css" type="text/css" rel="stylesheet">
</head>

<body>
	<h3><c:out  value="Login ${login} does exist..."/></h3>
	<h3><c:out  value="Try another login"/></h3>
	
	<form action="MainServlet" method="post">
		<p ><input type="hidden" name="action" value="registration"/></p>
		<p ><input type="submit" value="to registration page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p ><input type="hidden" name="action" value="to_first_page"/></p>
		<p ><input type="submit" value="back to main page"/>
	</form>
	
	
</body>
</html>
