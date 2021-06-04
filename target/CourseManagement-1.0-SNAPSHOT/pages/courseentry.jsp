<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>课程录入</title>
    <link href="../static/layuiadmin/layui/css/layui.css" rel="stylesheet">
    <script src="../static/js/jquery-3.6.0.min.js"></script>
</head>

<body>
<script src="../static/layuiadmin/layui/layui.js"></script>
<div style="height: 20px;"></div>
<div class="layui-fluid layui-main">
    <div class="layui-row">
        <div class="layui-col-xs8 layui-col-sm8 layui-col-md8">
            <form action="" class="layui-form" lay-filter="form">
                <input name="Teacher" type="hidden" id="Teacher" value=${sessionScope.user.userId}>
                <div class="layui-form-item">
                    <label class="layui-form-label">课程名称</label>
                    <div class="layui-input-block">
                        <input autocomplete="off" class="layui-input" lay-verify="required"
                               name="CourseName" placeholder="请输入课程名称" required type="text">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">人数</label>
                    <div class="layui-input-inline">
                        <input autocomplete="off" class="layui-input" id="MaxSize"
                               lay-verify="required" name="MaxSize" placeholder="请输入人数" required type="text">
                    </div>
                    <div class="layui-form-mid layui-word-aux" id="tips">注意:房间最大容量一定要大于课程最大人数</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">学分</label>
                    <div class="layui-input-inline">
                        <input autocomplete="off" class="layui-input" id="Credit"
                               lay-verify="required" name="Credit" placeholder="请输入学分" required type="text">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">学年</label>
                        <div class="layui-input-inline">
                            <input autocomplete="off" class="layui-input" id="Year" lay-verify="required"
                                   name="Year" placeholder="请输入学年" required type="text">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">学期</label>
                        <div class="layui-input-block">
                            <select lay-filter="Semester" lay-search lay-verify="required" name="Semester">
                                <option selected="selected" value="1">第一学期</option>
                                <option value="2">第二学期</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <div class="layui-form-item">
                            <label class="layui-form-label">星期</label>
                            <div class="layui-input-block">
                                <select id="Week" lay-filter="Week" lay-search lay-verify="required" name="Week">
                                    <option selected="selected" value="">请选择</option>
                                    <option value="1">星期一</option>
                                    <option value="2">星期二</option>
                                    <option value="3">星期三</option>
                                    <option value="4">星期四</option>
                                    <option value="5">星期五</option>
                                    <option value="6">星期六</option>
                                    <option value="7">星期七</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <div class="layui-form-item">
                            <label class="layui-form-label">教学楼</label>
                            <div class="layui-input-block">
                                <select id="location" lay-filter="location" lay-search lay-verify="required"
                                        name="location">
                                    <option selected="selected" value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-form-item">
                            <label class="layui-form-label">教室</label>
                            <div class="layui-input-block">
                                <select id="room" lay-filter="room" lay-search lay-verify="required" name="room">
                                    <option selected="selected" value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">课时</label>
                    <div class="layui-input-block" id="classCode" lay-filter="classCode">
                        <input disabled="disabled" name="" title="请选择学年、星期、学期、教室!" type="checkbox">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">是否是选修课</label>
                    <div class="layui-input-block">
                        <input lay-skin="switch" lay-verify="required" name="Choose" type="checkbox">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">课程简介</label>
                    <div class="layui-input-block">
                            <textarea class="layui-textarea" name="Introduction"
                                      placeholder="课程简介,请输入少于500字的文字简介"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" id="lay-submit" lay-filter="submit" lay-submit>立即提交</button>
                        <button class="layui-btn layui-btn-primary" type="reset">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script>
        layui.use(['layer', 'form'], function () {
                var layer = layui.layer
                    , form = layui.form;
                form.on('submit(submit)', function (data) {

                    console.log(data.field);
                    //表单提交
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url: "../Course?action=setCourse",
                        data: data.field,
                        success: function (result) {
                            layer.msg(result);
                        }
                    })
                    return false;
                });
                $(document).ready(function () {
                    //获取所有楼id
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url: "../Course?action=getAllLocation",
                        success: function (result) {
                            for (var index = 0; index < result.length; index++)
                                $("#location").append($("<option value=" + result[index].id + ">" + result[index].Title + "</option>"));
                            form.render('select', 'form');
                        }
                    })
                })
                form.on("select(location)", function () {
                    //获取楼id查人数
                    var value = $("#location").val();
                    $('#room').empty();
                    $('#room').append($("<option selected=\"selected\" value=\"\">请选择</option>"));
                    //异步请求
                    if (value.length > 0) {
                        $.ajax({
                            type: "POST",
                            url: "../Course?action=getRoomByLocationId",
                            dataType: "JSON",
                            async: true,
                            data: "location=" + value,
                            success: function (result) {
                                for (var index = 0; index < result.length; index++)
                                    $("#room").append($("<option value=" + result[index].id + ">" + result[index].Title + "</option>"));
                                form.render('select');
                            }
                        })
                    }
                })
                var MaxSizeTemp = -1;
                var RoomId = -1;
                form.on("select(room)", function (data) {
                    //获取房间id查最大值
                    if (data.value.length > 0) {
                        $.ajax({
                            type: "POST",
                            url: "../Course?action=getMaxSizeById",
                            dataType: "JSON",
                            async: true,
                            data: "roomId=" + data.value,
                            success: function (result) {
                                MaxSizeTemp = result;
                                RoomId = data.value;
                                check();
                            }
                        })
                    } else {
                        MaxSizeTemp = -1;
                    }
                });

            //检测键盘弹起事件
            window.addEventListener('keyup', function () {
                //对人数进行正则替换
                document.querySelector("#MaxSize").value = document.querySelector("#MaxSize").value.replace(/\D/g, '');
                //对学分进行正则替换
                document.querySelector("#Credit").value = document.querySelector("#Credit").value.replace(/\D/g, '');
                check();
            })

            var WeekTemp = -1;
            form.on("select(Week)", function (Week) {
                WeekTemp = Week.value;
                check();
            })
            var SemesterTemp = 1;
            form.on("select(Semester)", function (semester) {
                SemesterTemp = semester.value;
                check();
            })

            var arrstemRoom = [];
            var arrstemTeacher = [];
            var TeacherTimeTemp = [];

            //检测房间容量
            function check() {
                if (MaxSizeTemp !== -1 && document.querySelector('#MaxSize').value.length > 0)
                    if (MaxSizeTemp < $('#MaxSize').val()) {
                        alert("注意:房间最大容量一定要大于课程最大人数,当前房间最大容量为:" + MaxSizeTemp);
                    }

                if (document.querySelector("#Year").value.length > 0 && RoomId !== -1 && SemesterTemp > 0 && WeekTemp > 0) {
                    if (arrstemRoom[0] != document.querySelector("#Year").value || arrstemRoom[1] != RoomId || arrstemRoom[2] != SemesterTemp || arrstemRoom[3] != WeekTemp) {
                        arrstemRoom[0] = document.querySelector("#Year").value;
                        arrstemRoom[1] = RoomId;
                        arrstemRoom[2] = SemesterTemp;
                        arrstemRoom[3] = WeekTemp;

                        if (document.querySelector('#Year').value.length > 0 && SemesterTemp > 0 && WeekTemp > 0) {
                            if (arrstemTeacher[0] != document.querySelector('#Year').value.length || arrstemTeacher[1] != SemesterTemp || arrstemTeacher[2] != WeekTemp) {
                                arrstemTeacher[0] = document.querySelector('#Year').value.length;
                                arrstemTeacher[1] = SemesterTemp;
                                arrstemTeacher[2] = WeekTemp;
                                $.ajax({
                                    type: "POST",
                                    url: "../Course?action=getTimeByTeacherId",
                                    dataType: "JSON",
                                    async: true,
                                    data: "TeacherId=" + $('#Teacher').val() + "&Year=" + document.querySelector('#Year').value + "&Semester=" + SemesterTemp + "&Week=" + WeekTemp,
                                    success: function (result) {
                                        TeacherTimeTemp = result;
                                    }
                                })
                            }
                        }
                        $.ajax({
                            type: "POST",
                            url: "../Course?action=getRoomUseByTime",
                            dataType: "JSON",
                            async: true,
                            data: "RoomId=" + RoomId + "&Year=" + document.querySelector("#Year").value + "&Semester=" + SemesterTemp + "&Week=" + WeekTemp,

                            success: function (result) {
                                var list = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
                                result = TeacherTimeTemp.concat(result);
                                if (result.length !== 0) {
                                    for (var index = 0; index < result.length; index++) {
                                        for (var char = 0; char < 14; char++) {
                                            if (result[index][char] == "0")
                                                list[char] = 0;
                                        }
                                    }
                                    for (var index = 0; index <= 12; index++) {
                                        if (list[index] !== 0) list[index] = 1;
                                    }
                                    } else {
                                        var list = [];
                                        for (var index = 0; index <= 12; index++) {
                                            list[index] = 1;
                                        }
                                    }
                                    $('#classCode').empty();
                                    var flag = 0;
                                    for (var index = 1; index <= 12; index++) {
                                        if (list[index] == 1) {
                                            flag = 1;
                                            $('#classCode').append("<input name=" + index + " title=" + index + " type=\"checkbox\">");
                                        }
                                    }
                                    if (flag == 0)
                                        $('#classCode').append("<input disabled=\"disabled\" title=\"暂无可用教室!\" type=\"checkbox\">");
                                    form.render('checkbox');
                                    console.log(list);
                                }
                            })
                        }

                    }
                }
            }
        );

    </script>
</div>
</body>

</html>