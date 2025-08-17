<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/4/2025
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm danh mục mới</title>
</head>
<body>
<p>${message}</p>
<form action="addCategory" method="post">
  <input type="text" placeholder="Nhập vào tên danh mục" name="cateName"><br>
  <input type="text" placeholder="Nhập vào mô tả danh mục" name="description"><br>
  <input type="submit" value="Thêm mới">
</form>
</body>
</html>
