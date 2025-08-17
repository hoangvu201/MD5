<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/10/2025
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h2>Thêm mới sinh viên</h2>
<form:form modelAttribute="student" method="post">
    <table>
        <tr>
            <td>Tên sinh viên:</td>
            <td>
                <form:input path="name"/>
                <form:errors path="name" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>Email sinh viên</td>
            <td>
                <form:input path="email" type="email"/>
                <form:errors path="email" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>Ngày sinh</td>
            <td>
                <form:input path="dob" type="date"/>
                <form:errors path="dob" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Lưu thông tin">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
