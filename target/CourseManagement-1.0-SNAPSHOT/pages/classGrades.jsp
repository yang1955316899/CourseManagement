<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SeRein
  Date: 2021/6/2
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <legend>班级学生信息查看</legend>
</fieldset>

<div class="layui-form">
    <table class="layui-table">
        <%--表头--%>
        <thead>
        <tr style="background-color: #01AAED">
            <th>2019014102</th>
            <th>杨戬问</th>
        </tr>
        <tr style="background-color: #2E2D3C">
            <th>课程id</th>
            <th>课程名</th>
            <th>授课教师</th>
            <th>成绩</th>
            <th>学分</th>
        </tr>

        </thead>
        <%--表格内容--%>
        <tbody>
        <c:forEach begin="1" end="10" var="i">
            <tr>
                <th>110</th>
                <th>java面向对象程序设设计</th>
                <th>彭伟</th>
                <th>90</th>
                <th>3.5</th>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<script src="../static/layuiadmin/layui/layui.js" charset="utf-8"></script>
<script>

</script>

</body>
</html>

