<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new book</title>
</head>
<style>
h4{
       color: rgb(180,78,200)
}
label{
		color: rgb(100,16,160)
}
</style>

<body>
	
	<h4 align="center"> Enter attributes of new book: </h4>
	<form action="MainServlet" method="post">
	
		<p align="center"><label>Title:<input type="text" name="title" size="20" maxlength="100" >		</label></p>
		<p align="center"><label>Author surname:<input type="text" name="aSurname" size="20" maxlength="100" ></label></p>
		<p align="center"><label>Author name:<input type="text" name="aName" size="20" maxlength="100" >	</label></p>
		<p align="center"><label>Author birthday:<input type="text" name="aBirthday" size="20" maxlength="100" >	</label></p>
		<p align="center"><label>Published year:<input type="text" name="pubYear" size="20" maxlength="100" >	</label></p>
		
		<p align="center"><input type="hidden" name="action" value="add_book"/></p>
		<p align="center"><input type="submit" value="Add"/></p>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="center"><input type="hidden" name="action" value="to_admin_page"/></p>
		<p align="center"><input type="submit" value="to previous page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="center"><input type="hidden" name="action" value="to_first_page"/></p>
		<p align="center"><input type="submit" value="back to main page"/>
	</form>
	
</body>
</html>