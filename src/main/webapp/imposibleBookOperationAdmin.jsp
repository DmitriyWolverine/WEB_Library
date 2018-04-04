<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Impossible Action</title>
<link a href="css/smthWrong_style.css" type="text/css" rel="stylesheet">
</head>


<body>
 	
	<h3> This action could'n be applied to this book </h3>

	<form action="MainServlet" method="post">
		<p><input type="hidden" name="action" value="to_admin_page"/></p>
		<p><input type="submit" value="to admin page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p><input type="hidden" name="action" value="to_first_page"/></p>
		<p><input type="submit" value="back to main page"/>
	</form>
	
</body>
