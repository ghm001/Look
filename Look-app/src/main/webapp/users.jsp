<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/8
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
    <%--重写了默认的视口，并帮助加载与特定视口相关的样式（响应式布局）--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">--%>
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword"
          content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,jQuery,CSS,HTML,RWD,Dashboard">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>CoreUI - Open Source Bootstrap Admin Template</title>

    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">

    <%--这个是更换了的jQuery--%>
    <script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>

    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>

    <style>
        .th1{
            width: 140px;
            text-align: center;
        }
        .modal-backdrop.fade {
            opacity: 0.5 !important;
        }
        </style>

</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden" onload="CreateHighcharts('Month');" style="min-width: 975px">
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
        <div class="container-fluid">
            <div class="animated fadeIn">

                <div id="userPageOne" class="row" style="display:block">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <i class="fa fa-align-justify"></i> Combined All Table
                            </div>
                            <div class="card-block">
                                <table class="table table-bordered table-striped table-condensed">
                                    <thead>
                                    <tr>
                                        <th>用户名</th>
                                        <th>完成任务次数</th>
                                        <th>兴趣/专业</th>
                                        <th>积分</th>
                                        <th class="th1">如果修改请点击</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>慕容小小</td>
                                        <td>20</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>矿产</option>
                                                <option>矿产品</option>
                                                <option>自然风景</option>
                                                <option>植物</option>
                                                <option>动物</option>
                                            </select>

                                            <script type="text/javascript">
                                                $(document).ready(function(){
                                                    $('.combobox').combobox();
                                                });
                                            </script>
                                        </td>
                                        <td>200</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn01" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>杰克 陈</td>
                                        <td>8</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>电气机械及器材</option>
                                                <option>通信行业</option>
                                                <option>烟草制品</option>
                                            </select>
                                        </td>
                                        <td>80</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn02" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>hello keke</td>
                                        <td>18</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>农业</option>
                                                <option>林业</option>
                                                <option>畜牧业</option>
                                                <option>自然风景</option>
                                                <option>动物</option>
                                                <option>动物制品</option>
                                            </select>
                                        </td>
                                        <td>180</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn03" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>胖子吃货</td>
                                        <td>22</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>食品</option>
                                                <option>食品副产</option>
                                                <option>饮料等</option>
                                                <option>仪器行业</option>
                                            </select>
                                        </td>
                                        <td>220</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn04" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>李昊宇</td>
                                        <td>66</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>食品</option>
                                                <option>食品副产</option>
                                                <option>饮料等</option>
                                                <option>仪器行业</option>
                                            </select>
                                        </td>
                                        <td>660</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn05" class="btn btn-danger" onclick="location='usersAdd.jsp'">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>风清扬</td>
                                        <td>17</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>非金属矿物制品</option>
                                                <option>化工业</option>
                                                <option>化学原料及化学制品</option>
                                                <option>资源处理</option>
                                            </select>
                                        </td>
                                        <td>170</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn06" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>巫师</td>
                                        <td>22</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>交通运输设备</option>
                                                <option>生活场景</option>
                                                <option>动物</option>
                                                <option>自然风景</option>
                                            </select>
                                        </td>
                                        <td>220</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn07" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <nav>
                                    <ul class="pagination">
                                        <li class="page-item active">
                                            <a class="page-link" href="#" onclick="pageOne()">1</a>
                                        </li>
                                        <li class="page-item"><a class="page-link" href="#" onclick="pageTwo()">2</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <!--/.col-->
                </div>
                <!--/.row-->
                <div id="userPageTwo" class="row" style="display:none">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <i class="fa fa-align-justify"></i> Combined All Table
                            </div>
                            <div class="card-block">
                                <table class="table table-bordered table-striped table-condensed">
                                    <thead>
                                    <tr>
                                        <th>用户名</th>
                                        <th>完成任务次数</th>
                                        <th>兴趣/专业</th>
                                        <th>积分</th>
                                        <th class="th1">如果修改请点击</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>鳄鱼</td>
                                        <td>13</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>医药</option>
                                                <option>橡胶制品</option>
                                                <option>自然风景</option>
                                                <option>动物</option>
                                            </select>

                                            <script type="text/javascript">
                                                $(document).ready(function(){
                                                    $('.combobox').combobox();
                                                });
                                            </script>
                                        </td>
                                        <td>130</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn11" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>忧伤的木偶</td>
                                        <td>30</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>仪器行业</option>
                                                <option>专用设备</option>
                                                <option>文教体育用品</option>
                                                <option>资源处理</option>
                                                <option>生活场景</option>
                                            </select>
                                        </td>
                                        <td>300</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn12" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>富强民主</td>
                                        <td>11</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>动物</option>
                                                <option>动物制品</option>
                                                <option>日常用品</option>
                                                <option>动物制品</option>
                                                <option>纸及纸制品</option>
                                                <option>记录媒介</option>
                                            </select>
                                        </td>
                                        <td>110</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn13" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>放我出去吖</td>
                                        <td>23</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>化工业</option>
                                                <option>化学原料及化学制品</option>
                                                <option>医药</option>
                                                <option>金属制品</option>
                                                <option>有色金属</option>
                                                <option>非金属矿</option>
                                            </select>
                                        </td>
                                        <td>230</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn14" class="btn btn-danger">修改</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>呵呵呵</td>
                                        <td>14</td>
                                        <td>
                                            <select class="combobox" style="width: 170px">
                                                <option>资源处理</option>
                                                <option>渔业</option>
                                                <option>烟草制品</option>
                                                <option>橡胶制品</option>
                                                <option>塑料制品</option>
                                            </select>
                                        </td>
                                        <td>140</td>
                                        <td>
                                            <button id="gaiUsersBtn15" class="btn btn-danger" onclick="">修改</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>

                                <nav>
                                    <ul class="pagination">
                                        <li class="page-item active" id="liOne">
                                            <a class="page-link" href="#" onclick="pageOne()">1</a>
                                        </li>
                                        <li class="page-item" id="liTwo"><a class="page-link" href="#" onclick="pageTwo()">2</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <!--/.col-->
                </div>
                <!--/.row-->
                <script>
                    var e = document.getElementById("liOne");
                    var f = document.getElementById("liTwo");

                    var a = $("#userPageOne");
                    var b = $("#userPageTwo");

                    var c = "page-item active";
                    var d = "page-item";
                    function pageOne() {
                        e.className = "page-item active";
                        f.className = "page-item";
                        a.css('display','block');
                        b.css('display','none');
                    }
                    function pageTwo() {
                        e.className = "page-item";
                        f.className = "page-item active";
                        a.css('display','none');
                        b.css('display','block');
                    }

                    function change(){

                    }
                </script>
            </div>
        </div>
        <!-- /.conainer-fluid -->
        <div class="container-fluid">
            <div class="animated fadeIn">
                <div class="card">
                    <div class="card-block">
                        <div class="row">
                            <div class="col-sm-5">
                                <h4 class="card-title mb-0">用户人数增加</h4>
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
                                    $('#HighchartsLineUser').highcharts({
                                        chart: {
                                            zoomType: 'xy'
                                        },
                                        title: {
                                            text: '6月用户增加和总数变化图表'
                                        },
                                        subtitle: {
                                            text: '数据来源: 老马识图团队'
                                        },
                                        xAxis: [{
                                            categories: ['1号', '2号', '3号', '4号', '5号', '6号', '7号', '8号', '9号', '10号', '11号', '12号', '13号', '14号', '15号', '16号', '17号', '18号',
                                                '19号', '20号', '21号', '22号', '23号', '24号', '25号', '26号', '27号', '28号', '29号', '30号'],
                                            crosshair: true
                                        }],
                                        yAxis: [{ // Primary yAxis
                                            labels: {
                                                format: '{value}人',
                                                style: {
                                                    color: Highcharts.getOptions().colors[2]
                                                }
                                            },
                                            title: {
                                                text: '人数',
                                                style: {
                                                    color: Highcharts.getOptions().colors[2]
                                                }
                                            },
                                            opposite: true
                                        }, { // Secondary yAxis
                                            gridLineWidth: 0,
                                            title: {
                                                text: '人数',
                                                style: {
                                                    color: Highcharts.getOptions().colors[0]
                                                }
                                            },
                                            labels: {
                                                format: '{value} 人',
                                                style: {
                                                    color: Highcharts.getOptions().colors[0]
                                                }
                                            }
                                        }],
                                        tooltip: {
                                            shared: true
                                        },
                                        legend: {
                                            layout: 'vertical',
                                            align: 'left',
                                            x: 80,
                                            verticalAlign: 'top',
                                            y: 55,
                                            floating: true,
                                            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                                        },
                                        series: [{
                                            name: '人数变化',
                                            type: 'column',
                                            yAxis: 1,
                                            data: [-49, 30, 85, -20, 100, 10, -20, 47, 55, 72, 95, 42, -14, 30, 85,
                                                -50, 40, 55, -3, 18, 40, 72, 95, 42,-1, 12, 41, -4, 33, 12, 56, 31, 8, 4, 78, 10],
                                            tooltip: {
                                                valueSuffix: ' 人'
                                            }
                                        }, {
                                            name: '总人数',
                                            type: 'spline',
                                            data: [301, 331, 416, 396, 496, 506, 486, 533, 588, 660, 755, 797, 783, 813, 898,
                                                848, 888, 943, 940, 958, 998, 1070, 1165, 1207, 1206, 1218, 1259, 1255, 1288, 1300, 1356, 1387, 1395, 1399, 1477, 1487],
                                            tooltip: {valueSuffix: ' 人'
                                            }
                                        }]
                                    });
                                } else if (time == 'Year') {
                                    elementB.className = b;
                                    elementC.className = a;
                                    $('#HighchartsLineUser').highcharts({
                                        chart: {
                                            zoomType: 'xy'
                                        },
                                        title: {
                                            text: '用户增加和总数变化图表'
                                        },
                                        subtitle: {
                                            text: '数据来源: 老马识图团队'
                                        },
                                        xAxis: [{
                                            categories: ['一月', '二月', '三月', '四月', '五月', '六月',
                                                '七月', '八月', '九月', '十月', '十一月', '十二月'],
                                            crosshair: true
                                        }],
                                        yAxis: [{ // Primary yAxis
                                            labels: {
                                                format: '{value}人',
                                                style: {
                                                    color: Highcharts.getOptions().colors[2]
                                                }
                                            },
                                            title: {
                                                text: '人数',
                                                style: {
                                                    color: Highcharts.getOptions().colors[2]
                                                }
                                            },
                                            opposite: true
                                        }, { // Secondary yAxis
                                            gridLineWidth: 0,
                                            title: {
                                                text: '人数',
                                                style: {
                                                    color: Highcharts.getOptions().colors[0]
                                                }
                                            },
                                            labels: {
                                                format: '{value} 人',
                                                style: {
                                                    color: Highcharts.getOptions().colors[0]
                                                }
                                            }
                                        }],
                                        tooltip: {
                                            shared: true
                                        },
                                        legend: {
                                            layout: 'vertical',
                                            align: 'left',
                                            x: 80,
                                            verticalAlign: 'top',
                                            y: 55,
                                            floating: true,
                                            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                                        },
                                        series: [{
                                            name: '人数变化',
                                            type: 'column',
                                            yAxis: 1,
                                            data: [156, 623, 412, -31, 126, 859, 452, 7523, 13225, 8998, 23568, 33652],
                                            tooltip: {
                                                valueSuffix: ' 人'
                                            }
                                        }, {
                                            name: '总人数',
                                            type: 'spline',
                                            data: [156, 779, 1196, 1165, 1291, 2150, 2602, 10125, 23350, 32348, 55916, 89568],
                                            tooltip: {
                                                valueSuffix: ' 人'
                                            }
                                        }]
                                    });
                                }
                            }
                        </script>
                    </div>
                </div>
            </div>
        </div>

    </main>
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
