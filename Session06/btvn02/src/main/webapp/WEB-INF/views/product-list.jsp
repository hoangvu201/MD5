<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/6/2025
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách sản phẩm</title></head>
<body>
<h2>Danh sách sản phẩm</h2>
<table border="1" cellpadding="10">
  <tr>
    <th>STT</th>
    <th>Tên</th>
    <th>Giá</th>
    <th>Mô tả</th>
    <th>Ảnh</th>
  </tr>
  <c:forEach var="product" items="${products}" varStatus="status">
    <tr>
      <td>${status.index + 1}</td>
      <td>${product.productName}</td>
      <td>${product.price}</td>
      <td>${product.description}</td>
      <td><img src="${product.image}"/></td>
    </tr>
  </c:forEach>
</table>
<a href="/products/add">Thêm sản phẩm mới</a>
</body>
</html>
