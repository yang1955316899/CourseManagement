<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>数据操作 - 数据表格</title>
    <meta content="webkit" name="renderer">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"
          name="viewport">
    <link href="../static/layuiadmin/layui/css/layui.css" media="all" rel="stylesheet">
    <link href="../static/layuiadmin/style/admin.css" media="all" rel="stylesheet">
</head>
<body>


<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">数据操作</div>
                <div class="layui-card-body">
                    <input type="hidden" name="UserId" id="userId" value=${sessionScope.user.userId}>
                    <table class="layui-hide" id="Course" lay-filter="Course"></table>
                    <script id="Choose" type="text/html">
                        <a class="layui-btn layui-btn-primary" lay-event="Choose">选择</a>
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<script id="ClassCode" type="text/html">
    {{# var tem="";
    var day = ["","一","二","三","四","五","六","七","八","九","十","十一","十二"];
    for(var index = 1;index < d.ClassCode.length;index++)
    if(d.ClassCode[index] == 0)
    tem+=day[index]+" ";
    }}
    {{tem}}
</script>

<script id="Week" type="text/html">
    {{# if(d.Week=== 1) { }}
    星期一
    {{# } else if(d.Week=== 2) { }}
    星期二
    {{# } else if(d.Week=== 3) { }}
    星期三
    {{# } else if(d.Week=== 4) { }}
    星期四
    {{# } else if(d.Week=== 5) { }}
    星期五
    {{# } else if(d.Week=== 6) { }}
    星期六
    {{# } else if(d.Week=== 7) { }}
    星期日
    {{# } else { }}
    未知
    {{# } }}
</script>
<script src="../static/js/jquery-3.6.0.min.js"></script>
<script src="../static/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '../static/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'jquery', 'table'], function () {
        var table = layui.table
            , admin = layui.admin;

        table.render({
            elem: '#Course'
            , url: '../Course?action=getAllChooseCourses&UserId=' + $('#userId').val()
            , size: 'lg'
            , cols: [[{field: 'id', hide: true}
                , {field: 'CourseName', minWidth: 180, title: '课程名', sort: true}
                , {field: 'TeacherName', minWidth: 80, title: '教师', sort: true}
                , {field: 'MaxSize', minWidth: 110, title: '人数限制', sort: true}
                , {field: 'RoomName', minWidth: 150, title: '地点'}
                , {field: 'Week', minWidth: 100, title: '星期', templet: '#Week', sort: true}
                , {field: 'ClassCode', title: '上课时间', templet: '#ClassCode'}
                , {field: 'Credit', title: '学分', minWidth: 50}
                , {field: 'Introduction', title: '简介', Width: 300},
                , {fixed: 'right', title: '操作', toolbar: '#Choose', width: 90}
            ]]
            , page: true
            , limit: 1
        });

        //监听工具条
        table.on('tool(Course)', function (obj) {
            var data = obj.data.id;
            console.log(data)
            if (obj.event === 'Choose') {
                layer.confirm('确认选择这门课嘛?', function (index) {
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url: "../Course?action=setChooseCourse",
                        data: "UserId=" + $('#userId').val() + "&CourseId=" + data + "&YearSemester=" + obj.data.YearSemester + "&Week=" + obj.data.Week,
                        success: function (result) {
                            if (result)
                                layer.msg("选课成功!");
                            else
                                layer.msg("选课失败!");
                        }
                    })
                    layer.close(index);
                });
            }
        });
    });
</script>
</body>
</html>