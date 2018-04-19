<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.User" %>
<%@ page import="static sun.misc.MessageUtils.out" %><%--
  Created by IntelliJ IDEA.
  User: serg
  Date: 09.04.2018
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<br>
    <title>Our database of users</title>
</br>
<head>
<br>
<%    ArrayList<User> list = (ArrayList<User>) request.getAttribute("users");
    for(User user : list) {
%>
    <br>
        <tr>
        <td><%out.println(user.getName());%></td>
        <td><%out.println(user.getSureName());}%></td>
        </tr>
    </br>
</br>


</head>
<body>

</body>
</html>
