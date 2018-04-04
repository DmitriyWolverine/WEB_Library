<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome Page</title>
	<link a href="css/index_style.css" type="text/css" rel="stylesheet">
</head>

	<div id="first">
		<h1 >Welcome to our library! </h1>
		<form action="MainServlet" method="post">
			<p><label>Login:<input type="text" name="login" size="28" maxlength="100" >		</label></p>
			<p><label>Password:<input type="password" name="password" size="25" maxlength="100" ></label></p>
			<p><input type="hidden" name="action" value="log_in"/></p>
			<p ><input type="submit" value="Log in"/>
		</form>
		
		<form action="MainServlet" method="post">
			<p ><input type="hidden" name="action" value="registration"/></p>
			<p ><input type="submit" value="Registration"/></p>
		</form>
	</div>
</body>
</html>