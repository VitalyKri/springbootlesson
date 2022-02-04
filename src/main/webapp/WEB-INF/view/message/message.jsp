<%@ page contentType= "text/html; charset=windows-1251" language="java"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Message</title>
</head>

<body>
<h2>Message from: ${message.from}</h2>
<h2>Message to: ${message.to}</h2>
<h2>Message: ${message.body}</h2>

<c:url var="deleteUrl" value="/message/delete">
    <c:param name="id" value="${message.id}"/>
</c:url>

<a href="${deleteUrl}">DELETE</a>
<br>

<c:url var="editUrl" value="/message/edit">
    <c:param name="id" value="${message.id}"/>
</c:url>

<a href="${editUrl}">EDIT</a>

</body>

</html>