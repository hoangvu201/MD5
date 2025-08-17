<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Đăng nhập</h1>
<form action="hello-servlet" method="post">
    <label for="username">
        Username: <input type="text" name="username" required>
    </label> <br>
    <label for="password">
        Password: <input type="password" name="password" required>
    </label><br>
    <input type="submit" value="Đăng Nhập">
    <h3>${messageH3}</h3>
    <p>${messageP}</p>
</form>
</body>
</html>