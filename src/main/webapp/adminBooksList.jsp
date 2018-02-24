<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admins books list</title>
</head>

<style>
h5 {
       color: rgb(50,60,120)
}
</style>

<body>
<h3 align="left">Admins books:</h3>

	<c:forEach items="${list}" var="item">
		<p><h5><c:out value="${item}"/></h5>
		
		<form action="MainServlet" method="post">
			<input type="hidden" name="action" value="delete_book"/>
			<input type="hidden" name="bookid" value="${item.getId()}"/>
			<input type="submit" value="DELETE"/>
		</form>
		
		<form action="MainServlet" method="post">
			<input type="hidden" name="action" value="edit_book"/>
			<input type="hidden" name="bookid" value="${item.getId()}"/>
			<input type="submit" value="EDIT"/>
		</form>
	
	</c:forEach> 
	<br>
	<form action="MainServlet" method="post">
		<label>Title:<input type="text" name="title" size="28" maxlength="100" ></label>
		 
		<select name="author" >
			<option disabled>Choose author</option>
			<c:forEach items="${autList}" var="autItem">
					<option  value="${autItem.getId()}" > ${autItem} </option>
			</c:forEach>
		</select>
	
		Date:<input type="date" name="date" />
		<p align="left"><input type="hidden" name="action" value="add_book_select"/></p>
		<p align="left"><input type="submit" value="Add new book"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_admin_page"/></p>
		<p align="left"><input type="submit" value="to previous page"/>
	</form>
	
	<form action="MainServlet" method="post">
		<p align="left"><input type="hidden" name="action" value="to_first_page"/></p>
		<p align="left"><input type="submit" value="back to main page"/>
	</form>

</body>
</html>