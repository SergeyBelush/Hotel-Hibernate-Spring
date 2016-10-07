<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>
<head>

	<link href="<c:url value="/resources/css/hotel.css" />" rel="stylesheet">

	<%--<link type="text/css" rel="stylesheet" href="hotel.css">--%>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Six Stars</title>
</head>
<body>


<h3>Hello World!!!</h3>
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

		<h1>Hotel "Luxury"</h1>

		<br>

<%--		<form:form action="signIn" method="post" modelAttribute="user">
			<form:input path="login"/>
			<form:input path="password"/>
		</form:form>--%>


	<%--<form:form method="get" action="/HelloUser/redirect">

		<input type="submit" value="Redirect Page"/>--%>

		<%--<input type="submit" value="Submit"/>--%>
	<%--<form:form>--%>

		<form:form method="post" action="checkuser" modelAttribute="user">

			<br><form:label path="login">Login:</form:label><br>
			<br><form:input type="text" path="login"/><br>

			<br><form:label path="pass">Password:</form:label><br>
			<br><form:input type="text" path="pass"/><br>


			<br><input type="submit" value="Submit"/><br>


			<<%--input type="hidden" name="command" value="login"> Login: <br>
			<input type="text" name="login" value=""><br /> Password: <br>
			<input type="password" name="password" value=""> <br>
--%>
<%--			<c:out value="${errorMessage}" />
			<br> <button value="login" type="submit">${sign_in}</button>
			<br> <br> <button type="submit" formaction="registeraccount.jsp">${create_account}</button>--%>

		</form:form>
	</div>

</body>
</html>

<%--sign_in--%>
<%--<form action="Controller" method="post">--%>