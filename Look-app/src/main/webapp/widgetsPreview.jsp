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
    <title>完成库图片展示界面</title>
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
    <%--网页内容导出到word效果--%>
    <script src="http://www.jq22.com/demo/exportWord20161214/js/FileSaver.js "></script>
    <script src="http://www.jq22.com/demo/exportWord20161214/js/jquery.wordexport.js"></script>
    <%--bootstrap画廊--%>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" href="css/baguetteBox.min.css">
    <link rel="stylesheet" href="css/thumbnail-gallery.css">
    <style>
        .jq22-demo{ text-align: center; margin-top: 30px; }
        .jq22-demo a{ padding-left: 20px; padding-right: 20px; }
    </style>

    <style type="text/css">
        .myDiv {
            margin-bottom: 40px;
            min-height: 250px;
            background-color: #e4e5e6;
        }

        /*img {*/
            /*-webkit-border-radius: 0 !important;*/
            /*-moz-border-radius: 0 !important;*/
            /*border-radius: 0 !important;*/
        /*}*/

        p {
            font-size: 10px;
        }

        B {
            font-size: 10px;
        }

        .modal-backdrop.fade {
            opacity: 0.5 !important;
        }

        .myBtn {
            border-radius: 30px;
            margin-left: 30px;
        }
    </style>

</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden"
      style="min-width: 975px;">
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
                <li class="nav-item" style="background-color: #20a8d8">
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
        <ol class="breadcrumb" style="border-radius: 0px">
            <li class="breadcrumb-item">管理员</li>
            <li class="breadcrumb-item active">A级管理员</li>
            <li class="breadcrumb-item" style="float: right; ">
                <button class="word-export btn btn-success">导出当前标签</button>
                <div id="pagecontent" style="display: none">
                    [
                    " <p>
                    {"labels":["城堡","树木","草地","建筑"],"finish_time":"2017-5-21T1:36:54Z","picture_name":"picture0.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["城市","乡村","树木","天空"],"finish_time":"2017-5-21T7:6:58Z","picture_name":"picture1.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["城市","建筑","高楼"],"finish_time":"2017-5-21T16:32:55Z","picture_name":"picture2.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["天空","云朵","建筑","大海","树木","人群"],"finish_time":"2017-5-21T15:17:19Z","picture_name":"picture3.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["天空","街道","建筑","马路","天线"],"finish_time":"2017-5-21T18:38:9Z","picture_name":"picture4.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["建筑","城堡","中世纪"],"finish_time":"2017-5-21T1:19:39Z","picture_name":"picture5.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["建筑","水湾","树木"],"finish_time":"2017-5-21T17:10:19Z","picture_name":"picture6.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["建筑","道路","城市","天空"],"finish_time":"2017-5-21T19:11:30Z","picture_name":"picture7.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["房屋","河","城市"],"finish_time":"2017-5-21T20:7:1Z","picture_name":"picture8.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["摩天大楼","城市"],"finish_time":"2017-5-21T4:34:43Z","picture_name":"picture9.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["洛杉矶","市中心","音乐厅"],"finish_time":"2017-5-21T18:22:34Z","picture_name":"picture10.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["自由女神像"],"finish_time":"2017-5-21T1:11:9Z","picture_name":"picture11.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["大海","沙滩","远山","天空"],"finish_time":"2017-5-22T10:30:15Z","picture_name":"picture12.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["柏树","山","湖","天空","建筑"],"finish_time":"2017-5-22T15:16:48Z","picture_name":"picture13.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    " <p>
                    {"labels":["狗","海滩","海水","日落"],"finish_time":"2017-5-22T12:45:17Z","picture_name":"picture14.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["白云岩","高山","水","天空","树"],"finish_time":"2017-5-22T3:31:58Z","picture_name":"picture15.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["草地","树木","天空","建筑","大海"],"finish_time":"2017-5-22T9:2:18Z","picture_name":"picture16.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["高山","树木","建筑","草地","天空"],"finish_time":"2017-5-22T20:25:29Z","picture_name":"picture17.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["冰淇淋","草莓","勺子","奶油蛋糕"],"finish_time":"2017-5-23T19:18:18Z","picture_name":"picture18.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["樱桃","蛋糕","花","篮子","甜点","水果"],"finish_time":"2017-5-23T12:37:1Z","picture_name":"picture19.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["橙子","水杯","果盘","果汁"],"finish_time":"2017-5-23T17:12:36Z","picture_name":"picture20.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["草莓","蓝莓","橙子","猕猴桃","盘子"],"finish_time":"2017-5-23T9:27:10Z","picture_name":"picture21.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["香蕉","草地","小花"],"finish_time":"2017-5-23T6:31:9Z","picture_name":"picture22.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["香蕉","草莓","芒果","猕猴桃"],"finish_time":"2017-5-23T4:6:11Z","picture_name":"picture23.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["城堡","建筑","宫殿","天空"],"finish_time":"2017-5-23T12:11:9Z","picture_name":"picture24.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["城堡","德国","大海","树木","村庄"],"finish_time":"2017-5-23T14:58:31Z","picture_name":"picture25.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["城堡","风景","天空","大海"],"finish_time":"2017-5-23T4:32:21Z","picture_name":"picture26.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["天空","纪念碑","砂岩","云"],"finish_time":"2017-5-23T18:7:25Z","picture_name":"picture27.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["天空","风景","云","阿尔卑斯山"],"finish_time":"2017-5-23T4:57:49Z","picture_name":"picture28.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["山","湖水","晨曦","树林"],"finish_time":"2017-5-23T16:35:4Z","picture_name":"picture29.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["书","眼镜"],"finish_time":"2017-5-23T10:14:59Z","picture_name":"picture30.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["书"],"finish_time":"2017-5-23T8:56:9Z","picture_name":"picture31.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["书包"],"finish_time":"2017-5-23T10:26:17Z","picture_name":"picture32.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["书架","书"],"finish_time":"2017-5-23T20:47:6Z","picture_name":"picture33.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["放大镜","书"],"finish_time":"2017-5-23T20:35:10Z","picture_name":"picture34.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["计算器","书"],"finish_time":"2017-5-23T14:17:35Z","picture_name":"picture35.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["手机","桌子"],"finish_time":"2017-5-21T8:13:57Z","picture_name":"picture36.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["笔记本电脑","桌子","鼠标","手机"],"finish_time":"2017-5-21T14:28:10Z","picture_name":"picture37.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["笔记本电脑","椅子","眼睛","桌子"],"finish_time":"2017-5-21T14:28:25Z","picture_name":"picture38.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["笔记本电脑","水杯","桌子","手机"],"finish_time":"2017-5-21T8:19:3Z","picture_name":"picture39.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["笔记本电脑","计算机","树木","草坪"],"finish_time":"2017-5-21T12:13:26Z","picture_name":"picture40.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["键盘","鼠标","桌子"],"finish_time":"2017-5-21T16:48:5Z","picture_name":"picture41.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["猫","椅子","树木"],"finish_time":"2017-5-22T13:2:36Z","picture_name":"picture42.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["猫头鹰","树木"],"finish_time":"2017-5-22T6:59:5Z","picture_name":"picture43.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["猴子","哺乳动物"],"finish_time":"2017-5-22T8:26:4Z","picture_name":"picture44.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["老虎","树木"],"finish_time":"2017-5-22T16:35:34Z","picture_name":"picture45.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["老虎"],"finish_time":"2017-5-22T4:38:47Z","picture_name":"picture46.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["老鼠"],"finish_time":"2017-5-22T18:11:59Z","picture_name":"picture47.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["天空","云朵","船","树","湖水"],"finish_time":"2017-5-22T15:11:42Z","picture_name":"picture48.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["天空","人","栏杆","大海","建筑","城堡"],"finish_time":"2017-5-22T15:34:40Z","picture_name":"picture49.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["太阳","海滩","大海","落日","晚上"],"finish_time":"2017-5-22T23:26:23Z","picture_name":"picture50.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["岩石","天空","树木","湖水"],"finish_time":"2017-5-22T18:54:12Z","picture_name":"picture51.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["树","河水","汽车","天空","杂草"],"finish_time":"2017-5-22T14:11:42Z","picture_name":"picture52.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["树","海水","天空"],"finish_time":"2017-5-22T5:5:37Z","picture_name":"picture53.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["剪刀"],"finish_time":"2017-5-23T6:4:41Z","picture_name":"picture54.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["机器人","火星"],"finish_time":"2017-5-23T21:54:47Z","picture_name":"picture55.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["架构","钢厂","工厂","钢铁生产"],"finish_time":"2017-5-23T12:48:36Z","picture_name":"picture56.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["矿用挖掘机","天空","机器"],"finish_time":"2017-5-23T20:44:13Z","picture_name":"picture57.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["零件","轴承","金属"],"finish_time":"2017-5-23T7:46:18Z","picture_name":"picture58.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["驱动器","电机","机器"],"finish_time":"2017-5-23T19:23:59Z","picture_name":"picture59.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["人","灯","大厅","走道","商店"],"finish_time":"2017-5-24T1:40:10Z","picture_name":"picture60.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["保龄球","大厅","地板"],"finish_time":"2017-5-24T22:47:4Z","picture_name":"picture61.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["商场","灯","大厅","椅子","商店"],"finish_time":"2017-5-24T16:31:32Z","picture_name":"picture62.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["圣诞树","气球","商店","人"],"finish_time":"2017-5-24T9:10:47Z","picture_name":"picture63.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["大厅","商品","人","商店"],"finish_time":"2017-5-24T23:8:9Z","picture_name":"picture64.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["电梯","人","店铺","大厅"],"finish_time":"2017-5-24T12:52:36Z","picture_name":"picture65.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["书","眼镜"],"finish_time":"2017-5-21T9:53:49Z","picture_name":"picture66.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["书"],"finish_time":"2017-5-21T22:44:50Z","picture_name":"picture67.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["书包"],"finish_time":"2017-5-21T18:26:31Z","picture_name":"picture68.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["书架","书"],"finish_time":"2017-5-21T10:49:25Z","picture_name":"picture69.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["放大镜","书"],"finish_time":"2017-5-21T2:22:32Z","picture_name":"picture70.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["计算器","书"],"finish_time":"2017-5-21T4:45:2Z","picture_name":"picture71.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["手推车","香蕉","萝卜","草地","小花","葡萄"],"finish_time":"2017-5-21T1:34:27Z","picture_name":"picture72.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["果汁","蛋糕","杯子","碟子","桌子"],"finish_time":"2017-5-21T13:12:23Z","picture_name":"picture73.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["樱桃","木桌子","果盘"],"finish_time":"2017-5-21T17:8:34Z","picture_name":"picture74.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["花园","水果","苹果","篮筐"],"finish_time":"2017-5-21T1:18:20Z","picture_name":"picture75.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["葡萄"],"finish_time":"2017-5-21T20:1:30Z","picture_name":"picture76.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["蓝莓"],"finish_time":"2017-5-21T12:17:44Z","picture_name":"picture77.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["喷泉","维也纳","城堡","草地"],"finish_time":"2017-5-22T6:21:14Z","picture_name":"picture78.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["大瀑布","旅游景点","荒野","森林"],"finish_time":"2017-5-22T6:52:2Z","picture_name":"picture79.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["巨石阵","纪念碑"],"finish_time":"2017-5-22T10:40:16Z","picture_name":"picture80.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["帕台神庙","建筑","天空","云"],"finish_time":"2017-5-22T17:55:29Z","picture_name":"picture81.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["建筑","纪念碑","卡鲁城堡"],"finish_time":"2017-5-22T13:12:4Z","picture_name":"picture82.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["海滩","树木","大海","莱利湾"],"finish_time":"2017-5-22T1:8:26Z","picture_name":"picture83.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["弹簧鸟","花朵","树枝"],"finish_time":"2017-5-22T16:15:11Z","picture_name":"picture84.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["松鼠","桌子","植物"],"finish_time":"2017-5-22T22:51:19Z","picture_name":"picture85.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["狗","宠物"],"finish_time":"2017-5-22T5:36:21Z","picture_name":"picture86.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["狗"],"finish_time":"2017-5-22T15:19:7Z","picture_name":"picture87.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["蜜蜂","花朵"],"finish_time":"2017-5-22T12:37:20Z","picture_name":"picture88.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["鲜花","动物","松鼠"],"finish_time":"2017-5-22T21:5:59Z","picture_name":"picture89.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["火车","天空","夕阳"],"finish_time":"2017-5-24T23:4:4Z","picture_name":"picture90.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["火车","铁轨","建筑"],"finish_time":"2017-5-24T17:14:30Z","picture_name":"picture91.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["货船","海","天空","房屋"],"finish_time":"2017-5-24T22:32:25Z","picture_name":"picture92.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["跑车","路","栏杆"],"finish_time":"2017-5-24T11:12:20Z","picture_name":"picture93.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["路","山","云"],"finish_time":"2017-5-24T2:55:18Z","picture_name":"picture94.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["路","道路","树木","落叶"],"finish_time":"2017-5-24T20:15:19Z","picture_name":"picture95.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["山","树","建筑","水"],"finish_time":"2017-5-24T21:57:44Z","picture_name":"picture96.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["建筑","天空","海水","船"],"finish_time":"2017-5-24T2:46:40Z","picture_name":"picture97.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["建筑","树","山","天空"],"finish_time":"2017-5-24T23:23:56Z","picture_name":"picture98.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["桥","河","马路","建筑"],"finish_time":"2017-5-24T7:42:31Z","picture_name":"picture99.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["桥","海水","天空"],"finish_time":"2017-5-24T12:26:41Z","picture_name":"picture100.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["沙滩","大海","天空","人","高山"],"finish_time":"2017-5-24T21:38:55Z","picture_name":"picture101.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["枯树","天空"],"finish_time":"2017-5-26T4:8:19Z","picture_name":"picture102.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["树木","人","木桥","高山","天空","云朵"],"finish_time":"2017-5-26T6:3:10Z","picture_name":"picture103.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["植物","花朵"],"finish_time":"2017-5-26T2:49:13Z","picture_name":"picture104.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["植物"],"finish_time":"2017-5-26T4:3:46Z","picture_name":"picture105.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["罂粟","花朵","植物","天空"],"finish_time":"2017-5-26T4:17:20Z","picture_name":"picture106.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["花朵","蜜蜂"],"finish_time":"2017-5-26T21:30:7Z","picture_name":"picture107.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["草坪","小花","植物","小草"],"finish_time":"2017-5-26T2:47:29Z","picture_name":"picture108.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["菜花","树木","天空"],"finish_time":"2017-5-26T9:43:6Z","picture_name":"picture109.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["薰衣草","花朵","植物"],"finish_time":"2017-5-26T21:30:9Z","picture_name":"picture110.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["郁金香","鲜花","植物"],"finish_time":"2017-5-26T18:32:46Z","picture_name":"picture111.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    ",
                    " <p>
                    {"labels":["鲜花","紫色花朵","植物"],"finish_time":"2017-5-26T20:17:16Z","picture_name":"picture112.jpg","url":"http://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-25/鲜花-紫色花朵-植物.jpg"} </p>
                    "
                    ]
                </div>
                <script>
                    $(function () {
                        $(".word-export").click(function () {
                            $("#pagecontent").wordExport("fileName");
                            //fileName为导出的word文件的命名
                        });
                    });
                </script>
            </li>
        </ol>


        <div class="htmleaf-container">
            <div class="container gallery-container">
                <div class="tz-gallery">
                    <div class="row">
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="lightbox" href="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-20/城堡-树木-草地-建筑.jpg">
                                    <img src="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-20/城堡-树木-草地-建筑.jpg" alt="Park">
                                </a>
                                <div class="caption">
                                    <h3>已完成的标签：城堡 树木 草地 建筑</h3>
                                    <p>picture0.jpg</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="lightbox" href="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-20/房屋-河-城市.jpg">
                                    <img src="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-20/房屋-河-城市.jpg" alt="Bridge">
                                </a>
                                <div class="caption">
                                    <h3>已完成的标签：房屋 河 城市</h3>
                                    <p>picture8.jpg</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="lightbox" href="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-21/草地-树木-天空-建筑-大海.jpg">
                                    <img src="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-21/草地-树木-天空-建筑-大海.jpg" alt="Tunnel">
                                </a>
                                <div class="caption">
                                    <h3>已完成的标签：草地 树木 天空 建筑 大海</h3>
                                    <p>picture16.jpg</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="lightbox" href="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-21/白云岩-高山-水-天空-树.jpg">
                                    <img src="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-21/白云岩-高山-水-天空-树.jpg" alt="Coast">
                                </a>
                                <div class="caption">
                                    <h3>已完成的标签：白云岩 高山 水 天空 树</h3>
                                    <p>picture15.jpg</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="lightbox" href="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-20/天空-街道-建筑-马路-天线.jpg">
                                    <img src="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-20/天空-街道-建筑-马路-天线.jpg" alt="Rails">
                                </a>
                                <div class="caption">
                                    <h3>已完成的标签：天空 街道 建筑 马路 天线</h3>
                                    <p>picture4.jpg</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="lightbox" href="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-20/洛杉矶-市中心-音乐厅.jpg">
                                    <img src="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-20/洛杉矶-市中心-音乐厅.jpg" alt="Traffic">
                                </a>
                                <div class="caption">
                                    <h3>已完成的标签：洛杉矶 市中心 音乐厅</h3>
                                    <p>picture10.jpg</p>
                                </div>
                            </div>
                        </div>
                        <%--第三行--%>
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="lightbox" href="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-21/大海-沙滩-远山-天空.jpg">
                                    <img src="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-21/大海-沙滩-远山-天空.jpg" alt="Traffic">
                                </a>
                                <div class="caption">
                                    <h3>已完成的标签：大海 沙滩 远山 天空</h3>
                                    <p>picture12.jpg</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="lightbox" href="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-21/柏树-山-湖-天空-建筑.jpg">
                                    <img src="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-21/柏树-山-湖-天空-建筑.jpg" alt="Traffic">
                                </a>
                                <div class="caption">
                                    <h3>已完成的标签：柏树 山 湖 天空 建筑</h3>
                                    <p>picture13.jpg</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="lightbox" href="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-22/樱桃-蛋糕-花-篮子-甜点-水果.jpg">
                                    <img src="https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-22/樱桃-蛋糕-花-篮子-甜点-水果.jpg" alt="Traffic">
                                </a>
                                <div class="caption">
                                    <h3>已完成的标签：洛杉矶 市中心 音乐厅</h3>
                                    <p>picture19.jpg</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/baguetteBox.min.js"></script>
        <script type="text/javascript">
            baguetteBox.run('.tz-gallery');
        </script>
    </main>

</div>
</body>
</html>
