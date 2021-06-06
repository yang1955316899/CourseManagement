<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <legend>个人信息</legend>
</fieldset>

<form class="layui-form" action="">
    <%--用户id--%>
    <div class="layui-form-item">
        <label class="layui-form-label">ID(不可修改)</label>
        <div class="layui-input-block">
            <input type="text" name="userId" lay-verify="userId" autocomplete="off"
                   value="${sessionScope.user.userId}" class="layui-input" disabled>
        </div>
    </div>
    <%--userName--%>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="userName" lay-verify="userName" autocomplete="off"
                   value="${sessionScope.user.userName}" class="layui-input">
        </div>
    </div>
    <%--年龄--%>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text" name="age" lay-verify="age" autocomplete="off"
                   value="${sessionScope.user.age}" class="layui-input">
        </div>
    </div>
    <%--性别--%>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <c:if test="${sessionScope.user.sex==1}">
                <input type="radio" name="sex" value="1" title="男" checked="">
                <input type="radio" name="sex" value="0" title="女">
            </c:if>
            <c:if test="${sessionScope.user.sex==0}">
                <input type="radio" name="sex" value="1" title="男">
                <input type="radio" name="sex" value="0" title="女" checked="">
            </c:if>

        </div>
    </div>
    <%--角色--%>
    <div class="layui-form-item">
        <label class="layui-form-label">角色(不可修改)</label>
        <div class="layui-input-block">
            <select name="roleId" lay-filter="roleId" disabled>
                <option value="">${sessionScope.user.roleName}</option>
                <option value="1">超级管理员</option>
                <option value="2">授课老师</option>
                <option value="3">辅导员</option>
                <option value="4">学生</option>
                <option value="5">辅导员,授课老师</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script src="../static/js/jquery-3.6.0.min.js"></script>
<script src="../static/layuiadmin/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit

        //自定义验证规则
        form.verify({
            age: [
                /^(?:[1-9][0-9]?|1[01][0-9]|120)$/
                , '请输入正确年龄'
            ]
            , userName: [
                /^[\u4e00-\u9fa5]{2,4}$/
                , '姓名必须为2-4个纯中文'
            ]
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            let age = data.field.age;
            $.ajax({
                url: "../PersonalServlet?action=changeMyInfo",  //servlet接口路径
                type: 'post',                              //提交类型
                dataType: 'json',                //数据类型
                data: data.field, //数据
                async: false,
                success: function (data) {
                    layer.open({
                        title: '修改成功'
                        , content: '信息修改成功！'
                    });
                }
            });
            return false;
        });

    });
</script>

</body>
</html>