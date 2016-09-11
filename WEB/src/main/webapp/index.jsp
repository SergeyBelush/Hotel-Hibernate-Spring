<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="hotel.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Six Stars</title>
</head>
<body>

<br/>
	<fmt:setLocale value="${sessionScope.locale}" />
	<fmt:setBundle basename="resources.locale" var="loc" />

	<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
	<fmt:message bundle="${loc}" key="locale.change_language.en" var="en" />
	<fmt:message bundle="${loc}" key="locale.index.sign_in" var="sign_in" />
	<fmt:message bundle="${loc}" key="locale.index.create_account" var="create_account" />

<br>

	<fmt:message bundle="${loc}" key="locale.index.login" var="login" />

	<jsp:useBean id="errorMessage" class="java.lang.String" scope="request" />

	<div class="centre">

	<a href="Controller?command=change_language&language=ru">${ru}</a>
	<a href="Controller?command=change_language&language=en">${en}</a>
		<br>

		<h3>Hotel "Luxury"</h3>

		<br>

		<form action="Controller" method="post">
			<input type="hidden" name="command" value="logination"> Login: <br>
			<input type="text" name="login" value=""><br /> Password: <br>
			<input type="password" name="password" value=""> <br>
			<c:out value="${errorMessage}" />

			<br> <button type="submit">${sign_in}</button>
			<br> <br> <button type="submit" formaction="registeraccount.jsp">${create_account}</button>

		</form>
	</div>

</body>
</html>
