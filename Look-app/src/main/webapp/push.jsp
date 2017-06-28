<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/13
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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
    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">

    <%--Highcharts的引用--%>
    <link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">
    <%--这是一条分割线------------------------------------------------------------------------------------%>
    <!-- Bootstrap and necessary plugins -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <%--这个是更换了的jQuery--%>
    <script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
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
        .p-picture {
            color: #f0f0f0;
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
                <li class="nav-item" style="background-color: #20a8d8">
                    <a class="nav-link" href="pictureManage.jsp">图片管理</a>
                </li>
                <li class="nav-item">
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
            <li class="breadcrumb-item active">推送库</li>
        </ol>
        <div class="container-fluid"><%--设置左右边距，分别为15px--%>
            <div class="row">
                <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='upload/upload.jsp'">
                    <div class="card card-inverse card-primary">
                        <div class="card-block pb-0">
                            <h4 class="mb-0">图片上传</h4>
                            <p class="p-picture">上传图片点击这里</p>
                        </div>
                        <div class="chart-wrapper px-1" style="height:70px;">
                            <canvas id="card-chart1" class="chart" height="70"></canvas>
                        </div>
                    </div>
                </div>
                <!--/.col-->
                <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='initialize.jsp' ">
                    <div class="card card-inverse card-info">
                        <div class="card-block pb-0">
                            <h4 class="mb-0">初始化库</h4>
                            <p class="p-picture">已上传但没有初始标签的图片库</p>
                        </div>
                        <div class="chart-wrapper px-1" style="height:70px;">
                            <canvas id="card-chart2" class="chart" height="70"></canvas>
                        </div>
                    </div>
                </div>
                <!--/.col-->
                <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='push.jsp' ">
                    <div class="card card-inverse card-warning" style="box-shadow:0px 0px 10px 0px #000">
                        <div class="card-block pb-0">
                            <h4 class="mb-0">推送库</h4>
                            <p class="p-picture">将根据用户的选择进行推送的图片库</p>
                        </div>
                        <div class="chart-wrapper" style="height:70px;">
                            <canvas id="card-chart3" class="chart" height="70"></canvas>
                        </div>
                    </div>
                </div>
                <!--/.col-->
                <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='widgets.jsp' ">
                    <div class="card card-inverse card-danger">
                        <div class="card-block pb-0">
                            <h4 class="mb-0">老马识图团队</h4>
                            <p class="p-picture">标签已经完成化的图片库</p>
                        </div>
                        <div class="px-1" style="height:70px;">
                        </div>
                    </div>
                </div>
                <!--/.col-->
            </div>
            <!--/.row-->
        </div>
        <div class="container-fluid"><%--设置左右边距，分别为15px--%>
            <div class="animated fadeIn"><%--lhy--%>
                <div class="card"><%--设置边框颜色和大小--%>
                    <div class="card-block">
                        <div class="row">
                            <div class="col-sm-5">
                                <h4 class="card-title mb-0">Change</h4>
                                <div class="small text-muted">这里显示当前年份与时间</div>
                            </div>
                            <!--/.col-->
                            <div class="col-sm-7 hidden-sm-down">
                                <button type="button" class="btn btn-primary float-right"><i
                                        class="icon-cloud-download"></i>
                                </button>
                                <div class="btn-toolbar float-right" role="toolbar"
                                     aria-label="Toolbar with button groups">
                                    <div class="btn-group mr-1" data-toggle="buttons" aria-label="First group">
                                        <label class="btn btn-outline-secondary" id="label2">
                                            <input type="radio" name="options" id="option2"
                                                   onclick="CreateHighcharts('Month');">月
                                        </label>
                                        <label class="btn btn-outline-secondary" id="label3">
                                            <input type="radio" name="options" id="option3"
                                                   onclick="CreateHighcharts('Year');">年
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <!--/.col-->
                        </div>
                        <!--Highcharts折线图-->
                        <div id="HighchartsLineUser" style="min-width:250px;height:400px"></div>
                        <!--Highcharts初始化图表-->
                        <script>
                            function CreateHighcharts(time) {
                                var a = "btn btn-outline-secondary active";
                                var b = "btn btn-outline-secondary";
                                var elementB = document.getElementById("label2");
                                var elementC = document.getElementById("label3");
                                if (time == 'Month') {
                                    elementB.className = a;
                                    elementC.className = b;
                                    var chart = new Highcharts.Chart('HighchartsLineUser', {
                                        title: {
                                            text: '推送图库的图库情况',
                                            x: -20
                                        },
                                        subtitle: {
                                            text: '数据来源: 老马识图团队',
                                            x: -20
                                        },
                                        xAxis: {
                                            categories: ['1号', '2号', '3号', '4号', '5号', '6号', '7号', '8号', '9号', '10号', '11号', '12号', '13号', '14号', '15号', '16号', '17号', '18号',
                                                '19号', '20号', '21号', '22号', '23号', '24号', '25号', '26号', '27号', '28号', '29号', '30号']
                                        },
                                        yAxis: {
                                            title: {
                                                text: '数量 (张)'
                                            },
                                            plotLines: [{
                                                value: 0,
                                                width: 1,
                                                color: '#808080'
                                            }]
                                        },
                                        tooltip: {
                                            valueSuffix: '张'
                                        },
                                        legend: {
                                            layout: 'vertical',
                                            align: 'right',
                                            verticalAlign: 'middle',
                                            borderWidth: 0
                                        },
                                        series: [{
                                            name: '图片增加',
                                            data: [40, 5, 90, 0, 10, 15, 100, 15, 12, 65, 60, 40, 50, 85, 35,
                                                20, 120, 230, 100, 10, 20, 30, 80, 68, 78, 98, 50, 10, 50, 60]
                                        }]
                                    });
                                } else if (time == 'Year') {
                                    elementB.className = b;
                                    elementC.className = a;
                                    var chart = new Highcharts.Chart('HighchartsLineUser', {
                                        title: {
                                            text: '推送图库的图库情况',
                                            x: -20
                                        },
                                        subtitle: {
                                            text: '数据来源: 老马识图团队',
                                            x: -20
                                        },
                                        xAxis: {
                                            categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
                                        },
                                        yAxis: {
                                            title: {
                                                text: '数量 (张)'
                                            },
                                            plotLines: [{
                                                value: 0,
                                                width: 1,
                                                color: '#808080'
                                            }]
                                        },
                                        tooltip: {
                                            valueSuffix: '张'
                                        },
                                        legend: {
                                            layout: 'vertical',
                                            align: 'right',
                                            verticalAlign: 'middle',
                                            borderWidth: 0
                                        },
                                        series: [{
                                            name: '图片增加',
                                            data: [100, 500, 50, 80, 77, 66, 34, 120, 210, 22, 41, 65]
                                        }]
                                    });
                                }
                            }
                        </script>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="animated fadeIn">
                <div class="card">
                    <div class="card-block">
                        <div id="container" style="min-width:400px;height:400px"></div>

                        <script>
                            $(function () {
                                $('#container').highcharts({
                                    chart: {
                                        plotBackgroundColor: null,
                                        plotBorderWidth: null,
                                        plotShadow: false
                                    },
                                    title: {
                                        text: '推送仓库图片增加数的各个管理员占比'
                                    },
                                    tooltip: {
                                        headerFormat: '{series.name}<br>',
                                        pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
                                    },
                                    plotOptions: {
                                        pie: {
                                            allowPointSelect: true,
                                            cursor: 'pointer',
                                            dataLabels: {
                                                enabled: true,
                                                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                                style: {
                                                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                                }
                                            }
                                        }
                                    },
                                    series: [{
                                        type: 'pie',
                                        name: '推送仓库图片增加数的各公司占比',
                                        data: [
                                            ['管理员1', 45.0],
                                            ['管理员2', 26.8],
                                            {
                                                name: '管理员3',
                                                y: 12.8,
                                                sliced: true,
                                                selected: true
                                            },
                                            ['管理员4', 15.4]
                                        ]
                                    }]
                                });
                            });
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>
