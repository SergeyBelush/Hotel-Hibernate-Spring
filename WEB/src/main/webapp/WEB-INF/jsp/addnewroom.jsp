<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="hotel.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
</head>

<body>
Add New Room
<p/>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="add_new_room" /> 
		Type: <br />
		<input type="text" name="type" value="" /><br />
		Price A Day: <br />
		<input type="text" name="price_a_day" value="" /> <br /> 
		Room Number: <br />
		<input type="text" name="room_number" value="" /> <br /> 
		
		<br /> <c:out value="${errorMessage}" />
		
		<br />
		
		<input type="submit" name="add" value="Add" />
				
		<br />		
		
	</form>
</body>
</html>