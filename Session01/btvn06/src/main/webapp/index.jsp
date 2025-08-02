<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Note App</title>
</head>
<body>

<form method="post" action="note">
    <input type="text" name="noteInput">
    <button type="submit">Note</button>
</form>

<ul>
    <li>Đi học</li>
    <li>Làm thêm</li>
    <c:forEach var="note" items="${notes}">
        <li>${note}</li>
    </c:forEach>
</ul>
</body>
</html>
