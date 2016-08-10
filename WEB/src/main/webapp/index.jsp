<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Six Stars</title>
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

	<fmt:message bundle="${loc}" key="locale.index.login" var="login" />

	<jsp:useBean id="errorMessage" class="java.lang.String" scope="request" />


	<div
		style="margin: 1em; padding: 1em; border: 1px solid black; background-color: pink;">
		<h3>Hotel "Six Stars"</h3>

		<br />

		<form action="Controller" method="post">
			<input type="hidden" name="command" value="logination" /> Login: <br />
			<input type="text" name="login" value="" /><br /> Password: <br />
			<input type="password" name="password" value="" /> <br />
			<c:out value="${errorMessage}" />

			<br /> <input type="submit" name="sing in" value="Sign in" /> <a
				href="registeraccount.jsp" style="margin-left: 1em; color: black;">
				Create Account </a>

		</form>
	</div>

</body>
</html>
