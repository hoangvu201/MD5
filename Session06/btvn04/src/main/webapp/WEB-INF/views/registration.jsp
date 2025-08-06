<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/6/2025
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post">
    <p>Tên người dùng:</p>
    <input type="text" name="username" value="${username}"><br>
    <p style="color: red">${usernameError}</p>
    <p>Email:</p>
    <input type="email" name="email" value="${email}"><br>
    <p style="color: red">${emailError}</p>
    <p>Số điện thoại:</p>
    <input type="tel" name="phoneNumber" value="${phoneNumber}"><br>
    <p style="color: red">${phoneError}</p>
    <button>Đăng ký</button>
</form>
</body>
</html>
