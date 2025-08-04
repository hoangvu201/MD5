<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/4/2025
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa danh mục</title>
</head>
<body>
<p>${message}</p>
<form action="editCategoryController" method="post">
  <input type="hidden" name="id" value="${category.id}">
  <label for="name">Tên danh mục: </label><br>
  <input type="text" name="name" value="${category.cateName}"><br>
  <label for="description">Mô tả: </label><br>
  <input type="text" name="description" value="${category.description}"><br>
  <label for="status">Trạng thái</label><br>
  <input type="radio" name="status" value="1"  <c:if test="${category.status}">checked</c:if>>Còn hàng
  <input type="radio" name="status" value="0"  <c:if test="${!category.status}">checked</c:if>>Hết hàng <br>
  <input type="submit" value="Lưu cập nhật">
</form>
</body>
</html>
