<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<br/>
	<fmt:setLocale value="${sessionScope.locale}" />
	<fmt:setBundle basename="resources.locale" var="loc" />

	<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
	<fmt:message bundle="${loc}" key="locale.change_language.en" var="en" />

	<a href="Controller?command=change_language&language=ru">${ru}</a>
	<a href="Controller?command=change_language&language=en">${en}</a>
	
<br/>
<br/>
	<table border="1" style="padding:0.5em">
		<tr>
		<td> Number </td>
		<td> Type </td>
		<td> Price </td>
		</tr>
		<c:forEach var="room" items="${requestScope.free_rooms}">
			<tr>
				<td><c:out value="${room.number}" /></td>
				<td><c:out value="${room.type}" /></td>
				<td><c:out value="${room.price}" /></td>
			</tr>
		</c:forEach>
	</table>
<br/>
	
	<form action="Controller" method="post" > 
	<input type="hidden" name="command" value="reserve" /> 
		Enter Number Room <br />
		<input type="text" name="numbers" value="" />
		
<br /> 
	<br /> <c:out value="${errorMessage}" />

		<input type="submit" name="res" value="Reserve"/>
	</form>

</body>
</html>