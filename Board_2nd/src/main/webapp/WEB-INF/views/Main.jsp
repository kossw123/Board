<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Board</title>
</head>

<body>

<form action="">
	<input type='BUTTON' value='글쓰기' onclick="location.href='Write.page';">
	<input type='BUTTON' value='글목록' onclick="location.href='Index.page';">    
</form>


</body> 
</html>
