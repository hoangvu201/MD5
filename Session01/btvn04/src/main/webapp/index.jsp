<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Đăng nhập
</h1>
<p>${message}</p>
<form action="hello-servlet" method="post">
    <input type="text" placeholder="Tên đăng nhập" name="name" ><br>
    <input type="password" placeholder="Mật khẩu" name="password"> <br>
    <input type="submit" value="Đăng nhập">
</form>
</body>
</html>