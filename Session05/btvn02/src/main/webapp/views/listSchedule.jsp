<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/5/2025
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách lịch chiếu phim</title>
</head>
<body>
<h2 style="text-align: center">Danh sách lịch chiếu phim</h2>
<div><a href="views/addSchedule.jsp">Thêm mới lịch chiếu</a></div>
<br>
<p>${message}</p>
<table border="1" cellpadding="10">
    <thead>
    <tr>
        <td>Tiêu đề phim</td>
        <td>Thời gian</td>
        <td>Phòng chiếu</td>
        <td>Số ghế có sẵn</td>
        <td>Định dạng</td>
        <td>Hành động</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${scheduleList}" var="s">
        <tr>
            <td>${s.movieTitle}</td>
            <td>${s.showTime}</td>
            <td>${s.screenRoomId}</td>
            <td>${s.availableSeats}</td>
            <td>${s.format}</td>
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
