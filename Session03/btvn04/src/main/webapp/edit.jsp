<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/3/2025
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Sửa thông tin sinh viên</title></head>
<body>
<h2>Sửa thông tin sinh viên</h2>
<form action="edit" method="post">
    <input type="hidden" name="id" value="${student.id}" />
    Tên: <input type="text" name="name" value="${student.name}" /><br/>
    Tuổi: <input type="number" name="age" value="${student.age}" /><br/>
    Địa chỉ: <input type="text" name="address" value="${student.address}" /><br/>
    <input type="submit" value="Cập nhật"/>
</form>
</body>
</html>


