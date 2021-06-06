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
    <legend>修改密码</legend>
</fieldset>

<form class="layui-form" action="">
    <%--隐藏域,存放userId--%>
    <input type="hidden" id="userId" name="userId" value="${sessionScope.user.userId}">

    <%--旧密码--%>
    <div class="layui-form-item">
        <label class="layui-form-label">旧密码</label>
        <div class="layui-input-block">
            <input type="text" name="oldPassword" lay-verify="oldPassword" autocomplete="off"
                   placeholder="请输入旧密码" class="layui-input">
        </div>
    </div>
    <%--新密码--%>
    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-block">
            <input type="text" name="newPassword" id="newPassword" lay-verify="newPassword" autocomplete="off"
                   placeholder="请输入新密码" class="layui-input">
        </div>
    </div>

    <%--确认密码--%>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block">
            <input type="text" name="confirmPassword" lay-verify="confirmPassword" autocomplete="off"
                   placeholder="请再次输入密码" class="layui-input">
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

        //获取隐藏域中的值
        let userId = $("#userId").val();
        //自定义验证规则
        form.verify({
            oldPassword: function (value) { //验证旧密码是否输入正确
                if (value.length === 0) {
                    return "请输入旧密码";
                }
                let bl = true;
                $.ajaxSettings.async = false  //同步请求
                $.getJSON("../PersonalServlet?action=ifCorrect&userId=" + userId + "&oldPassword=" + value, function (data) {
                    console.log(data.result);
                    if (data.result === 0) {
                        bl = false;
                        console.log("bl=" + bl);
                    }
                });
                console.log("bl:" + bl);
                if (bl === false) {
                    return '请输入正确的旧密码';
                }
            }
            , newPassword: [   //判断新密码是否符合规范
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ]
            , confirmPassword: function (value) {  //判断两次密码输入是否相同
                let t = $("#newPassword").val();
                if (t !== value) {
                    return '两次密码输入不一致';
                }
            }
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            $.ajax({
                url: "../PersonalServlet?action=changePassword",  //servlet接口路径
                type: 'post',                              //提交类型
                dataType: 'json',                //数据类型
                data: data.field, //数据
                async: false,
                success: function (data) {
                    layer.open({
                        title: '修改成功'
                        , content: '密码修改成功！'
                        , yes: function () {  //弹出层点击确定后执行回调
                            let route = window.location.href; //获取当前页面路径
                            window.location.replace(route);   //重定向到当前路径
                        }
                    });
                },
                error: function () {
                    console.log("回调失败");
                }
            });
            return false;
        });

    });
</script>

</body>
</html>