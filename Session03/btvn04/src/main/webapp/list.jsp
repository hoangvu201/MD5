<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/3/2025
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách sinh viên</title></head>
<body>
<h2>Danh sách sinh viên</h2>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
            <td>
                <a href="edit?id=${student.id}">Sửa</a> |
                <a href="delete?id=${student.id}" onclick="return confirm('Xóa sinh viên này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

