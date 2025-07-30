<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chuyển đổi tiền</title>
</head>
<body>
<h1><%="Chuyển đổi tiền tệ" %>
</h1>
<form action="convert" method="post">
    <label>Rate</label><br/>
    <input type="number" placeholder="Enter your rate" name="rate" required><br>
    <label>USD</label><br>
    <input type="number" placeholder="Enter your usd" name="usd" required><br><br>
    <button value="Convert">Convert</button>
</form>
</body>
</html>