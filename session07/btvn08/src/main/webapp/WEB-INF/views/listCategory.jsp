<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/10/2025
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<h2>
    Danh mục sản phẩm
</h2>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Tên danh mục</td>
        <td>Mô tả</td>
        <td>Trạng thái</td>
        <td>Hành động</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.categoryName}</td>
            <td>${c.description}</td>
            <td>${c.status ? "Còn bán":"Hết hàng"}</td>
            <td>
                <a href="">Sửa</a>
                <a href="" onclick="return confirm('Bạn có chắc muốn xoá?')">Xoá</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
