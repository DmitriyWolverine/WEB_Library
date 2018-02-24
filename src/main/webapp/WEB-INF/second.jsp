<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Second Page</title>
</head>


<body>
	Hello, User from second page!
	
	<p><h1><c:out value="${user_name}"/></h1>
	<c:forEach items="${list}" var="item">
		<p><h2><c:out value="${item}"/></h2>
	</c:forEach> 
	
</body>
</html>