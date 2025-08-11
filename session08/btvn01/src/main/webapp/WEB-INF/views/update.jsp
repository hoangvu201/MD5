<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/10/2025
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sửa thông tin</h2>
<form:form method="post" modelAttribute="student" action="${pageContext.request.contextPath}/update">
    <table>
        <tr>
            <td>ID:</td>
            <td><form:input path="id" readonly="true" /></td>
        </tr>
        <tr>
            <td>Tên:</td>
            <td>
                <form:input path="name" />
                <form:errors path="name" cssStyle="color:red" />
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <form:input path="email" />
                <form:errors path="email" cssStyle="color:red" />
            </td>
        </tr>
        <tr>
            <td>Ngày sinh:</td>
            <td>
                <form:input path="dob" />
                <form:errors path="dob" cssStyle="color:red" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Cập nhật" />
                <a href="${pageContext.request.contextPath}/list">Hủy</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
