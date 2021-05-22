<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="LoginServlet?action=loginJudge" method="post">
    学号<input type="text" name="userId">
    密码 <input type="password" name="password">
    提交 <input type="submit">
</form>
</body>
</html>