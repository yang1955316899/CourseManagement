<%@ page import="top.jsjkxyjs.entity.Grade" %>
<%@ page import="top.jsjkxyjs.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="top.jsjkxyjs.service.CounselorService" %>
<%@ page import="top.jsjkxyjs.service.impl.CounselorServiceImpl" %>
<%@ page import="top.jsjkxyjs.entity.Class" %>
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
<body style="background-color: white">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>班级成绩</legend>
</fieldset>

<%
    CounselorService service = new CounselorServiceImpl();
    Class myClass = (Class) session.getAttribute("myClass");
    int classId = myClass.getId();
    System.out.println(classId);
    List<User> userList = service.doGetGradeByClass(classId);
    System.out.println(userList.size());

%>

<div class="layui-form">
    <table class="layui-table">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <c:forEach begin="1" end="8" var="i">
                <th>课程名${i}</th>
                <th>成绩</th>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < userList.size(); i++) {
        %>
        <tr>
            <td><%=userList.get(i).getUserId()%>
            </td>
            <td><%=userList.get(i).getUserName()%>
            </td>
            <%
                for (int j = 0; j < 8; j++) {
            %>
            <td><%=userList.get(i).gradeList.get(j).getCourseName()%>
            </td>
            <td><%=userList.get(i).gradeList.get(j).getGrade()%>
            </td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</table>

<script src="../static/layuiadmin/layui/layui.js" charset="utf-8"></script>
</body>
</html>
