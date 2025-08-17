<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/8/2025
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile!</title>
</head>
<body>
<h1>User Profile</h1>
<h3>Name: ${name}</h3>
<div>
    <img src="<c:url value='../resources'/>/images/${avatarName}" alt="" width="300px" height="300px">
</div>
<div>
    <img src="${avatarUrl}" alt="Anh chan dung" width="300px" height="300px">
</div>
</body>
</html>
