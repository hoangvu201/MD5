<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/6/2025
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>
<h2>Danh sách nhân viên</h2>
<table border="1" cellpadding="10">
    <thead>
    <tr>
        <th>Tên</th>
        <th>Email</th>
        <th>Vị trí</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.salary}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${not empty message}">
    <div class="alert alert-success">${message}</div>
</c:if>

<a href="${pageContext.request.contextPath}/employees/employees/add">Thêm nhân viên mới</a>
</body>
</html>

