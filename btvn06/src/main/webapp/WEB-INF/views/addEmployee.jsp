<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/6/2025
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm nhân viên</title>
</head>
<body>
<h2>Form thêm nhân viên</h2>
<form action="${pageContext.request.contextPath}/employees" method="post">
    <label for="name">Tên:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="position">Vị trí:</label>
    <input type="text" id="position" name="position" required><br><br>

    <button type="submit">Thêm nhân viên</button>
</form>
</body>
</html>

