<%--
  Created by IntelliJ IDEA.
  User: SeRein
  Date: 2021/6/1
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta content="webkit" name="renderer">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
    <link href="../static/layuiadmin/layui/css/layui.css" media="all" rel="stylesheet">
    <link href="../static/layuiadmin/layui/css/public.css" media="all" rel="stylesheet">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索学生</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form action="" class="layui-form layui-form-pane">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">学生学号</label>
                            <div class="layui-input-inline">
                                <input autocomplete="off" class="layui-input" name="userId" type="text"
                                       lay-verify="userId">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">学生姓名</label>
                            <div class="layui-input-inline">
                                <input autocomplete="off" class="layui-input" name="userName" type="text"
                                       lay-verify="userName">
                            </div>
                        </div>
                        <!--隐藏域，存放classId-->
                        <input type="hidden" name="classId" id="classId" value="${sessionScope.myClass.id}">

                        <div class="layui-inline">
                            <button class="layui-btn layui-btn-primary" lay-filter="data-search-btn" lay-submit
                                    type="submit"><i class="layui-icon"></i> 搜 索
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <script id="toolbarDemo" type="text/html">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加</button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除</button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" id="currentTableFilter" lay-filter="currentTableFilter"></table>

        <script id="currentTableBar" type="text/html">
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

    </div>
</div>
<script charset="utf-8" src="../static/layuiadmin/layui/layui.js"></script>
<script src="../static/js/jquery-3.6.0.min.js"></script>
<script>
    layui.use(['form', 'table'], function () {
        let $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        let classId = $("#classId").val(); //获取隐藏域中的值
        table.render({
            elem: '#currentTableId',
            url: '../CounselorServlet?action=getClassUser&classId=' + classId,  //!!!!表格数据接口
            toolbar: '#toolbarDemo',
            /*defaultToolbar: ['filter', 'exports', 'print', {
              title: '提示',
              layEvent: 'LAYTABLE_TIPS',
              icon: 'layui-icon-tips'
            }],*/
            //!!!!表头
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'userId', width: 200, title: '学号', sort: true, event: 'userId'},
                {field: 'userName', width: 200, title: '用户名', edit: 'text', event: 'userName', sort: true},
                {field: 'sex', width: 200, title: '性别', edit: 'text', event: 'sex'},
                {field: 'age', width: 200, title: '年龄', edit: 'text', event: 'age', sort: true},
                {field: 'password', width: 200, title: '密码', edit: 'text', event: 'password'},
                {title: '操作', Width: 200, toolbar: '#currentTableBar'}
            ]],
            /*id:'userInfo', //执行表格重载时使用*/
            /* limits: [10, 15, 20, 25, 50, 100], //每页显示条数*/
            /* limit: 10,    //每页条数的选择项*/
            page: false/*true*/, //开启分页
            /*skin: 'line'*/
        });


        /**
         *！！！！搜索事件
         */
        form.on('submit(data-search-btn)', function (data) {
            let target = data.field;  //搜索框内容
            let userId = target.userId;
            let userName = target.userName;

            let reg = /^[0-9]*$/;
            if (!reg.test(userId)) {
                layer.msg("学号应为十位纯数字");
            } else {
                console.log(target);
                console.log(classId);
                $.getJSON("../CounselorServlet?action=searchUser&classId=" + classId, target, function (data) {
                    console.log("搜索完成");
                    console.log(data);
                    //表格重载
                    table.reload('currentTableId', {
                        url: '../CounselorServlet?action=searchUser&classId='
                            + classId + "&userId=" + userId + "&userName=" + userName
                        //数据接口
                        , where: {} //设定异步数据接口的额外参数
                        //,height: 300
                    });
                    layer.msg("已搜索出" + data.data.length + "个用户");
                    /*//执行搜索重载
                    table.reload('currentTableId', {
                      page: {
                        curr: 1
                      }
                      , where: {
                        searchParams: result
                      }
                    }, 'data');*/
                });
            }
            return false;
        });


        /**
         * toolbar监听事件
         * 监听复选框事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                let index = layer.open({
                    title: '添加用户',
                    type: 2,
                    shade: 0.2,
                    shadeClose: true,
                    area: ['40%', '70%'],//宽:高
                    content: 'addStudent.jsp',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            }
            /**
             * 监听复选框的删除操作
             * */
            else if (obj.event === 'delete') {

                console.log("触发删除操作");
                let checkStatus = table.checkStatus('currentTableId')//!!!获取复选框选中的数据
                    , data = checkStatus.data;
                let a = [];
                for (let i = 0; i < data.length; i++) {
                    a[i] = data[i].userId;
                }
                $.getJSON("../CounselorServlet?action=delUserList&a=" + a, function (data) {
                    console.log("成功删除");
                    console.log(data.result);
                    table.reload('currentTableId', {
                        /***!!!!!!!数据表格的重载!!!!!！****/
                        url: '../CounselorServlet?action=getClassUser' //数据接口
                        , where: {} //设定异步数据接口的额外参数
                        //,height: 300
                    });
                    if (data.result !== 0) {
                        layer.alert("已成功删除" + data.result + "个用户");
                    }
                });
            }
        });

        /**
         *复选框事件监听
         **/
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj.data)
        });


        /**
         * 表格末尾删除事件监听
         */
        table.on('tool(currentTableFilter)', function (obj) {
            let data = obj.data;
            /*！！删除事件!!!!*/
            if (obj.event === 'delete') {
                console.log("删除事件触发");
                layer.confirm('真的删除行么', function (index) {
                    let userId = data.userId;
                    console.log("要删除用户的userId=" + userId);
                    $.getJSON("../CounselorServlet?action=delUser&userId=" + userId, function (data) {
                        if (data.result === 1) {
                            /*layer.open({   //删除成功后弹出成功信息
                              title: '删除成功'
                              ,content: userId+'删除成功'
                              ,offset:'auto'
                            });*/
                            layer.alert("删除成功");
                        }
                    });
                    obj.del();
                    layer.close(index);
                });
            }
        });


        /**监听单元格数据事件**/
        table.on('tool(currentTableFilter)', function (obj) {
            let data = obj.data;
            console.log(data[obj.event]);
            console.log(obj.event);
            let oldData = data[obj.event];   //获取单元格的值
            /**
             * ！！！！监听单元格编辑
             */
            table.on('edit(currentTableFilter)', function (obj) {
                console.log("单元编辑事件触发");
                let value = obj.value //得到修改后的值
                    , data = obj.data //得到所在行所有键值
                    , field = obj.field; //得到字段
                console.log(field);
                let bl = true;
                /**判断修改是否符合规范**/
                if (field === "userName") {
                    let reg = /^[\u4e00-\u9fa5]{2,4}$/;
                    if (!reg.test(value)) {
                        layer.msg("名字只能是2~4个中文");
                        bl = false;
                    }
                }
                if (field === "password") {
                    console.log(value);
                    let reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z\\W]{6,18}$/;//6——18英语数组组合
                    if (!reg.test(value)) {
                        layer.msg("密码必须为6~18位数字和字母的组合");
                        bl = false;
                    }
                }

                if (field === "sex") {
                    console.log(value);
                    let reg = /[/^男$|^女&/]/;//6——18英语数组组合
                    if (!reg.test(value)) {
                        layer.msg("性别只能为[男]或[女]");
                        bl = false;
                    }
                }

                if (field === "age") {
                    console.log(value);
                    let reg = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;//6-120
                    if (!reg.test(value)) {
                        layer.msg("年龄介于0~120");
                        bl = false;
                    }
                }

                if (bl) {
                    $.getJSON("../CounselorServlet?action=upDateTable&field=" + field + "&value=" + value + "&userId=" + data.userId, function (data) {
                        layer.msg("修改成功");
                    });
                }
            });
            obj.update({
                userName: oldData
            })
        });


    });
</script>

</body>
</html>
