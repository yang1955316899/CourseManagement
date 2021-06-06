<%--
  Created by IntelliJ IDEA.
  User: SeRein
  Date: 2021/6/3
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../static/layuiadmin/layui/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <form class="layui-form" action="">
            <!--隐藏域,用于传递学生的classId-->
            <input type="hidden" name="classId" value="${sessionScope.myClass.id}">
            <%--学号--%>
            <div class="layui-form-item">
                <label class="layui-form-label">学号</label>
                <div class="layui-input-block">
                    <input type="text" name="userId" lay-verify="userId" autocomplete="off" placeholder="请输入学生学号"
                           class="layui-input">
                </div>
            </div>
            <%--姓名--%>
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <input type="text" name="userName" lay-verify="userName" autocomplete="off" placeholder="请输入学生姓名"
                           class="layui-input">
                </div>
            </div>
            <%--密码--%>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="text" name="password" lay-verify="password" autocomplete="off" placeholder="请输入密码"
                           class="layui-input">
                </div>
            </div>
            <%--性别--%>
            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" value="1" title="男" checked="">
                    <input type="radio" name="sex" value="0 " title="女">
                </div>
            </div>
            <%--年龄--%>
            <div class="layui-form-item">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-block">
                    <input type="text" name="age" lay-verify="age" autocomplete="off" placeholder="请输入学生年龄"
                           class="layui-input">
                </div>
            </div>
            <%--角色--%>
            <div class="layui-form-item">
                <label class="layui-form-label">角色</label>
                <div class="layui-input-block">
                    <input type="radio" name="roleId" value="1" title="超级管理员" checked="">
                    <input type="radio" name="roleId" value="2" title="授课教师">
                    <input type="radio" name="roleId" value="3" title="辅导员">
                    <input type="radio" name="roleId" value="4" title="学生">
                    <input type="radio" name="roleId" value="5" title="辅导员,授课老师">
                </div>
            </div>
            <%--班级--%>
            <div class="layui-form-item">
                <label class="layui-form-label">班级(不是学生则填无)</label>
                <div class="layui-input-block">
                    <input type="text" name="className" autocomplete="off" placeholder="请输入所属班级";
                           class="layui-input">
                </div>
            </div>
            <%--提交--%>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>

        </form>
    </div>
</div>

<script src="../static/layuiadmin/layui/layui.js" charset="utf-8"></script>
<script src="../static/js/jquery-3.6.0.min.js"></script>
<script>
    layui.use(['form', 'layedit'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit;

        /**
         * 正则表达式自定义验证规则
         */
        form.verify({
            userId: [
                /^\d{10}$/
                , '请输入10位学号'
            ]
            , password: [
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ], userName: [
                /^[\u4e00-\u9fa5]{2,4}$/
                , '姓名必须为2-4个纯中文'
            ]
            , age: [
                /^(?:[1-9][0-9]?|1[01][0-9]|120)$/
                , '请输入正确年龄'
            ],
        });

        //监听提交
        form.on('submit(demo1)', function (data) {

            $.ajax({
                url: "../SuperManageServlet?action=superAdd",  //servlet接口路径
                type: 'post',                              //提交类型
                dataType: 'json',                //数据类型
                data: data.field, //数据
                async: false,
                success: function (data) {
                    console.log("添加成功");
                    alert("用户添加成功")
                    },
                error: function () {
                    console.log("回调失败");
                }
            });
        });
    });
</script>
</body>
</html>