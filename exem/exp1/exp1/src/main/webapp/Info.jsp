<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Сongratulations</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Prothent</th>
    </tr>
    <core:forEach var = "el" items="${lst}" varStatus="status">
        <tr>
            <th><core:out value="${el.name}"/></th>
            <th><core:out value="${el.vote}"/></th>
        </tr>
    </core:forEach>
</table>
</body>
</html>
