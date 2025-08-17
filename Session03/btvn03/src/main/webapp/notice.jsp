<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/3/2025
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ra.edu.btvn03.model.Student" %>
<jsp:useBean id="student" type="ra.edu.btvn03.model.Student" scope="request" />
<html>
<head>
  <title>Thông tin sinh viên</title>
</head>
<body>
<h2>Thông tin đã nhập:</h2>
<p>Họ tên: ${student.name}</p>
<p>Tuổi: ${student.age}</p>
<p>Địa chỉ: ${student.address}</p>
</body>
</html>

