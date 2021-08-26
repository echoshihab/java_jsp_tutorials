<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: echos
  Date: 2021-08-25
  Time: 8:54 p.m.
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration From</title>
</head>
<body>
<h1>Register</h1>

<form method="post" action="/register">
  <label for="email">Email:</label>
  <input type="email" id="email" name="email">

  <label for="password1">Password:</label>
  <input type="password" id="password1" name="password1">

  <label for="password2"> Confirm Password:</label>
  <input type="password" id="password2" name="password2">

  <button type="submit" name="submit">Submit</button>
<% HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors != null){
      String err = request.getAttribute("errors").toString();
    }
%>
  <ul>
  <%
  for (String key: errors.keySet())
    { %>
      <li><%=errors.get(key)%></li>
   <% }%>
  </ul>
</form>

</body>
</html>
