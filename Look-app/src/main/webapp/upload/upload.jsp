<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/11
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
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
    <link href="../css/font-awesome.min.css" rel="stylesheet">
    <link href="../css/simple-line-icons.css" rel="stylesheet">
    <%--Highcharts的引用--%>
    <link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
    <%--这是一条分割线------------------------------------------------------------------------------------%>
    <!-- Bootstrap and necessary plugins -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/webuploader.css"/>
    <link rel="stylesheet" type="text/css" href="../css/styleWebup.css"/>
    <!-- Main styles for this application -->
    <link href="../css/style.css" rel="stylesheet">
    <style>
        .progress {
            display: none;
            width: 0px;
        }

        .p-picture {
            color: #f0f0f0;
        }
    </style>
</head>
<body onload="" class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden" style="min-width: 975px">
<header class="app-header navbar">
    <ul class="nav navbar-nav hidden-md-down">
        <li class="nav-item"></li>
        <li class="nav-item">
            <img src="../img/house.jpg" style="height: 3em;width: 5em;">
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
            <a class="nav-link dropdown-toggle nav-link" data-toggle="dropdown" href="../personCenter.jsp" role="button"
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
            <ul class="nav" style="border-radius: 0px">
                <li class="nav-title">
                    功能列表
                </li>
                <li class="nav-item" style="background-color: #20a8d8">
                    <a class="nav-link" href="../pictureManage.jsp">图片管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../users.jsp">志愿者管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../tree.jsp">标签树结构</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../exception.jsp">异常图片管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../widgetsPreview.jsp">完成化标签导出</a>
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
        <ol class="breadcrumb">
            <li class="breadcrumb-item">管理员</li>
            <li class="breadcrumb-item active">A级管理员</li>
            <li class="breadcrumb-item active">图片上传</li>
        </ol>
        <div class="container-fluid"><%--设置左右边距，分别为15px--%>
            <div class="row">
                <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='upload.jsp'">
                    <div class="card card-inverse card-primary" style="box-shadow:0px 0px 10px 0px #000">
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
                <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='../initialize.jsp' ">
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
                <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='../push.jsp' ">
                    <div class="card card-inverse card-warning">
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
                <div class="col-sm-6 col-lg-3" onclick="javascript:location.href='../widgets.jsp' ">
                    <div class="card card-inverse card-danger">
                        <div class="card-block pb-0">
                            <h4 class="mb-0">完成库</h4>
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
        <%--<script>
            /*$(function() {
                $progress = $statusBar.find('.progress').hide();
            }*/
            </script>--%>
        <div class="container-fluid"><%--设置左右边距，分别为15px--%>
            <div id="container">
                <!--头部，相册选择和格式选择-->
                <div id="uploader">
                    <div class="queueList">
                        <div id="dndArea" class="placeholder">
                            <div id="filePicker"></div>
                        </div>
                    </div>
                    <div class="statusBar" style="display:none;">
                        <div class="progress">
                            <span class="text">0%</span>
                            <span class="percentage"></span>
                        </div>
                        <div class="info"></div>
                        <div class="btns">
                            <div id="filePicker2"></div>
                            <div class="uploadBtn">开始上传</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="../js/jquery.js"></script>
        <script src="../js/webuploader.js"></script>
        <script src="../uploader/js/upload.js"></script>
        <script type="text/javascript">
        </script>
    </main>
</div>
</body>
</html>
