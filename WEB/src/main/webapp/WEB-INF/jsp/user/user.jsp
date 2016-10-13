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

	<style>
		body {
			color: white;
			font-family: sans-serif;
			background: radial-gradient(hsl(0, 100%, 27%) 4%, hsl(0, 100%, 18%) 9%, hsla(0, 100%, 20%, 0) 9%) 0 0,
			radial-gradient(hsl(0, 100%, 27%) 4%, hsl(0, 100%, 18%) 8%, hsla(0, 100%, 20%, 0) 10%) 50px 50px,
			radial-gradient(hsla(0, 100%, 30%, 0.8) 20%, hsla(0, 100%, 20%, 0)) 50px 0,
			radial-gradient(hsla(0, 100%, 30%, 0.8) 20%, hsla(0, 100%, 20%, 0)) 0 50px,
			radial-gradient(hsla(0, 100%, 20%, 1) 35%, hsla(0, 100%, 20%, 0) 60%) 50px 0,
			radial-gradient(hsla(0, 100%, 20%, 1) 35%, hsla(0, 100%, 20%, 0) 60%) 100px 50px,
			radial-gradient(hsla(0, 100%, 15%, 0.7), hsla(0, 100%, 20%, 0)) 0 0,
			radial-gradient(hsla(0, 100%, 15%, 0.7), hsla(0, 100%, 20%, 0)) 50px 50px,
			linear-gradient(45deg, hsla(0, 100%, 20%, 0) 49%, hsla(0, 100%, 0%, 1) 50%, hsla(0, 100%, 20%, 0) 70%) 0 0,
			linear-gradient(-45deg, hsla(0, 100%, 20%, 0) 49%, hsla(0, 100%, 0%, 1) 50%, hsla(0, 100%, 20%, 0) 70%) 0 0;
			background-color: #300;
			background-size: 100px 100px;
		}

		.centre{
			margin: auto;
			width: 20%;
		}

		a {
			color: white;
		}

		button {
			background-color: indigo;
			color: aliceblue;
			border: 2px solid;
			border-radius: 15px;
			padding: 0.5em 1em 0.5em 1em;
			font-size: medium;
		}

		#oshibka {
			margin-top: 10px;
			margin-bottom: 10px;
			color: pink;
			font-weight: bold;
		}

	</style>

</head>
<body>

	<div class="centre">

		<br/>
			<h2>Hello ${user.name} ${user.surname}</h2>
		<br/>


	<form method="post" action="freerooms">
		<c:out value="${errorRoomMessage}"/>
		<br><input type="submit" value="Show Free Rooms"/><br>
	</form>

	<c:if test="${user.admin}">
		<form method="post" action="addnewroom">
			<br><input type="submit" value="Add New Room"/><br>
		</form>
	</c:if>


		<br/>
		<h2>Your Orders</h2>
		<br/>
		<table border="1" style="padding:0.5em">
			<tr>
				<td> Number </td>
				<td> Type </td>
				<td> Price </td>
				<td> Check In </td>
				<td> Check Out </td>
			</tr>
			<c:forEach var="order" items="${orders}">
				<tr>
					<td><c:out value="${order.room.number}" /></td>
					<td><c:out value="${order.room.type}" /></td>
					<td><c:out value="${order.room.price}" /></td>
					<td><c:out value="${order.dateIn}" /></td>
					<td><c:out value="${order.dateOut}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br/>


	</div>

</body>
</html>