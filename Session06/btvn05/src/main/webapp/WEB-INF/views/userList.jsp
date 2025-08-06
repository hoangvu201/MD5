<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/6/2025
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Danh sách người dùng</title>
</head>
<body>
<h2>Danh sách người dùng</h2>
<table border="1" cellpadding="10" cellspacing="0">
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Tuổi</th>
        <th>Ngày sinh</th>
        <th>Email</th>
        <th>Số điện thoại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

