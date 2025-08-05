<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/5/2025
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>
<h2 style="text-align: center">Thêm Mới Phim</h2>
<p>${message}</p>
<form action="<%=request.getContextPath()%>/AddMovieServlet" method="post">
    <label for="title">Tiêu Đề: </label><br>
    <input type="text" name="title" style="width: 100%"><br><br>
    <label for="director">Đạo Diễn: </label><br>
    <input type="text" name="director" style="width: 100%"><br><br>
    <label for="genre">Thể Loại:</label><br>
    <input type="text" name="genre" style="width: 100%"><br><br>
    <label for="description">Mô Tả:</label><br>
    <input type="text" name="description" style="width: 100%"><br><br>
    <label for="duration">Thời Gian(phút):</label><br>
    <input type="number" name="duration" style="width: 100%"><br><br>
    <label for="language">Ngôn Ngữ:</label><br>
    <input type="text" name="language" style="width: 100%"><br><br>
    <input type="submit" value="Thêm phim">
    <input type="reset" value="Huỷ thêm mới">
</form>
<a href="<%=request.getContextPath()%>/MovieListServlet">Trở về trang chủ</a>
</body>
</html>
