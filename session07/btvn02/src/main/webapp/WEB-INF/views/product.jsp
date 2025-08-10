<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="POST" action="addProduct" modelAttribute="product">
    <label>Tên:</label>
    <form:input path="name" /><br/><br/>

    <label>Giá:</label>
    <form:input path="price" /><br/><br/>

    <label>Mô tả:</label>
    <form:input path="description" /><br/><br/>

    <input type="submit" value="Gửi">
</form:form>
</body>
</html>
