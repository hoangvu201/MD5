<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/7/2025
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thông tin sản phẩm</title>
</head>
<body>
    <table border="1" cellpadding="10">
        <tr>
            <td>Tên sản phẩm</td>
            <td>Giá sản phẩm</td>
            <td>Mô tả</td>
        </tr>
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
        </tr>
    </table>
</body>
</html>
