<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="hotel.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
</head>
<body>

	<h2>Hello User</h2>

<%--<br/>
 	<fmt:setLocale value="${sessionScope.locale}" />
	<fmt:setBundle basename="resources.locale" var="loc" />

	<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
	<fmt:message bundle="${loc}" key="locale.change_language.en" var="en" />

	<div class="centre">

	<a href="Controller?command=change_language&language=ru">${ru}</a>
	<a href="Controller?command=change_language&language=en">${en}</a>
<br/>

<br/>
	<p>Hello!!!</p>
	
	<h1>
		<%
			by.htp3.hotel.bean.User user = (by.htp3.hotel.bean.User) request.getAttribute("user");
			out.println(user.getName());
		%>
	</h1>
	
	<h2>
		<%
			out.println(user.getSurname());
		%>
	</h2>
	
	<br/>
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="show_free_rooms" /> 
		 <input type="submit" name="sign in" value="Show Free Rooms" />
	</form>
	
	<br/>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="add_new_room_form" />
		 <button type="submit" name="sign in">Add New Room</button>
	</form>

	</div>--%>
</body>
</html>