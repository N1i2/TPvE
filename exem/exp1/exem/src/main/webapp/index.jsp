<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Exam</title>
</head>
<body>
<form action="Servlet">

  <table>
    <core:forEach var = "el" items="${lst}" varStatus="status">
      <tr>
        <th><core:out value="${el.Name}"/></th>
        <th><core:out value="${el.Address}"/></th>
      </tr>
    </core:forEach>
  </table>
    <input type="text" name="Name"/>
    <input type="text" name="Address"/>
    <button type="submit" name="action">Go</button>
  </div>
</form>
</body>
</html>