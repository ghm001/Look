<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/15
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" style="font-size: 16px">
<head>
    <meta charset="utf-8">

    <%--下面这两条是CoreUI的--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
    <%--下面这两条是Highcharts的--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword"
          content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,jQuery,CSS,HTML,RWD,Dashboard">
    <link rel="shortcut icon" href="img/favicon.png">
    <title>CoreUI - Open Source Bootstrap Admin Template</title>
    <%--bootStrap--%>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">

    <%--Highcharts的引用--%>
    <link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">
    <%--这是一条分割线------------------------------------------------------------------------------------%>
    <%--<!-- Bootstrap and necessary plugins -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>--%>
    <%--这个是更换了的jQuery--%>
    <%--<script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>--%>
    <%--<script src="bower_components/tether/dist/js/tether.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/pace/pace.min.js"></script>
    <!-- Plugins and scripts required by all views -->
    <script src="bower_components/chart.js/dist/Chart.min.js"></script>--%>
    <!-- GenesisUI main scripts -->
    <%--<script src="js/app.js"></script>--%>
    <!-- Plugins and scripts required by this views -->
    <!-- Custom scripts required by this view -->
    <%--<script src="js/views/main.js"></script>--%>
    <!--Highcharts引用的js-->
    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
    <%--因为饼图加的js引用--%>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>

    <style>
        td {
            width: 50%;
            height: 30px;
        }

        td.left {
            text-align: center;
        }

        td.right {
            text-align: left;
        }

        td.middle {
            text-align: center;
        }

        td {
            font-family: Kreon;
            font-size: 100%;
        }

        input.inputText {
            border-bottom: 1px solid black !important;
            background: #FFFFFF;
            font-family: '微软雅黑 Regular', '微软雅黑', '宋体';
        }
        input.output{

        }

        .modal-backdrop.fade {
            opacity: 0.5 !important;
        }
    </style>
</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden" onload="CreateHighcharts('Month');"
      style="min-width: 975px">
<header class="app-header navbar">
    <ul class="nav navbar-nav hidden-md-down">
        <li class="nav-item"></li>
        <li class="nav-item">
            <img src="img/house.jpg" style="height: 3em;width: 5em;">
        </li>
        <li class="nav-item"></li>
        <li class="nav-item">
            <a class="nav-link navbar-toggler sidebar-toggler" href="#">☰</a>
        </li>
        <li class="nav-item">
            <a class="nav-link navbar-toggler sidebar-toggler" href="#">设置</a>
        </li>
    </ul>
    <ul class="nav navbar-nav ml-auto">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle nav-link" data-toggle="dropdown" href="personCenter.jsp" role="button"
               aria-haspopup="true" aria-expanded="false">
                <img src="img/avatars/6.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                <span>admin</span>
            </a>
        </li>
    </ul>
</header>
<div class="app-body">
    <div class="sidebar">
        <nav class="sidebar-nav">
            <ul class="nav" style="border-radius: 0px">
                <li class="nav-title">
                    功能列表
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="pictureManage.jsp">图片管理</a>
                </li>
                <li class="nav-item" style="background-color: #20a8d8">
                    <a class="nav-link" href="users.jsp">志愿者管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="tree.jsp">标签树结构</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="exception.jsp">异常图片管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="widgetsPreview.jsp">完成化标签导出</a>
                </li>
                <li class="divider"></li>
                <li class="nav-title">
                    Extras
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">团队介绍</a>
                </li>
            </ul>
        </nav>
    </div>
    <!-- Main content -->
    <main class="main">
        <!-- Breadcrumb -->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">管理员</li>
            <li class="breadcrumb-item active">A级管理员</li>
        </ol>
        <div class="container-fluid"><%--设置左右边距，分别为15px--%>
            <div class="breadcrumb">
                <div class="container" style="text-align: center;">
                    <a href="users.jsp"><span class="glyphicon glyphicon-share-alt" style="float: right;">返回</span></a>
                    <div style="width: 10em;height: 10em;text-align: center;margin-left: 450px">
                        <img src="http://obs.myhwclouds.com/app.test/phototest/%E5%A4%B4%E5%83%8F6.jpg" style="width: 8em;height: 8em;" class="img-rounded">
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        登录密码
                    </div>
                    <div class="col-sm-8" style="">
                        llkkjj555
                    </div>
                    <div class="col-sm-2" style="">
                        <button class="btn btn-link">

                        </button>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        手机号
                    </div>
                    <div id="change0div" class="col-sm-8" style="">
                        13847333838
                    </div>
                    <div class="col-sm-2" style="">
                        <button id="change0" class="btn btn-link" data-toggle="modal" data-target="#myModal" onclick="anniu(this)">
                            修改
                        </button>
                        <%--bootstrap模态框--%>
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog" style="transform: translate(0, 0);">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4>请输入你需要修改的内容</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="float: right">&times;</button>
                                    </div>
                                    <div class="modal-body" style="color: #000000">
                                        <input id="change" class="inputText" type="text" style="border: 1px solid;border-color: #FFFFFF">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                        <button type="button" class="btn btn-primary btn-default" data-dismiss="modal" onclick="tiaojiao()">提交更改</button>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal -->
                        </div>
                        <script>
                            var middle;
                            function anniu(e){
                                middle = e;
                            }
                            function tiaojiao(){
                                var a = middle.id;
                                var b = $("#change").val();
                                if(a == "change1"){
                                    $("#change1div").text(b);
                                }else if(a == "change3"){
                                    $("#change3div").text(b);
                                }

                                $("#change").val("");
                            }
                            </script>

                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        用户昵称
                    </div>
                    <div id="change1div" class="col-sm-8" style="">
                        李昊宇
                    </div>
                    <div class="col-sm-2" style="">
                        <button id="change1" class="btn btn-link" data-toggle="modal" data-target="#myModal" onclick="anniu(this)">
                            修改
                        </button>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        用户性别
                    </div>
                    <div id="change2div" class="col-sm-8" style="">
                        男
                    </div>
                    <div class="col-sm-2" style="">
                        <button id="change2" class="btn btn-link" data-toggle="modal" data-target="#myModal" onclick="anniu(this)">
                            修改
                        </button>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        用户年龄
                    </div>
                    <div id="change3div" class="col-sm-8" style="">
                        19
                    </div>
                    <div class="col-sm-2" style="">
                        <button id="change3" class="btn btn-link" data-toggle="modal" data-target="#myModal" onclick="anniu(this)">
                            修改
                        </button>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        登录状态
                    </div>
                    <div id="change4div" class="col-sm-8" style="">
                        在线
                    </div>
                    <div class="col-sm-2">
                        <button id="change4" class="btn btn-link" data-toggle="modal" data-target="#myModal" onclick="anniu(this)">
                            强制下线
                        </button>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        完成任务次数
                    </div>
                    <div id="change5div" class="col-sm-8" style="">
                        36
                    </div>
                    <div class="col-sm-2" style="">
                        <button id="change5" class="btn btn-link" data-toggle="modal" data-target="#myModal" onclick="anniu(this)">
                            修改
                        </button>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        积分
                    </div>
                    <div id="change6div" class="col-sm-8" style="">
                        100
                    </div>
                    <div class="col-sm-2" style="">
                        <button id="change6" class="btn btn-link" data-toggle="modal" data-target="#myModal" onclick="anniu(this)">
                            修改
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </main>
</div>
</body>
</html>
