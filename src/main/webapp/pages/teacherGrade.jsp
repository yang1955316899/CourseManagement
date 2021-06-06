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

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">开启头部工具栏</div>
                <div class="layui-card-body">
                    <form class="layui-form" lay-filter="form">
                        <input type="hidden" name="TeacherId" id="TeacherId" value=${sessionScope.user.userId}>
                        <div class="layui-form-item">
                            <div class="layui-input-inline">
                                <select name="CourseId" id="CourseId">
                                    <option value="">请选择您的课程</option>
                                </select>
                            </div>
                            <span class="layui-form-itemb layui-input-block">
                                    <button type="submit" class="layui-btn" lay-submit lay-filter="submit">立即提交</button>
                            </span>
                        </div>
                    </form>
                    <table class="layui-hide" id="test" lay-filter="test"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../static/layuiadmin/layui/layui.js" charset="utf-8"></script>
<script src="../static/js/jquery-3.6.0.min.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate', 'table'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , table = layui.table;
        $.ajax({
            url: "../Teacher?action=getCourseByTeacherId",
            type: "post",
            dataType: "json",
            data: "TeacherId=" + document.querySelector('#TeacherId').value,
            success: function (result) {
                for (var index = 0; index < result.length / 2; index++)
                    $('#CourseId').append($("<option value=" + result[index] + ">" + result[index + 1] + "</option>"));
                form.render('select');
            }
        })
        form.on('submit(submit)', function (data) {
            table.render({
                elem: '#test'
                , url: '../Teacher?action=getStudentsByCoureId' + '&courseId=' + data.field.CourseId
                , size: 'lg'
                , cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'StudentId', title: '学生id', edit: 'text'}
                    , {field: 'StudentName', title: '学生姓名', edit: 'text'}
                    , {field: 'ClassId', title: '班级id', edit: 'text'}
                    , {field: 'CourseId', title: '课程id', edit: 'text'}
                    , {field: 'Grade', title: '分数', edit: 'text'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
                ]]
            });
            return false;
        })
        table.on('edit(test)', function (obj) {//监听修改
            var value = obj.value,//得到修改后的值
                data = obj.data,   //得到所在行所有键值
                field = obj.field;  //得到字段
            layer.msg('[ID:' + data.StudentId + ']' + field + ' 字段更改为：' + value);
            //Ajax 异步修改数据!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            $.getJSON("../Teacher", "action=upDateStudent&StudentId=" + data.StudentId + "&newGrade=" + value,
                function (result) {

                });
        });
    })

</script>

</body>
</html>