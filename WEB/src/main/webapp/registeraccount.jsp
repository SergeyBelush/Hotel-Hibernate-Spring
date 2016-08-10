<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register Account</title>
</head>
<body>

<div style="margin:1em; padding:1em; border:1px solid black; background-color:pink;">
	<h3>Register New Account</h3>
	<form action="Controller" method="post" >
		<input type="hidden" name="command" value="registration" /> 
		Name: <br />
		<input type="text" name="name" value="" /><br /> 
		Surname: <br />
		<input type="text" name="surname" value="" /><br /> 
		Login: <br />
		<input type="text" name="login" value="" /><br /> 
		Password: <br />
		<input type="password" name="password" value="" /><br /> 
		Repeat Password: <br />
		<input type="password" name="repeat-password" value="" /><br /> 
		E-mail: <br />
		<input type="text" name="e-mail" value="" />
		
		<br /> <c:out value="${errorMessage}" />

		<input type="submit" name="register" value="Create Account"/>
	
	</form>
	</div>

</body>
</html>