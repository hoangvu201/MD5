<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/4/2025
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category List</title>
</head>
<body>
<p>${message}</p>
<div style="display: flex;gap:10px;align-content: space-around">
    <table border="1" cellpadding="10" style="margin-right: 50px">
        <caption style="text-align: center">List Categories</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cate" items="${categoryList}">
            <tr>
                <td>${cate.id}</td>
                <td>${cate.cateName}</td>
                <td>${cate.description}</td>
                <td>${cate.status ? "Còn hàng" : "Hết hàng"}</td>
                <td>
                    <a href="editCategoryController?id=${cate.id}">Edit</a>
                    <a href="deleteCategoryController?id=${cate.id}"
                       onclick="return confirm('Bạn có chắc chắn muốn xoá danh mục này?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table border="1" cellpadding="10">
        <caption style="text-align: center">List Products</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category ID</th>
            <th>Count</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productsList}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.categoryId}</td>
                <td>${product.count}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<a href="addCategory">Thêm danh mục mới</a>
</body>
</html>

