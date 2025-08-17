<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nhập thông tin</title>
</head>
<body>
<h1>Nhập Thông Tin Người Dùng
</h1>
<br/>
<form action="SaveUser" method="post">
    <label>Tên:</label> <br>
    <input type="text" name="name" required><br>

    <label>Email:</label> <br>
    <input type="email" name="email" required><br>

    <input type="submit" value="Gửi">
</form>
</body>
</html>