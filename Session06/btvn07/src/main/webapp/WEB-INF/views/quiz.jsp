<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/7/2025
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Quiz Game</title></head>
<body>
<h2>Đoán đáp án cho bức ảnh sau:</h2>

<img src="${question.imageUrl}" alt="Câu hỏi" width="300"/><br><br>

<form action="${pageContext.request.contextPath}/guess" method="post">
    <input type="hidden" name="attempts" value="${attempts}" />
    <input type="hidden" name="question.id" value="${question.id}" />
    <input type="hidden" name="question.imageUrl" value="${question.imageUrl}" />
    <input type="hidden" name="question.answer" value="${question.answer}" />

    <p>${question.content}</p>

    <label>Nhập câu trả lời: </label>
    <input type="text" name="userAnswer" required />

    <button type="submit">Gửi</button>
</form>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>


<c:if test="${fail}">
    <a href="${pageContext.request.contextPath}/quiz">Chơi lại</a>
</c:if>

</body>
</html>

