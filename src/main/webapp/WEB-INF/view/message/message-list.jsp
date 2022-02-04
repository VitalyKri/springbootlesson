<%@ page contentType= "text/html; charset=windows-1251" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Message list</title>
</head>

<body>
<h1>Message list</h1>
<url>
  <c:forEach var="message" items="${messages}">
      <c:url var="viewUrl" value="/message/ +${message.id}"/>
      <li>
        <a href="${viewUrl}">View</a>
        <br>
        Message from: ${message.from}
        <br>
        Message to: ${message.to}
        <br>
        Message: ${message.body}
        <br>
      </li>
  </c:forEach>

</url>
<br>
<c:url var="createUrl" value="/message/create"/>

<a href="${createUrl}">CREATE</a>

</body>

</html>