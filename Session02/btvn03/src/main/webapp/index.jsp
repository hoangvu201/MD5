<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Nhập Thông Tin Người Dùng
</h1>
<br/>
<form action="Register" method="post">
    <label>Username: </label> <br>
    <input type="text" name="username" required><br>

    <label>Password: </label> <br>
    <input type="password" name="password" required><br>

    <label>Email:</label> <br>
    <input type="email" name="email" required><br>

    <input type="submit" value="Register">
</form>
</body>
</html>