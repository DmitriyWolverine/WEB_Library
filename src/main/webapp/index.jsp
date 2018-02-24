<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Welcome Page</title>
</head>
<style>
h1 {
       color: rgb(255,50,100)
}
</style>
<body>
	<h1 align="center">Hello, User!</h1>
	<form action="MainServlet" method="post">
		<p align="center"><label>Login:<input type="text" name="login" size="28" maxlength="100" >		</label></p>
		<p align="center"><label>Password:<input type="password" name="password" size="25" maxlength="100" ></label></p>
		<p align="center"><input type="hidden" name="action" value="log_in"/></p>
		<p align="center"><input type="submit" value="Log in"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="center"><input type="hidden" name="action" value="registration"/></p>
		<p align="center"><input type="submit" value="Registration"/></p>
	</form>
</body>
</html>