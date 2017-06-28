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

        input {
            border: 0px;
            background: #FFFFFF;
            font-family: '微软雅黑 Regular', '微软雅黑', '宋体';
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
        </ol>
        <div class="container-fluid"><%--设置左右边距，分别为15px--%>
            <div class="breadcrumb">
                <div class="container">
                    <div style="float:left;width: 10em;height: 10em;text-align: center">
                        <img src="img/noavatar_middle.gif" style="width: 8em;height: 8em;" class="img-rounded">
                    </div>
                    <div style="float:left">
                        <table>
                            <tr>
                                <br/>
                                <td><h5><input type="text" value="您好， 李昊宇"></h5></td>
                            </tr>
                            <tr>
                                <td>手机号： 13838384438</td>
                            </tr>
                            <tr>
                                <td>注册时间： 2017.4.15</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        登录密码
                    </div>
                    <div class="col-sm-8" style="">
                        安全性高的密码可以使账号更安全，建议您定期更换密码，<br>
                        设置一个包含字母，符号或数字中至少两项且长度超过6位的密码。
                    </div>
                    <div class="col-sm-2" style="">
                        <span class="glyphicon glyphicon-ok-circle" style="color: #44B333">已设置</span>
                        <button class="btn btn-link">
                            修改
                        </button>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        邮箱绑定
                    </div>
                    <div class="col-sm-8" style="">
                        绑定邮箱可以用于安全验证、找回密码等重要操作
                    </div>
                    <div class="col-sm-2" style="">
                        <span class="glyphicon glyphicon-ok-circle" style="color: #44B333">已设置</span>
                        <button class="btn btn-link">
                            修改
                        </button>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        真实姓名
                    </div>
                    <div class="col-sm-8" style="">
                        真实姓名可以帮助我们把你的信息与公司信息相匹配
                    </div>
                    <div class="col-sm-2" style="">
                        <span class="glyphicon glyphicon-ok-circle" style="color: #44B333">已验证</span>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        所属公司
                    </div>
                    <div class="col-sm-8" style="">
                        你所属的公司或团队
                    </div>
                    <div class="col-sm-2" style="">
                        <span class="glyphicon glyphicon-ok-circle" style="color: #44B333">已通过验证</span>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        用户权限
                    </div>
                    <div class="col-sm-8" style="">
                        你现在所属的权限，权限越高，可以使用的功能越多
                    </div>
                    <div class="col-sm-2" style="">
                        <span class="glyphicon glyphicon-lock">已设置</span>
                        <button class="btn btn-link">
                            更多权限
                        </button>
                    </div>
                </div>
                <hr>
                <div class="container"><%--现在没加响应式，一定要加--%>
                    <div class="col-sm-2" style="">
                        <h6>我的余额 ： 2000元</h6>
                        <br>
                        <h7>含奖励（200元）</h7>
                    </div>
                    <div class="col-sm-8" style="">
                        充值的余额和赠送的代金券总额
                    </div>
                    <div class="col-sm-2" style="">
                        <br/>
                        <button class="btn btn-warning">
                            <span class="glyphicon glyphicon-usd">充值</span>
                        </button>
                    </div>
                </div>
                <%--<div id="gengduo" style="display: none">
                    <form style="width: 100%">

                        &lt;%&ndash;<script>
                            var middle = 1;
                            function modifiInfo() {
                                var gaibianButton = document.getElementById("gaibianButton");
                                if (middle % 2 == 1) {
                                    gaibianButton.value = "确认更改"
                                    var mailbox = document.getElementById("mailbox");
                                    var trueName = document.getElementById("trueName");
                                    var company = document.getElementById("company");

//                                    mailbox.style.border = "1px";
//                                    trueName.style.border = "1px";
//                                    company.style.border = "1px";

                                    mailbox.removeAttribute("readonly");
                                    trueName.removeAttribute("readonly");
                                    company.removeAttribute("readonly");

                                    middle = middle + 1;
                                } else if (middle % 2 == 0) {
                                    gaibianButton.value = "更改个人资料";

                                    var mailbox = document.getElementById("mailbox");
                                    var trueName = document.getElementById("trueName");
                                    var company = document.getElementById("company");

                                    mailbox.setAttribute("readonly", "true");
                                    trueName.setAttribute("readonly", "true");
                                    company.setAttribute("readonly", "true");

                                    middle = middle + 1;
                                }
                            }
                        </script>&ndash;%&gt;
                    </form>
                </div>--%>
                <%--<script>
                    //更多信息的点击事件
                    var middle2 = 0;
                    function PullDownInfo() {
                        var gengduo = document.getElementById("gengduo");
                        if (middle2 % 2 == 0) {
                            middle2 = middle2 + 1;
                            gengduo.style.display = 'block';
                        } else if (middle2 % 2 == 1) {
                            middle2 = middle2 + 1;
                            gengduo.style.display = 'none';
                        }
                    }
                </script>--%>
            </div>
        </div>
        <%--<div class="container-fluid">&lt;%&ndash;设置左右边距，分别为15px&ndash;%&gt;
            <div class="breadcrumb" style="background-color:#E4E5E6">
                <h6>我的余额 ：
                    <h7>含奖励（200元）</h7>
                </h6>
                <br>
                <h3 style="float:left">2000元
                    <h4 style="float:right">
                        <button type="button" value="充值" class="btn btn-sm "
                                onclick="javascript:location.href='#'"
                                style="float:right;background:#E41E2B">充值
                        </button>
                    </h4>
                </h3>
            </div>
        </div>--%>
        <div class="container-fluid"><%--设置左右边距，分别为15px--%>
            <div class="breadcrumb">
                <!--Highcharts折线图-->
                <div id="MyHighcharts2" style="min-width:250px;height:400px"></div>
                <!--Highcharts初始化图表-->
                <script>
                    function CreateHighcharts(time) {
                        var chart = new Highcharts.Chart('MyHighcharts2', {
                            title: {
                                text: '充值情况',
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
                                    text: '元（人民币）'
                                },
                                plotLines: [{
                                    value: 0,
                                    width: 1,
                                    color: '#808080'
                                }]
                            },
                            tooltip: {
                                valueSuffix: '元'
                            },
                            legend: {
                                layout: 'vertical',
                                align: 'right',
                                verticalAlign: 'middle',
                                borderWidth: 0
                            },
                            series: [{
                                name: '充值费用',
                                data: [0, 200, 30, 0, 50, 0, 10, 0, 0, 100, 300, 0]
                            }]
                        });
                    }
                </script>
            </div>
        </div>
    </main>
</div>
</body>
</html>
