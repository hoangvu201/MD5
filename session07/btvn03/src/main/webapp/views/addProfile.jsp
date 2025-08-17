<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/7/2025
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Profile</title>
</head>
<body>
<h1>ADD PROFILE</h1>
<form:form modelAttribute="userProfile" action="add-profile" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Avatar: </td>
            <td>
                <form:input path="avatar" type="file"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Add Profile">
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>