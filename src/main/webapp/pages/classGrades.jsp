<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SeRein
  Date: 2021/6/2
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>班级成绩</legend>
</fieldset>

<div class="layui-form">
    <table class="layui-table">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <c:forEach begin="1" end="${sessionScope.gradesList.size()}" var="i">
                <th>课程名${i}</th>
                <th>成绩</th>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <c:forEach begin="1" end="${sessionScope.gradesList.size()}" var="i">
            <tr>
                <td>201901410${i}</td>
                <td>张三${i}号</td>
                <c:forEach begin="1" end="10" var="i">
                    <td>课程${i}</td>
                    <td>${i*20}</td>
                </c:forEach>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</table>


<script src="../static/layuiadmin/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>

</script>

</body>
</html>
