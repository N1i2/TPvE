<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("username") %></h1>
    <h2>Role: <%= session.getAttribute("role") %></h2>
    <h2>Current Date: <%= new Date() %></h2></br>
    <a href="ServletCookie">Получить cookie</a></br></br>
    <a href="index.jsp">Back on task page</a></br></br>
</body>
</html>
