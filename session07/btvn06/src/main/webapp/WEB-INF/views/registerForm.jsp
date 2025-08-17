<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/10/2025
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form:form modelAttribute="user" action="register" method="post">
    <table>
        <tr>
            <td>Tên đăng nhập:</td>
            <td>
                <form:input path="username"/> <br>
                <form:errors path="username" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>Số điện thoại: </td>
            <td>
                <form:input path="phoneNumber"/> <br>
                <form:errors path="phoneNumber" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Đăng ký">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
