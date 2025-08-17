<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Đăng nhập
</h1>
<form action="LoginServlet" method="post">
    <input type="text" name="username" placeholder="Nhập vào tên người dùng" ><br>
    <input type="password" name="password" placeholder="Nhập vào mật khẩu" ><br>
    <input type="submit">
</form>
<p>${error}</p>
</body>
</html>