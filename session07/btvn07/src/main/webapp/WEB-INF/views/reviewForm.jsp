<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/10/2025
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Đánh Giá</title>
</head>
<body>
<h2>Form Đánh Giá</h2>

<form:form method="post" modelAttribute="review">
    <div>
        <label>Tên:</label>
        <form:input path="username"/>
        <form:errors path="username" cssClass="error"/>
    </div>

    <div>
        <label>Email:</label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>

    <div>
        <label>Đánh giá (1-5):</label>
        <form:input path="rating" type="number"/>
        <form:errors path="rating" cssClass="error"/>
    </div>

    <div>
        <label>Bình luận:</label>
        <form:textarea path="comment" rows="4" cols="30"/>
        <form:errors path="comment" cssClass="error"/>
    </div>

    <div>
        <input type="submit" value="Gửi đánh giá"/>
    </div>
</form:form>

<style>
    .error {
        color: red;
        font-size: 12px;
    }
</style>

</body>
</html>

