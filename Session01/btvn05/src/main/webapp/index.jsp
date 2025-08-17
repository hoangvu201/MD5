<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sign up
</h1>
<p>${messageSuccess}</p>
<form action="hello-servlet" method="post" autocomplete="off">
    <input type="text" name="username" placeholder="Username" value="${username}" ><br>
    <p>${messageUsername}</p>
    <input type="email" name="email" placeholder="Email" value="${email}" ><br>
    <p>${messageEmail}</p>
    <input type="password" name="password" placeholder="Password" ><br>
    <p>${messagePassword}</p>
    <input type="password" name="confirmPassword" placeholder="Confirm password"  >
    <p>${messageConfirmPassword}</p>
    <input type="submit" value="Sign up">
</form>
</body>
</html>