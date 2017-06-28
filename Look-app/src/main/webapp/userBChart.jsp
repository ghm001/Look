<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">--%>
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,jQuery,CSS,HTML,RWD,Dashboard">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>CoreUI - Open Source Bootstrap Admin Template</title>

    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">

    <script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/data.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/drilldown.js"></script>
    <%--Highcharts需要引入的js--%>
    <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>

</head>

<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden" onload="CreateHighcharts('Month');">
<%
    String id = request.getParameter("id");
%>
<header class="app-header navbar">
    <ul class="nav navbar-nav hidden-md-down">
        <li class="nav-item">
            <a class="nav-link navbar-toggler sidebar-toggler" href="#">☰</a>
        </li>
        <li class="nav-item px-1">
            <select id="my-menu" style="border: 0px">
                <option value="JavaScript">图片标签异常</option>
                <option value="C++">图片迭代异常</option>
                <option value="Ruby">图片用户报错</option>
            </select>
            <script>
                $('#my-menu').fancyspinbox();
            </script>
        </li>
        <li class="nav-item px-1">
            <select id="my-menu2" style="border: 0px" onchange="a()">
                <option id="initializeOp">初始化库图片预览</option>
                <option id="pushOp">推送库图片预览</option>
                <option id="widgetsOp">完成库图片预览</option>
            </select>
            <script>
                function a(){
                    if($(":selected","#my-menu2").attr("id") == "widgetsOp"){
                        window.location.href="widgetsPreview.jsp";
                    }
                }
                $('#my-menu2').fancyspinbox();
            </script>
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
            <ul class="nav">
                <li class="nav-title">
                    功能列表
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="pictureManage.jsp">图片管理</a>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="users.jsp">志愿者管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="tree.jsp">标签树结构</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="usersB.jsp">B级管理员管理</a>
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
            <li class="breadcrumb-item active">A级管理员</li>
        </ol>
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
                <div id="MyHighchartsUserBCha" style="min-width:250px;height:400px"></div>
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
                            var chart = new Highcharts.Chart('MyHighchartsUserBCha', {
                                title: {
                                    text: '<%=id%>图片上传和完成库的图片数量',
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
                                    data: [12, 10, 80, 93, 230, 11, 12, 10, 20, 10, 57, 23, 2,
                                        13, 10, 220, 11, 12, 170, 200, 40, 78, 34, 22, 11, 16, 34, 55, 13, 14]
                                }, {
                                    name: '初始库',
                                    data: [0, 3, 6, 78, 20, 34, 55, 76, 80, 154, 55, 25, 3, 30, 78,
                                        99, 78, 34, 55, 80, 40, 90, 23, 16, 42, 30, 20, 3, 10, 9]
                                },]
                            });
                        } else if (time == 'Year') {
                            elementB.className = b;
                            elementC.className = a;
                            var chart = new Highcharts.Chart('MyHighchartsUserBCha', {
                                title: {
                                    text: '图片上传和完成库的图片数量',
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
                                    data: [120, 1000, 800, 963, 489, 1159, 1200, 1000, 800, 183, 139, 96]
                                }, {
                                    name: '初始库',
                                    data: [0, 80, 119, 113, 1700, 900, 6, 35, 840, 135, 170, 25]
                                }, ]
                            });
                        }
                    }
                </script>
            </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <i class="fa fa-align-justify"></i> Combined All Table
                            </div>
                            <div class="card-block">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>B级管理员</th>
                                        <th>注册时间</th>
                                        <th>用户等级</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>lhy</td>
                                        <td>2017/01/01</td>
                                        <td>
                                            <span class="badge badge-success">VIP</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>lmy</td>
                                        <td>2017/02/01</td>
                                        <td>
                                            <span class="badge badge-default">VIP</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>ghm</td>
                                        <td>2017/02/01</td>
                                        <td>
                                            <span class="badge badge-default">VIP</span>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <nav>
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="#">Prev</a>
                                        </li>
                                        <li class="page-item active">
                                            <a class="page-link" href="#">1</a>
                                        </li>
                                        <li class="page-item"><a class="page-link" href="#">2</a>
                                        </li>
                                        <li class="page-item"><a class="page-link" href="#">3</a>
                                        </li>
                                        <li class="page-item"><a class="page-link" href="#">4</a>
                                        </li>
                                        <li class="page-item"><a class="page-link" href="#">Next</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <!--/.col-->
                </div>
                <!--/.row-->
            </div>
        </div>
        <!-- /.conainer-fluid -->
    </main>

    <aside class="aside-menu">
        <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#timeline" role="tab"><i class="icon-list"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#messages" role="tab"><i class="icon-speech"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#settings" role="tab"><i class="icon-settings"></i></a>
            </li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div class="tab-pane active" id="timeline" role="tabpanel">
                <div class="callout m-0 py-h text-muted text-center bg-faded text-uppercase">
                    <small><b>Today</b>
                    </small>
                </div>
                <hr class="transparent mx-1 my-0">
                <div class="callout callout-warning m-0 py-1">
                    <div class="avatar float-right">
                        <img src="img/avatars/7.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                    </div>
                    <div>Meeting with
                        <strong>Lucas</strong>
                    </div>
                    <small class="text-muted mr-1"><i class="icon-calendar"></i>&nbsp; 1 - 3pm</small>
                    <small class="text-muted"><i class="icon-location-pin"></i>&nbsp; Palo Alto, CA</small>
                </div>
                <hr class="mx-1 my-0">
                <div class="callout callout-info m-0 py-1">
                    <div class="avatar float-right">
                        <img src="img/avatars/4.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                    </div>
                    <div>Skype with
                        <strong>Megan</strong>
                    </div>
                    <small class="text-muted mr-1"><i class="icon-calendar"></i>&nbsp; 4 - 5pm</small>
                    <small class="text-muted"><i class="icon-social-skype"></i>&nbsp; On-line</small>
                </div>
                <hr class="transparent mx-1 my-0">
                <div class="callout m-0 py-h text-muted text-center bg-faded text-uppercase">
                    <small><b>Tomorrow</b>
                    </small>
                </div>
                <hr class="transparent mx-1 my-0">
                <div class="callout callout-danger m-0 py-1">
                    <div>New UI Project -
                        <strong>deadline</strong>
                    </div>
                    <small class="text-muted mr-1"><i class="icon-calendar"></i>&nbsp; 10 - 11pm</small>
                    <small class="text-muted"><i class="icon-home"></i>&nbsp; creativeLabs HQ</small>
                    <div class="avatars-stack mt-h">
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/2.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/3.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/4.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/5.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/6.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                    </div>
                </div>
                <hr class="mx-1 my-0">
                <div class="callout callout-success m-0 py-1">
                    <div>
                        <strong>#10 Startups.Garden</strong>Meetup</div>
                    <small class="text-muted mr-1"><i class="icon-calendar"></i>&nbsp; 1 - 3pm</small>
                    <small class="text-muted"><i class="icon-location-pin"></i>&nbsp; Palo Alto, CA</small>
                </div>
                <hr class="mx-1 my-0">
                <div class="callout callout-primary m-0 py-1">
                    <div>
                        <strong>Team meeting</strong>
                    </div>
                    <small class="text-muted mr-1"><i class="icon-calendar"></i>&nbsp; 4 - 6pm</small>
                    <small class="text-muted"><i class="icon-home"></i>&nbsp; creativeLabs HQ</small>
                    <div class="avatars-stack mt-h">
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/2.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/3.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/4.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/5.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/6.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/7.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                        <div class="avatar avatar-xs">
                            <img src="img/avatars/8.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                        </div>
                    </div>
                </div>
                <hr class="mx-1 my-0">
            </div>
            <div class="tab-pane p-1" id="messages" role="tabpanel">
                <div class="message">
                    <div class="py-1 pb-3 mr-1 float-left">
                        <div class="avatar">
                            <img src="img/avatars/7.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                            <span class="avatar-status badge-success"></span>
                        </div>
                    </div>
                    <div>
                        <small class="text-muted">Lukasz Holeczek</small>
                        <small class="text-muted float-right mt-q">1:52 PM</small>
                    </div>
                    <div class="text-truncate font-weight-bold">Lorem ipsum dolor sit amet</div>
                    <small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt...</small>
                </div>
                <hr>
                <div class="message">
                    <div class="py-1 pb-3 mr-1 float-left">
                        <div class="avatar">
                            <img src="img/avatars/7.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                            <span class="avatar-status badge-success"></span>
                        </div>
                    </div>
                    <div>
                        <small class="text-muted">Lukasz Holeczek</small>
                        <small class="text-muted float-right mt-q">1:52 PM</small>
                    </div>
                    <div class="text-truncate font-weight-bold">Lorem ipsum dolor sit amet</div>
                    <small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt...</small>
                </div>
                <hr>
                <div class="message">
                    <div class="py-1 pb-3 mr-1 float-left">
                        <div class="avatar">
                            <img src="img/avatars/7.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                            <span class="avatar-status badge-success"></span>
                        </div>
                    </div>
                    <div>
                        <small class="text-muted">Lukasz Holeczek</small>
                        <small class="text-muted float-right mt-q">1:52 PM</small>
                    </div>
                    <div class="text-truncate font-weight-bold">Lorem ipsum dolor sit amet</div>
                    <small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt...</small>
                </div>
                <hr>
                <div class="message">
                    <div class="py-1 pb-3 mr-1 float-left">
                        <div class="avatar">
                            <img src="img/avatars/7.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                            <span class="avatar-status badge-success"></span>
                        </div>
                    </div>
                    <div>
                        <small class="text-muted">Lukasz Holeczek</small>
                        <small class="text-muted float-right mt-q">1:52 PM</small>
                    </div>
                    <div class="text-truncate font-weight-bold">Lorem ipsum dolor sit amet</div>
                    <small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt...</small>
                </div>
                <hr>
                <div class="message">
                    <div class="py-1 pb-3 mr-1 float-left">
                        <div class="avatar">
                            <img src="img/avatars/7.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                            <span class="avatar-status badge-success"></span>
                        </div>
                    </div>
                    <div>
                        <small class="text-muted">Lukasz Holeczek</small>
                        <small class="text-muted float-right mt-q">1:52 PM</small>
                    </div>
                    <div class="text-truncate font-weight-bold">Lorem ipsum dolor sit amet</div>
                    <small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt...</small>
                </div>
            </div>
            <div class="tab-pane p-1" id="settings" role="tabpanel">
                <h6>Settings</h6>

                <div class="aside-options">
                    <div class="clearfix mt-2">
                        <small><b>Option 1</b>
                        </small>
                        <label class="switch switch-text switch-pill switch-success switch-sm float-right">
                            <input type="checkbox" class="switch-input" checked="">
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                    </div>
                    <div>
                        <small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</small>
                    </div>
                </div>

                <div class="aside-options">
                    <div class="clearfix mt-1">
                        <small><b>Option 2</b>
                        </small>
                        <label class="switch switch-text switch-pill switch-success switch-sm float-right">
                            <input type="checkbox" class="switch-input">
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                    </div>
                    <div>
                        <small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</small>
                    </div>
                </div>

                <div class="aside-options">
                    <div class="clearfix mt-1">
                        <small><b>Option 3</b>
                        </small>
                        <label class="switch switch-text switch-pill switch-success switch-sm float-right">
                            <input type="checkbox" class="switch-input">
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                    </div>
                </div>

                <div class="aside-options">
                    <div class="clearfix mt-1">
                        <small><b>Option 4</b>
                        </small>
                        <label class="switch switch-text switch-pill switch-success switch-sm float-right">
                            <input type="checkbox" class="switch-input" checked="">
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                    </div>
                </div>

                <hr>
                <h6>System Utilization</h6>

                <div class="text-uppercase mb-q mt-2">
                    <small><b>CPU Usage</b>
                    </small>
                </div>
                <div class="progress progress-xs">
                    <div class="progress-bar bg-info" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <small class="text-muted">348 Processes. 1/4 Cores.</small>

                <div class="text-uppercase mb-q mt-h">
                    <small><b>Memory Usage</b>
                    </small>
                </div>
                <div class="progress progress-xs">
                    <div class="progress-bar bg-warning" role="progressbar" style="width: 70%" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <small class="text-muted">11444GB/16384MB</small>

                <div class="text-uppercase mb-q mt-h">
                    <small><b>SSD 1 Usage</b>
                    </small>
                </div>
                <div class="progress progress-xs">
                    <div class="progress-bar bg-danger" role="progressbar" style="width: 95%" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <small class="text-muted">243GB/256GB</small>

                <div class="text-uppercase mb-q mt-h">
                    <small><b>SSD 2 Usage</b>
                    </small>
                </div>
                <div class="progress progress-xs">
                    <div class="progress-bar bg-success" role="progressbar" style="width: 10%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <small class="text-muted">25GB/256GB</small>
            </div>
        </div>
    </aside>

</div>
<!-- Bootstrap and necessary plugins -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/tether/dist/js/tether.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="bower_components/pace/pace.min.js"></script>

<!-- Plugins and scripts required by all views -->
<script src="bower_components/chart.js/dist/Chart.min.js"></script>

<!-- GenesisUI main scripts -->
<script src="js/app.js"></script>

</body>

</html>