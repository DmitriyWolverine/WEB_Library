<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>


<body>
	Hello, User!
	<form action="MainServlet" method=post>
		<input type="hidden" name=action value="test1"/>
		<input type="submit" value="test jsp1"/>
	</form>
	
	<form action="MainServlet" method=post>
		<input type="hidden" name=action value="test2"/>
		<input type="submit" value="test jsp2"/>
	</form>
	
</body>
</html>