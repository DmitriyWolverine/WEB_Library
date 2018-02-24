<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<style>
h2 {
       color: rgb(55,50,200)
}
label {
       color: rgb(55,50,200)
}
</style>

<body>
		<h2 align="center">Registration</h2>
		<form action="MainServlet" method="post">
			<p align="center"><label>Login:<input type="text" name="login" size="28" maxlength="100" >		</label></p>
			<p align="center"><label>Password:<input type="password" name="password" size="25" maxlength="100" ></label></p>
			<p align="center"><input type="hidden" name="action" value="registrate"/></p>
			<p align="center"><input type="submit" value="Registrate"/></p>
		</form>
		
		<form action="MainServlet" method="post">
			<p align="center"><input type="hidden" name="action" value="to_first_page"/></p>
			<p align="center"><input type="submit" value="back to main page"/>
		</form>
</body>
</html>
