<%--
  Created by IntelliJ IDEA.
  User: SeRein
  Date: 2021/5/31
  Time: 14:56
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

            <div class="layui-form-item">
                <label class="layui-form-label">学号</label>
                <div class="layui-input-block">
                    <input type="text" name="userId" lay-verify="userId" autocomplete="off" placeholder="请输入学生学号"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <input type="text" name="userName" lay-verify="userName" autocomplete="off" placeholder="请输入学生姓名"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="text" name="password" lay-verify="password" autocomplete="off" placeholder="请输入密码"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" value="1" title="男" checked="">
                    <input type="radio" name="sex" value="0 " title="女">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-block">
                    <input type="text" name="age" lay-verify="age" autocomplete="off" placeholder="请输入学生年龄"
                           class="layui-input">
                </div>
            </div>

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
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
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
            ] /*function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }*/
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
            ]
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            console.log(data.field);
            $.ajax({
                url: "../CounselorServlet?action=addStudent",  //servlet接口路径
                type: 'post',                              //提交类型
                dataType: 'json',                //数据类型
                data: data.field, //数据
                async: false,
                success: function (data) {
                    console.log("添加成功");
                },
                error: function () {
                    console.log("回调失败");
                }
            });
            /*$.getJSON("../CounselorServlet?action=addStudent",data.field,function(data){
                console.log("添加的回调函数");
            });*/
        });
    });
</script>

</body>
</html>