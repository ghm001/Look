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
    <!--Highcharts引用的js-->
    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
    <%--因为饼图加的js引用--%>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
    <%--图片轮播效果--%>
    <link rel="stylesheet" type="text/css" href="css/lunbo/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="css/lunbo/default.css">
    <link rel="stylesheet" href="css/lunbo/sangarSlider.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/lunbo/default2.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/lunbo/demo.css" type="text/css" media="all">
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
                <li class="nav-item" style="background-color: #20a8d8">
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
        <ol class="breadcrumb" style="border-radius: 0px">
            <li class="breadcrumb-item">管理员</li>
            <li class="breadcrumb-item active">A级管理员</li>
        </ol>
        <div class="jq22-container" style="width: 1300px">
            <div class="jq22-content bgcolor-3">
                <div class='sangar-slideshow-container' id='sangar-example'>
                    <div class='sangar-content-wrapper' style='display:none;'>
                        <div class='sangar-content' style="background-color: #FFFFFF">
                            <div class="card-block">
                                <table class="table table-bordered table-striped table-condensed">
                                    <thead>
                                    <tr>
                                        <th>产生者</th>
                                        <th>产生推送的标签</th>
                                        <th>推送类别</th>
                                        <th>产生日期</th>
                                        <th class="th1">是否删除该标签</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                            <tr id="lhybjn" style="display: table-row" value="lhy">
                                                <td>鳄鱼</td>
                                                <td>水稻</td>
                                                <td>农业</td>
                                                <td>2017-5-23 T18:34:15Z</td>
                                                <td class="th1">
                                                    <button id="gaiUsersBtn01" class="btn btn-danger" onclick="delect()">删除
                                                    </button>
                                                    <script>
                                                        function delect(){
                                                            /*alert($("#lhybjn").css('display'));
                                                            $("#lhybjn").css("display","none");
                                                            alert($("#lhybjn").css("display"));
                                                            alert($("#lhybjn").attr('display'));*/

                                                            /*var a = document.getElementById("lhybjn");
                                                            alert(a.style.display);
                                                            alert(a.value);
                                                            a.style.display = "none";
                                                            alert(a.style.display);*/
                                                        }
                                                    </script>
                                                </td>
                                            </tr>
                                    <tr>
                                        <td>李昊宇</td>
                                        <td>城堡</td>
                                        <td>生活场景</td>
                                        <td>2017-5-24 T12:01:33Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn02" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>李昊宇</td>
                                        <td>天空</td>
                                        <td>生活场景</td>
                                        <td>2017-5-24 T12:02:10Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn03" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>李昊宇</td>
                                        <td>山</td>
                                        <td>自然风景</td>
                                        <td>2017-5-24 T12:02:55Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn04" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class='sangar-content' style="background-color: #FFFFFF">
                            <div class="card-block">
                                <table class="table table-bordered table-striped table-condensed">
                                    <thead>
                                    <tr>
                                        <th>产生者</th>
                                        <th>产生推送的标签</th>
                                        <th>推送类别</th>
                                        <th>产生日期</th>
                                        <th class="th1">是否删除该标签</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>杰克 陈</td>
                                        <td>岩石</td>
                                        <td>自然风景</td>
                                        <td>2017-6-01 T11:28:11Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn11" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>杰克 陈</td>
                                        <td>山洞</td>
                                        <td>自然风景</td>
                                        <td>2017-6-01 T11:29:01Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn12" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>李昊宇</td>
                                        <td>天空</td>
                                        <td>自然风景</td>
                                        <td>2017-6-02 T08:02:56Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn13" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>李昊宇</td>
                                        <td>云</td>
                                        <td>自然风景</td>
                                        <td>2017-5-24 T08:03:12Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn14" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>李昊宇</td>
                                        <td>石桥</td>
                                        <td>生活场景</td>
                                        <td>2017-5-24 T12:03:29Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn15" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class='sangar-content' style="background-color: #FFFFFF">
                            <div class="card-block">
                                <table class="table table-bordered table-striped table-condensed">
                                    <thead>
                                    <tr>
                                        <th>产生者</th>
                                        <th>产生推送的标签</th>
                                        <th>推送类别</th>
                                        <th>产生日期</th>
                                        <th class="th1">是否删除该标签</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>hello keke</td>
                                        <td>山</td>
                                        <td>自然风景</td>
                                        <td>2017-06-04 T15:44:36Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn21" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>hello keke</td>
                                        <td>云海</td>
                                        <td>自然风景</td>
                                        <td>2017-06-04 T15:44:59Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn22" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>hello keke</td>
                                        <td>天空</td>
                                        <td>生活场景</td>
                                        <td>2017-5-24 T12:02:10Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn23" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>hello keke</td>
                                        <td>阿尔卑斯山</td>
                                        <td>自然风景</td>
                                        <td>2017-5-24 T12:06:45Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn24" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class='sangar-content' style="background-color: #FFFFFF">
                            <div class="card-block">
                                <table class="table table-bordered table-striped table-condensed">
                                    <thead>
                                    <tr>
                                        <th>产生者</th>
                                        <th>产生推送的标签</th>
                                        <th>推送类别</th>
                                        <th>产生日期</th>
                                        <th class="th1">是否删除该标签</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>风清扬</td>
                                        <td>湖</td>
                                        <td>自然风景</td>
                                        <td>2017-5-26 T22:47:32Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn31" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>风清扬</td>
                                        <td>傍晚</td>
                                        <td>自然风景</td>
                                        <td>2017-5-26 T22:48:32Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn32" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>慕容小小</td>
                                        <td>天空</td>
                                        <td>自然风景</td>
                                        <td>2017-5-25 T12:02:24Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn33" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>慕容小小</td>
                                        <td>山</td>
                                        <td>自然风景</td>
                                        <td>2017-5-24 T12:02:45Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn34" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>慕容小小</td>
                                        <td>树林</td>
                                        <td>自然风景</td>
                                        <td>2017-5-24 T12:03:29Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn35" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class='sangar-content' style="background-color: #FFFFFF">
                            <div class="card-block">
                                <table class="table table-bordered table-striped table-condensed">
                                    <thead>
                                    <tr>
                                        <th>产生者</th>
                                        <th>产生推送的标签</th>
                                        <th>推送类别</th>
                                        <th>产生日期</th>
                                        <th class="th1">是否删除该标签</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>李昊宇</td>
                                        <td>图书</td>
                                        <td>记录媒介</td>
                                        <td>2017-5-27 T15:14:41Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn41" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>李昊宇</td>
                                        <td>眼睛</td>
                                        <td>日常用品</td>
                                        <td>2017-5-24 T15:15:33Z</td>
                                        <td class="th1">
                                            <button id="gaiUsersBtn42" class="btn btn-danger">删除</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script type="text/javascript" src="js/lunbo/jquery.js"></script>
        <script type="text/javascript" src="js/lunbo/jquery.touchSwipe.min.js"></script>
        <script type="text/javascript" src="js/lunbo/imagesloaded.min.js"></script>
        <!-- jQuery Sangar Slider -->
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarBaseClass.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarSetupLayout.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarSizeAndScale.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarShift.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarSetupBulletNav.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarSetupNavigation.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarSetupSwipeTouch.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarSetupTimer.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarBeforeAfter.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarLock.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarResponsiveClass.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarResetSlider.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider/sangarTextbox.js"></script>
        <script type="text/javascript" src="js/lunbo/sangarSlider.js"></script>
        <script type='text/javascript'>
            jQuery(document).ready(function ($) {
                /**
                 * identifier variable must be unique ID
                 */
                var sangar = $('#sangar-example').sangarSlider({
                    timer: false, // true or false to have the timer
                    pagination: 'content-horizontal', // bullet, content, none
                    paginationContent: ["https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-22/城堡-风景-天空-大海.jpg",
                        "https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-22/天空-纪念碑-砂岩-云.jpg",
                        "https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-22/天空-风景-云-阿尔卑斯山.jpg",
                        "https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-22/山-湖水-晨曦-树林.jpg",
                        "https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-22/书-眼镜.jpg"], // can be text, image, or something
                    paginationContentType: 'image', // text, image
                    paginationContentWidth: 120, // pagination content width in pixel
                    paginationImageHeight: 90, // pagination image height
                    width: 850, // slideshow width
                    height: 500, // slideshow height
                    fixedHeight: true,
                    scaleSlide: true // slider will scale to the container size
                });
            })
        </script>
    </main>

</div>
</body>
</html>
