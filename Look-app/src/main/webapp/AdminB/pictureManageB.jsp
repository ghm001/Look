<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/15
  Time: 22:38
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
    <link rel="shortcut icon" href="../img/favicon.png">
    <title>CoreUI - Open Source Bootstrap Admin Template</title>
    <!-- Icons -->
    <link href="../../css/font-awesome.min.css" rel="stylesheet">
    <link href="../../css/simple-line-icons.css" rel="stylesheet">

    <%--Highcharts的引用--%>
    <link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
    <!-- Main styles for this application -->
    <link href="../../css/style.css" rel="stylesheet">
    <%--这是一条分割线------------------------------------------------------------------------------------%>
    <%--<!-- Bootstrap and necessary plugins -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>--%>
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
    <%--因为下插饼图加的js引用--%>
    <script src="https://img.hcharts.cn/highcharts/modules/data.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/drilldown.js"></script>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden" onload="CreateHighcharts('Month');" style="min-width: 975px">
<header class="app-header navbar">
    <ul class="nav navbar-nav ml-auto">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle nav-link" data-toggle="dropdown" href="#" role="button"
               aria-haspopup="true" aria-expanded="false">
                <img src="../img/avatars/6.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                <span>admin</span>
            </a>
        </li>
    </ul>
</header>

<div class="app-body">
    <div class="sidebar">
        <nav class="sidebar-nav">
            <ul class="nav">
                <li class="nav-title">
                    功能列表
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="registerB.jsp">图片管理<span
                            class="badge badge-info">NEW</span></a>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="../usersB.jsp">志愿者管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="treeB.jsp">标签树结构<span
                            class="badge badge-info">NEW</span></a>
                </li>
                <li class="divider"></li>
                <li class="nav-title">
                    Extras
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#">团队介绍</a>
                </li>
            </ul>
        </nav>
    </div>

    <!-- Main content -->
    <main class="main">
        <!-- Breadcrumb -->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">管理员</li>
            <li class="breadcrumb-item active">B级管理员</li>
        </ol>
        <div class="container-fluid">
            <div class="animated fadeIn">
                <div class="row">
                    <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='upload/uploadB.jsp'">
                        <div class="card card-inverse card-primary">
                            <div class="card-block pb-0">
                                <h4 class="mb-0">图片上传</h4>
                                <p>Members online</p>
                            </div>
                            <div class="chart-wrapper px-1" style="height:70px;">
                                <canvas id="card-chart1" class="chart" height="70"></canvas>
                            </div>
                        </div>
                    </div>
                    <!--/.col-->
                    <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='initializeB.jsp' ">
                        <div class="card card-inverse card-info">
                            <div class="card-block pb-0">
                                <h4 class="mb-0">初始化库</h4>
                                <p>Members online</p>
                            </div>
                            <div class="chart-wrapper px-1" style="height:70px;">
                                <canvas id="card-chart2" class="chart" height="70"></canvas>
                            </div>
                        </div>
                    </div>
                    <!--/.col-->
                    <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='pushB.jsp' ">
                        <div class="card card-inverse card-warning">
                            <div class="card-block pb-0">
                                <h4 class="mb-0">推送库</h4>
                                <p>Members online</p>
                            </div>
                            <div class="chart-wrapper" style="height:70px;">
                                <canvas id="card-chart3" class="chart" height="70"></canvas>
                            </div>
                        </div>
                    </div>
                    <!--/.col-->
                    <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='widgetsB.jsp' ">
                        <div class="card card-inverse card-danger">
                            <div class="card-block pb-0">
                                <h4 class="mb-0">完成库</h4>
                                <p>Members online</p>
                            </div>
                            <div class="px-1" style="height:70px;">
                            </div>
                        </div>
                    </div>
                    <!--/.col-->
                </div>
                <!--/.row-->
                <div class="card">
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
                                        <label class="btn btn-outline-secondary active" id="label1">
                                            <input type="radio" name="options" id="option1"
                                                   onclick="CreateHighcharts('Day');">Day
                                        </label>
                                        <label class="btn btn-outline-secondary" id="label2">
                                            <input type="radio" name="options" id="option2"
                                                   onclick="CreateHighcharts('Month');">Month
                                        </label>
                                        <label class="btn btn-outline-secondary" id="label3">
                                            <input type="radio" name="options" id="option3"
                                                   onclick="CreateHighcharts('Year');">Year
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <!--/.col-->
                        </div>
                        <!--/.row-->
                        <!--Highcharts折线图-->
                        <div id="MyHighcharts" style="min-width:250px;height:400px"></div>
                        <!--Highcharts初始化图表-->
                        <script>
                            function CreateHighcharts(time) {
                                var a = "btn btn-outline-secondary active";
                                var b = "btn btn-outline-secondary";
                                var elementA = document.getElementById('label1');
                                var elementB = document.getElementById("label2");
                                var elementC = document.getElementById("label3");
                                if (time == 'Day') {
                                    elementA.className = a;
                                    elementB.className = b;
                                    elementC.className = b;
                                    chart = new Highcharts.Chart('MyHighcharts', {
                                        title: {
                                            text: '不同图片库的增加数量',
                                            x: -20
                                        },
                                        subtitle: {
                                            text: '数据来源: 老马识图团队',
                                            x: -20
                                        },
                                        xAxis: {
                                            categories: ['2点', '4点', '6点', '8点', '10点', '12点', '14点', '16点', '18点', '20点', '22点', '24点']
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
                                            name: '图片上传',
                                            data: [0, 0, 0, 0, 0, 0, 160, 0, 80, 0, 0, 0]
                                        }, {
                                            name: '初始库',
                                            data: [0, 80, 19, 13, 10, 20, 8, 21, 01, 11, 6, 25]
                                        }, {
                                            name: '推送库',
                                            data: [90, 6, 97, 90, 21, 15, 86, 19, 41, 90, 39, 10]
                                        }, {
                                            name: '完成库',
                                            data: [10, 80, 3, 4, 115, 157, 171, 6, 0, 0, 66, 43]
                                        }]
                                    });
                                } else if (time == 'Month') {
                                    elementA.className = b;
                                    elementB.className = a;
                                    elementC.className = b;
                                    var chart = new Highcharts.Chart('MyHighcharts', {
                                        title: {
                                            text: '不同图片库的增加数量',
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
                                            name: '图片上传',
                                            data: [12, 10, 50, 10, 0, 0, 10, 110, 200, 30, 20, 10, 50, 10, 0,
                                                0, 10, 110, 170, 200, 0, 78, 34, 22, 11, 16, 34, 55, 13, 14]
                                        }, {
                                            name: '初始库',
                                            data: [0, 80, 19, 11, 170, 200, 28, 0, 20, 154, 86, 25, 3, 6, 78,
                                                99, 34, 55, 56, 45, 88, 90, 23, 16, 19, 14, 9, 3, 10, 9]
                                        }, {
                                            name: '推送库',
                                            data: [90, 0, 0, 80, 15, 10, 16, 19, 14, 9, 3, 10, 40, 77, 1,
                                                0, 57, 23, 2, 13, 10, 489, 11, 12, 0, 78, 34, 22, 11, 40]
                                        }, {
                                            name: '完成库',
                                            data: [10, 80, 93, 489, 11, 12, 10, 156, 12, 40, 66, 83, 15, 19, 14,
                                                9, 90, 154, 86, 25, 3, 6, 78, 99, 34, 55, 76, 94, 39, 72]
                                        }]
                                    });
                                } else if (time == 'Year') {
                                    elementA.className = b;
                                    elementB.className = b;
                                    elementC.className = a;
                                    var chart = new Highcharts.Chart('MyHighcharts', {
                                        title: {
                                            text: '不同图片库的增加数量',
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
                                            name: '图片上传',
                                            data: [120, 110, 21, 30, 1, 500, 1200, 1000, 800, 183, 139, 96]
                                        }, {
                                            name: '初始库',
                                            data: [0, 80, 119, 113, 1700, 2200, 248, 241, 201, 11, 806, 25]
                                        }, {
                                            name: '推送库',
                                            data: [900, 6, 35, 840, 135, 170, 186, 179, 141, 90, 39, 10]
                                        }, {
                                            name: '完成库',
                                            data: [1000, 800, 963, 489, 1159, 1572, 1710, 1656, 1412, 400, 606, 483]
                                        }]
                                    });
                                }
                            }
                        </script>
                    </div>
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
                                    text: '所有库中图片在总图片中所占比'
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
                                            enabled: false
                                        },
                                        showInLegend: true
                                    }
                                },
                                series: [{
                                    type: 'pie',
                                    name: '库中图片所占比',
                                    data: [
                                        ['完成库', 45.0],
                                        ['推送库', 26.8],
                                        {
                                            name: '初始化库',
                                            y: 28.2,
                                            sliced: true,
                                            selected: true
                                        }
                                    ]
                                }]
                            });
                        });
                    </script>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>
