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

<div class="layui-card layadmin-header">
    <div class="layui-breadcrumb" lay-filter="breadcrumb">
        <a lay-href="">主页</a>
        <a><cite>组件</cite></a>
        <a><cite>数据表格</cite></a>
        <a><cite>数据操作</cite></a>
    </div>
</div>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">数据操作</div>
                <div class="layui-card-body">
                    <input type="hidden" name="UserId" id="UserId" value=${sessionScope.user.userId}>
                    <table class="layui-hide" id="test-table-operate" lay-filter="test-table-operate"></table>
                    <script id="test-table-operate-barDemo" type="text/html">
                        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
            elem: '#test-table-operate'
            , url: '../Course?action=getAllChooseCourses&UserId=' + document.querySelector('#UserId').value
            , cols: [[
                {field: 'CourseName', width: 180, title: '课程名', sort: true}
                , {field: 'TeacherName', width: 80, title: '教师', sort: true}
                , {field: 'MaxSize', width: 110, title: '人数限制', sort: true}
                , {field: 'RoomName', width: 150, title: '地点'}
                , {field: 'Week', width: 100, title: '星期', templet: '#Week', sort: true}
                , {field: 'ClassCode', title: '上课时间', templet: '#ClassCode'}
                , {field: 'Introduction', title: '简介', minWidth: 100}
            ]]
            , page: true
            , limit: 1
        });

        //监听表格复选框选择
        table.on('checkbox(test-table-operate)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(test-table-operate)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            }
        });

        var $ = layui.$, active = {
            getCheckData: function () { //获取选中数据
                var checkStatus = table.checkStatus('test-table-operate')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            , getCheckLength: function () { //获取选中数目
                var checkStatus = table.checkStatus('test-table-operate')
                    , data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
            }
            , isAll: function () { //验证是否全选
                var checkStatus = table.checkStatus('test-table-operate');
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            }
        };

        $('.test-table-operate-btn .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });
</script>
</body>
</html>