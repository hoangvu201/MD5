<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/7/2025
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="POST" action="submitForm" modelAttribute="user">
    <label>Họ tên:</label>
    <form:input path="name" /><br/><br/>

    <label>Tuổi:</label>
    <form:input path="age" /><br/><br/>

    <label>Địa chỉ:</label>
    <form:input path="address" /><br/><br/>

    <input type="submit" value="Gửi">
</form:form>
</body>
</html>
