<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link a href="css/registration_style.css" type="text/css" rel="stylesheet">
</head>

<body>
		<h2 >Registration</h2>
		<form action="MainServlet" method="post">
			<p><label>Login:<input type="text" name="login" size="28" maxlength="100" >		</label></p>
			<p ><label>Password:<input type="password" name="password" size="25" maxlength="100" ></label> </p>
			<h5 >Password should not shorter than 6 symbols</h5>
			<p><input type="hidden" name="action" value="registrate"/></p>
			<p ><input type="submit" value="Registrate"/></p>
		</form>
		
		<form action="MainServlet" method="post">
			<p ><input type="hidden" name="action" value="to_first_page"/></p>
			<p><input type="submit" value="back to main page"/>
		</form>
</body>
</html>
