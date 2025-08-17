<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/5/2025
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách phim</title>
</head>
<body>
<h2 style="text-align: center">Danh sách phim</h2>
<div><a href="views/formAddMovie.jsp">Thêm mới phim</a></div>
<br>
<p>${message}</p>
<table border="1" cellpadding="10">
    <thead>
    <tr>
        <td>Mã phim</td>
        <td>Tiêu đề</td>
        <td>Đạo diễn</td>
        <td>Thể loại</td>
        <td>Mô tả</td>
        <td>Thời lượng</td>
        <td>Ngôn ngữ</td>
        <td>Hành động</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${movies}" var="m">
        <tr>
            <td>${m.id}</td>
            <td>${m.title}</td>
            <td>${m.director}</td>
            <td>${m.genre}</td>
            <td>${m.description}</td>
            <td>${m.duration}</td>
            <td>${m.language}</td>
            <td>
                <a href="EditMovieServlet?id=${m.id}">Edit</a>
                <a href="DeleteMovieServlet?id=${m.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xoá danh mục này?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
