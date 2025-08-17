<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Quản Lý Sản Phẩm
</h1>
<h3>Thêm sản phẩm</h3>
<form action="hello-servlet" method="post">
    <label for="id">ID</label><br>
    <input type="text" name="id"><br>
    <label for="name">Tên sản phẩm</label><br>
    <input type="text" name="name"><br>
    <label for="price">Giá</label><br>
    <input type="text" name="price"><br>
    <label for="description">Mô tả</label><br>
    <input type="text" name="description"> <br>
    <label for="count">Số lương</label><br>
    <input type="number" name="count"> <br>
    <input type="submit" value="Thêm sản phẩm">
</form>
<br>
<h3>Danh sách sản phẩm đã thêm: </h3>
<table border="1">
    <thead>
    <tr>
        <td>ID</td>
        <td>Tên sản phẩm</td>
        <td>Giá</td>
        <td>Mô tả</td>
        <td>Số lượng</td>
        <td>Trạng thái</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>Sản phẩm A</td>
        <td>100</td>
        <td>Mô tả cho sản phẩm</td>
        <td>50</td>
        <td>Đang bán</td>
    </tr>
    <c:forEach var="p" items="${list}">
        <tr>
            <td>${p.id}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>${p.stock}</td>
            <td>Đang bán</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>