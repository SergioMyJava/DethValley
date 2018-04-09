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


<br>
<%    ArrayList<User> list = (ArrayList<User>) request.getAttribute("users");
    for(User user : list) {

        out.println(user.getName());
        out.println(user.getSureName());}%>
</br>


</head>
<body>

</body>
</html>
