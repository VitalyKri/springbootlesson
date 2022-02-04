<%@ page contentType= "text/html; charset=windows-1251" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create message</title>
</head>

<body>
<form:form action="create" modelAttribute="message">
    <form:hidden path="id" value="${message.id}"/>
    From: <form:input path="from"/>
    <br>
    To: <form:input path="to"/>
    <br>
    Message: <form:textarea path="body"/>
    <br>
    <input type="submit" value="Save"/>
</form:form>

</body>

</html>