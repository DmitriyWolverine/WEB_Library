<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration completed</title>
<link a href="css/successfulReg_style.css" type="text/css" rel="stylesheet">
</head>

<body>
	<h2>Registration completed, ${login}</h2>
	
	<form action="MainServlet" method="post">
		<p><input type="hidden" name="action" value="to_first_page"/></p>
		<p><input type="submit" value="back to main page"/>
	</form>
	
</body>
</html>