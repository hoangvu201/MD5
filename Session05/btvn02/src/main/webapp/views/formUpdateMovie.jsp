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
    <title>Delete Movie</title>
</head>
<body>
<h2 style="text-align: center">Sửa Phim</h2>
<p>${message}</p>
<form action="EditMovieServlet" method="post">
    <input type="hidden" name="id" value="${movie.id}">
    <label for="title">Tiêu Đề: </label><br>
    <input type="text" name="title" value="${movie.title}" style="width: 100%"><br><br>
    <label for="director">Đạo Diễn: </label><br>
    <input type="text" name="director" value="${movie.director}" style="width: 100%"><br><br>
    <label for="genre">Thể Loại:</label><br>
    <input type="text" name="genre" value="${movie.genre}" style="width: 100%"><br><br>
    <label for="description">Mô Tả:</label><br>
    <input type="text" name="description" value="${movie.description}" style="width: 100%"><br><br>
    <label for="duration">Thời Gian(phút):</label><br>
    <input type="number" name="duration" value="${movie.duration}" style="width: 100%"><br><br>
    <label for="language">Ngôn Ngữ:</label><br>
    <input type="text" name="language" value="${movie.language}" style="width: 100%"><br><br>
    <input type="submit" value="Cập nhật phim">
</form>
</body>
</html>
