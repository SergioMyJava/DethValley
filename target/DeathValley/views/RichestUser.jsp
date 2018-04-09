<%--
  Created by IntelliJ IDEA.
  User: serg
  Date: 09.04.2018
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<head>Most rich man </head>
    <%String name = (String)request.getAttribute("name"); %>
    <%= name%>
    <%String sureName = (String)request.getAttribute("sureName"); %>
    <%= sureName%>
</head>
<body>

</body>
</html>
