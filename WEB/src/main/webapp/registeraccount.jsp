<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="hotel.js"></script>
	<link type="text/css" rel="stylesheet" href="hotel.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Register Account</title>
</head>
<body>



<div class="centre">
	<h3>Register New Account</h3>
	<form id="index-form" action="Controller" method="post" >
		<input type="hidden" name="command" value="registration" /> 
		Name: <br />
		<input id="index-name" type="text" name="name" value="" /><br />
		Surname: <br />
		<input id="index-surname" type="text" name="surname" value="" /><br />
		Login: <br />
		<input type="text" name="login" value="" /><br />
		Password: <br />
		<input type="password" name="password" value="" /><br /> 
		Repeat Password: <br />
		<input type="password" name="repeat-password" value="" /><br /> 
		E-mail: <br />
		<input id="index-email" type="text" name="e-mail" value="" />
		
		<br /> <c:out value="${errorMessage}"/>
		<p id="oshibka"></p>

		<button onclick="proverkaBrouzer()" type="button">Create Account</button>
	
	</form>
	</div>

</body>
</html>