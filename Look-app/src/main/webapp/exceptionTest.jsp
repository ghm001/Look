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
    <title>异常界面</title>
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
    <%--鼠标悬停遮罩效果--%>
    <link rel="stylesheet" type="text/css" href="mouseHover/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="mouseHover/font-awesome.min.css">
    <%--网页内容导出到word效果--%>
    <script src="http://www.jq22.com/demo/exportWord20161214/js/FileSaver.js "></script>
    <script src="http://www.jq22.com/demo/exportWord20161214/js/jquery.wordexport.js"></script>

    <style type="text/css">
        .myDiv {
            margin-bottom: 40px;
            min-height: 250px;
            background-color: #e4e5e6;
        }

        img {
            -webkit-border-radius: 0 !important;
            -moz-border-radius: 0 !important;
            border-radius: 0 !important;
        }

        p {
            font-size: 10px;
        }

        B {
            font-size: 10px;
        }
    </style>
    <style type="text/css">
        .demo {
            padding: 2em 0;
        }

        .box {
            text-align: center;
            overflow: hidden;
            position: relative;
        }

        .box:before {
            content: "";
            width: 0;
            height: 100%;
            background: #000;
            padding: 14px 18px;
            position: absolute;
            top: 0;
            left: 50%;
            opacity: 0;
            transition: all 500ms cubic-bezier(0.47, 0, 0.745, 0.715) 0s;
        }

        .box:hover:before {
            width: 100%;
            left: 0;
            opacity: 0.5;
        }

        .box img {
            width: 100%;
            height: auto;
        }

        .box .box-content {
            width: 100%;
            padding: 14px 18px;
            color: #fff;
            position: absolute;
            top: 38%;
            left: 0;
        }

        .box .title {
            font-size: 25px;
            font-weight: 600;
            line-height: 30px;
            text-transform: uppercase;
            margin: 0;
            opacity: 0;
            transition: all 0.5s ease 0s;
        }

        .box .post {
            font-size: 15px;
            text-transform: capitalize;
            opacity: 0;
            transition: all 0.5s ease 0s;
        }

        .box:hover .title,
        .box:hover .post {
            opacity: 1;
            transition-delay: 0.7s;
        }

        .box .icon {
            padding: 0;
            margin: 0;
            list-style: none;
            margin-top: 15px;
        }

        .box .icon li {
            display: inline-block;
        }

        .box .icon li a {
            display: block;
            width: 50px;
            height: 50px;
            line-height: 50px;
            border-radius: 50%;
            background: #ffffff;
            font-size: 20px;
            font-weight: 700;
            color: #fff;
            margin-right: 5px;
            opacity: 0;
            transform: translateY(50px);
            transition: all 0.5s ease 0s;
        }

        .box:hover .icon li a {
            opacity: 1;
            transform: translateY(0px);
            transition-delay: 0.5s;
        }

        .box:hover .icon li:last-child a {
            transition-delay: 0.8s;
        }

        @media only screen and (max-width: 990px) {
            .box {
                margin-bottom: 30px;
            }
        }
        .modal-backdrop.fade {
            opacity: 0.5 !important;
        }
        .myBtn{
            border-radius:30px;
            margin-left: 30px;
        }
    </style>
</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden"
      style="min-width: 975px;">
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
<div class="app-body" >
    <div class="sidebar">
        <nav class="sidebar-nav">
            <ul class="nav" style="border-radius: 0px">
                <li class="nav-title">
                    功能列表
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="pictureManage.jsp">图片管理</a>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link" href="users.jsp">志愿者管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="tree.jsp">标签树结构</a>
                </li>
                <%--<li class="nav-item">
                    <a class="nav-link" href="exceptionTest.jsp.jsp">异常图片管理</a>
                </li>--%>
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
        <ol class="breadcrumb" style="border-radius: 0px">
            <li class="breadcrumb-item">管理员</li>
            <li class="breadcrumb-item active">A级管理员</li>
            <li class="breadcrumb-item">（将鼠标置于图片上即可修改异常）</li>
        </ol>


        <div class="container-fluid" style="background-color: #e4e5e6">
            <div class="breadcrumb" style="background-color: #e4e5e6">
                <div class="container" style="background-color: #e4e5e6">
                    <%--第一行--%>
                    <%--第一个--%>
                    <div id="imgDiv0" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/建筑-桥-水-树.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                  margin-top: -53px;margin-left: 0px;text-align: center">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange0" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                                <%--bootstrap模态框--%>
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" style="transform: translate(0, 0);">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <input type="button" id="tagBtn1" class="btn btn-success myBtn" style="display: none;" value="异常标签1" onclick="changeTagOpera()">
                                                <input type="button" id="tagBtn2" class="btn btn-success myBtn" style="display: none;" value="异常标签2">
                                                <input type="button" id="tagBtn3" class="btn btn-success myBtn" style="display: none;" value="异常标签3">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="float: right">&times;</button>
                                            </div>
                                            <div class="modal-body" style="color: #000000">
                                                <form>
                                                    <table style="text-align: left;border-collapse:separate;border-spacing:10px;width: 34em;">
                                                        <tr>
                                                            <td style="width: 60%">
                                                                你是否要删除这个标签？
                                                            </td>
                                                            <td style="text-align: center;width:40%">
                                                                <div class="btn-group">
                                                                    <button type="button" class="btn btn-danger btn-default" data-dismiss="modal" onclick="hideImg()">是</button>
                                                                    <button type="button" class="btn btn-success">否</button>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="width: 60%">
                                                                试着把这个标签加入标签树？
                                                            </td>
                                                            <td style="text-align: center;width:40%">
                                                                <div class="btn-group">
                                                                    <button type="button" class="btn btn-danger" onclick="addtree()">是</button>
                                                                    <button type="button" class="btn btn-success" onclick="bandontree()">否</button>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr id="trNone" style="display: none;">
                                                            <td>输入其父元素标签</td>
                                                            <td><input id="fatherInput" type="search"></td>
                                                        </tr>

                                                    </table>
                                                </form>
                                                <script>
                                                    function toggletr(e) {
                                                        var a = e.id;
                                                        if(a == "tagChange0"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId0_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a);
                                                        }else if(a == "tagChange1"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId1_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                            $("#tagBtn2").css('display','block');
                                                            $("#tagBtn2").val($("#uId1_1").attr('value'));
                                                        }else if(a == "tagChange2"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId2_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }else if(a == "tagChange3"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId3_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }else if(a == "tagChange4"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId4_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }else if(a == "tagChange5"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId5_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }else if(a == "tagChange6"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId6_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }else if(a == "tagChange7"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId7_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }else if(a == "tagChange8"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId8_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }else if(a == "tagChange9"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId9_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }else if(a == "tagChange10"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId10_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }else if(a == "tagChange11"){
                                                            cleanBtn();
                                                            $("#tagBtn1").css('display','block');
                                                            $("#tagBtn1").val($("#uId11_0").attr('value'));
                                                            $("#tagBtn1").attr('imgCleanTag',a)
                                                        }
                                                        $("#trNone").hide();//隐藏之前可能出现的输入框
                                                        $("#fatherInput").val("");
                                                    }

                                                    /*到时候要补的漏子！！！！*/

                                                    function cleanBtn() {
                                                        $("#tagBtn1").css('display','none');
                                                        $("#tagBtn2").css('display','none');
                                                        $("#tagBtn3").css('display','none');
                                                    }

                                                    function addtree(){
                                                        $("#trNone").show(800);
                                                    }
                                                    function bandontree(){
                                                        $("#trNone").hide(400);
                                                    }

                                                    /*
                                                    * 删除标签时执行的函数
                                                    * */
                                                    function hideImg() {
                                                        var a = $("#tagBtn1").attr('imgCleanTag');
                                                        if(a == "tagChange0"){
                                                            $("#imgDiv0").css('display','none');
                                                        }else if(a == "tagChange1"){
                                                            if($("#uId1_0").css('display') != 'none'&&$("#uId1_1").css('display') != 'none'){
                                                                $("#uId1_0").css('display','none');
                                                            }else if($("#uId1_0").css('display') == 'none'&&$("#uId1_1").css('display') != 'none'){
                                                                $("#imgDiv1").css('display','none');
                                                            }
                                                        }else if(a == "tagChange2"){
                                                            $("#imgDiv2").css('display','none');
                                                        }else if(a == "tagChange3"){
                                                            $("#imgDiv3").css('display','none');
                                                        }else if(a == "tagChange4"){
                                                            $("#imgDiv4").css('display','none');
                                                        }else if(a == "tagChange5"){
                                                            $("#imgDiv5").css('display','none');
                                                        }else if(a == "tagChange6"){
                                                            $("#imgDiv6").css('display','none');
                                                        }else if(a == "tagChange7"){
                                                            $("#imgDiv7").css('display','none');
                                                        }else if(a == "tagChange8"){
                                                            $("#imgDiv8").css('display','none');
                                                        }else if(a == "tagChange9"){
                                                            $("#imgDiv9").css('display','none');
                                                        }else if(a == "tagChange10"){
                                                            $("#imgDiv10").css('display','none');
                                                        }else if(a == "tagChange11"){
                                                            $("#imgDiv11").css('display','none');
                                                        }
                                                    }

                                                    /*
                                                    * 点击标签按钮时改变正在操作的标签
                                                    * */
                                                    function changeTagOpera(){

                                                    }
                                                </script>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-primary btn-default" data-dismiss="modal">提交更改</button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>
                            </div>
                        </div>
                        <div>
                            <B>建筑-桥-水-树.jpg</B>
                            <p><b>目前通过了的标签:</b>教堂 桥 圆洞桥 水 树林</p>
                            异常标签：<u id="uId0_0" value="伦敦">伦敦</u>
                        </div>
                    </div>
                    <%--第二个--%>
                    <div id="imgDiv1" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/建筑-花-树-天空.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                  margin-top: -53px;margin-left: 0px;text-align: center">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange1" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>建筑-花-树-天空.jpg</B>
                            <p><b>目前通过了的标签:</b>城堡 建筑 花 树 天空</p>
                            异常标签：<u id="uId1_0" value="我就是乱写的">我就是乱写的</u>&nbsp;<u id="uId1_1" value="中世纪">中世纪</u>
                        </div>
                    </div>
                    <div id="imgDiv2" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/灯-汽车-马路-人-房子.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange2" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>灯-汽车-马路-人-房子.jpg</B>
                            <p><b>目前通过了的标签:</b>城市 路灯 行人 建筑 汽车</p>
                            异常标签：<u id="uId2_0" value="好像是香港？？">好像是香港？？</u>
                        </div>
                    </div>
                    <div id="imgDiv3" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/灯塔-海-热气球-路-天空.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange3" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>灯塔-海-热气球-路-天空.jpg</B>
                            <p><b>目前通过了的标签:</b>气球 灯塔</p>
                            异常标签：<u id="uId3_0" value="跳伞">跳伞</u>
                        </div>
                    </div>
                    <div id="imgDiv4" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/电动机-金属制物.png">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange4" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>电动机-金属制物.png</B>
                            <p><b>目前通过了的标签:</b>发动机 轴承</p>
                            异常标签：<u id="uId4_0" value="电池">电池</u>
                        </div>
                    </div>
                    <div id="imgDiv5" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/马路-杂草-树-山.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange5" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>马路-杂草-树-山.jpg</B>
                            <p><b>目前通过了的标签:</b>山 公路 树林</p>
                            异常标签：<u id="uId5_0" value="山洞">山洞</u>
                        </div>
                    </div>


                    <%--第二行--%>
                    <div id="imgDiv6" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/工具-金属器件.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange6" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>工具-金属器件.jpg</B>
                            <p><b>目前通过了的标签:</b>工具 金属器件</p>
                            异常标签：<u id="uId6_0" value="陀螺吗？">陀螺吗？</u>
                        </div>
                    </div>
                    <div id="imgDiv7" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/游标卡尺-齿轮.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange7" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>游标卡尺-齿轮.jpg</B>
                            <p><b>目前通过了的标签:</b>游标卡尺 齿轮 测量工具</p>
                            异常标签：<u id="uId7_0" value="公平秤">公平秤</u>
                        </div>
                    </div>
                    <div id="imgDiv8" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/游轮-海-货物.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange8" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>游轮-海-货物.jpg</B>
                            <p><b>目前通过了的标签:</b>轮船，海洋，运输船，蓝天，游轮，货物</p>
                            异常标签：<u id="uId8_0" value="战斗舰">战斗舰</u>
                        </div>
                    </div>
                    <div id="imgDiv9" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/组件-电子仪器-测量仪-电锥子.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange9" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>组件-电子仪器-测量仪-电锥子.jpg</B>
                            <p><b>目前通过了的标签:</b>电子仪器 电锥子</p>
                            异常标签：<u id="uId9_0" value="木桌">木桌</u>
                        </div>
                    </div>
                    <div id="imgDiv10" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/飞机-机场-树木.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange10" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>飞机-机场-树木.jpg</B>
                            <p><b>目前通过了的标签:</b>飞机 机场</p>
                            异常标签：<u id="uId10_0" value="航空公司">航空公司</u>&nbsp;<u>有钱人</u>
                        </div>
                    </div>
                    <div id="imgDiv11" class="col-md-2 col-sm-4 myDiv">
                        <div class="box" style="width: 10em;height: 10em;">
                            <img class="img-responsive img-rounded" style="width: 10em;height: 10em;"
                                 src="https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/高山-树木-建筑-天空-草地.jpg">
                            <div class="box-content" style="width: 10em;height: 10em;
                                                         margin-top: -53px;margin-left: 0px">
                                <span class="title">修改</span>
                                <ul class="icon">
                                    <li style="text-align: center"><a id="tagChange11" onclick="toggletr(this)" data-toggle="modal" data-target="#myModal"><img src="img/updatatwo.png" style="width: 0.9em;height: 0.9em"></a></li>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <B>高山-树木-建筑-天空-草地.jpg</B>
                            <p><b >目前通过了的标签:</b>高山 山脉 木屋</p>
                            异常标签：<u id="uId11_0" value="隐居者">隐居者</u>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>
