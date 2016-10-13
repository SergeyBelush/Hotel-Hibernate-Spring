<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			Add New Room
	<br/>

<form:form method="post" action="addroom" modelAttribute="addnewroom">

	<br><form:label path="type">Type:</form:label><br>
	<br><form:input type="text" path="type"/><br>

	<br><form:label path="number">Number:</form:label><br>
	<br><form:input type="text" path="number"/><br>

	<br><form:label path="price">Price:</form:label><br>
	<br><form:input type="text" path="price"/><br>

	<br><input type="Submit" value="Add New Room"/><br>

</form:form>

</div>

</body>
</html>