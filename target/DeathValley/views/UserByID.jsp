<%--
  Created by IntelliJ IDEA.
  User: serg
  Date: 09.04.2018
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You were looking for</title>
    <head>You were looking : </head>
    <%String name = (String)request.getAttribute("name"); %>
    <%= name%>
    <%String sureName = (String)request.getAttribute("sureName"); %>
    <%= sureName%>

</head>
<body>

</body>
</html>
