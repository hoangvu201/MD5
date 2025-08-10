<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/10/2025
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<table border="1" cellpadding="10">
    <tr>
        <td>Id</td>
        <td>Tên</td>
        <td>Email</td>
        <td>Ngày sinh</td>
        <td>Hành động</td>
    </tr>
    <c:forEach items="student" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td>${s.dob}</td>
            <td>
                <a href="${pageContext.request.contextPath}/update?id=${s.id}">Sửa</a>
                <a href="${pageContext.request.contextPath}/deleteStudent?id=${s.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
