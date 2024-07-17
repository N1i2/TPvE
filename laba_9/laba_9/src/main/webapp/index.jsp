<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<a href="task_1">task_1</a>
<a href="Registration.jsp">task_2</a>


<form action="ServletFirst" method="get">
  <input type="submit" value="TASK 6 GET" />
</form>
<form action="ServletFirst" method="post">
  <input type="submit" value="TASK 6 POST" />
</form><br/><br/>

<form action="Servlet1" method="get">
  <input type="text" autocomplete="off" name="name" placeholder="Введите имя" />
  <input type="submit" value="TASK 7" />
</form>
</body>
</html>