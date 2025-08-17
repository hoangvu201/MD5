<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/7/2025
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notice</title>
</head>
<body>
    <p>${success}</p>
    <table>
        <tr>
            <td>Tên đăng nhập:</td>
            <td>
                ${user.name}
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
               ${user.email}
            </td>
        </tr>

    </table>
</body>
</html>
