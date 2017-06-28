<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/5
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en" style="font-size: 16px">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">--%>
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword"
          content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,jQuery,CSS,HTML,RWD,Dashboard">
    <link rel="shortcut icon" href="img/favicon.png">
    <title>CoreUI - Open Source Bootstrap Admin Template</title>

    <%--bootStrap--%>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <script src="bootstrap/bootstrap.min.js"></script>

    <%--引入jq session插件--%>
    <script src="js/jquerySession.js"></script>
    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">
    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">
    <%--jquery下拉框插件--%>
    <style>
    .container { margin:150px auto 30px auto; min-width:360px;}
    h1 { margin-bottom:30px;}
    </style>
    <link href="css/jquery.fancyspinbox.css" rel="stylesheet" type="text/css">
    <script src="js/jquery.fancyspinbox.js"></script>

    <!-- Bootstrap and necessary plugins -->
    <%--<script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/tether/dist/js/tether.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/pace/pace.min.js"></script>--%>
    <!-- Plugins and scripts required by all views -->
    <%--<script src="bower_components/chart.js/dist/Chart.min.js"></script>--%>
    <!-- GenesisUI main scripts -->
    <%--<script src="js/app.js"></script>--%>
    <!-- Plugins and scripts required by this views -->
    <!-- Custom scripts required by this view -->
    <%--<script src="js/views/widgets.js"></script>--%>
    <%--Highcharts的引入--%>
    <script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/data.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/drilldown.js"></script>
    <%--Highcharts需要引入的js--%>
    <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
    <style>
        .p-picture {
            color: #f0f0f0;
        }
    </style>
</head>
<script>

    var infohhh = [
    {
        "ImageId": 103,
        "company": "华为",
        "imageUrl": "https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/建筑-桥-水-树.jpg",
        "uptime": "2017-5-24"
    },
    {
        "ImageId": 104,
            "company": "华为",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/建筑-花-树-天空.jpg",
            "uptime": "2017-5-23"
    },
    {
        "ImageId": 105,
            "company": "华为",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/灯-汽车-马路-人-房子.jpg",
            "uptime": "2017-5-23"
    },
    {
        "ImageId": 106,
            "company": "华为",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/灯塔-海-热气球-路-天空.jpg",
            "uptime": "2017-5-25"
    },
    {
        "ImageId": 107,
            "company": "华为",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/电动机-金属制物.png",
            "uptime": "2017-5-25"
    },
    {
        "ImageId": 108,
            "company": "华为",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/华为/2017-5-24/马路-杂草-树-山.jpg",
            "uptime": "2017-5-24"
    },
    {
        "ImageId": 109,
            "company": "腾讯",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/工具-金属器件.jpg",
            "uptime": "2017-5-25"
    },
    {
        "ImageId": 110,
            "company": "腾讯",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/游标卡尺-齿轮.jpg",
            "uptime": "2017-5-26"
    },
    {
        "ImageId": 111,
            "company": "腾讯",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/游轮-海-货物.jpg",
            "uptime": "2017-5-24"
    },
    {
        "ImageId": 112,
            "company": "腾讯",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/组件-电子仪器-测量仪-电锥子.jpg",
            "uptime": "2017-5-26"
    },
    {
        "ImageId": 113,
            "company": "腾讯",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/飞机-机场-树木.jpg",
            "uptime": "2017-5-24"
    },
    {
        "ImageId": 114,
            "company": "腾讯",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/腾讯/2017-5-24/高山-树木-建筑-天空-草地.jpg",
            "uptime": "2017-5-24"
    },
    {
        "ImageId": 115,
            "company": "老马识图",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-24/万用表-.jpg",
            "uptime": "2017-5-24"
    },
    {
        "ImageId": 116,
            "company": "老马识图",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-24/山-海水-帆船-树-.jpg",
            "uptime": "2017-5-24"
    },
    {
        "ImageId": 117,
            "company": "老马识图",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-24/工具-金属器件-钻孔器.jpg",
            "uptime": "2017-5-26"
    },
    {
        "ImageId": 118,
            "company": "老马识图",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-24/建筑-船-河水-树.jpg",
            "uptime": "2017-5-26"
    },
    {
        "ImageId": 119,
            "company": "老马识图",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-24/桥-道路-栏杆-交通-天空-云.jpg",
            "uptime": "2017-5-24"
    },
    {
        "ImageId": 120,
            "company": "老马识图",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/老马识图/2017-5-24/火车-建筑-杂草-天空.jpg",
            "uptime": "2017-5-24"
    },
    {
        "ImageId": 0,
            "company": "华为",
            "imageUrl": "https://obs.myhwclouds.com/look.admin.image/老马识途/2017-5-20/天空-云朵-建筑-大海-树木-人群.jpg",
            "uptime": "2017-5-25"
    }
    ];

    function alllc(data){
        alert(data[1]);
        alert(data[1]['company']);
        for(var i=0;i<1;i++){
            for(var middle in data[i]){
                alert(middle+':'+data[i][middle]);
            }
        }
    }

    function info(){
        $.ajax({
            url:'http://192.168.43.204:8080/look/AdminB/Finishtable',
            dataType:'',
            success:function (data) {
                //所提取的所有图片相关数据
                var jsonReturn = JSON.parse(data);
                alert(jsonReturn[1]);
                for(var i=0;i<jsonReturn.length;i++){
                    for(var middle in jsonReturn[i]){
                        alert(middle+':'+jsonReturn[i][middle]);
                    }
                }

//                [{
//                    name: '老马识图团队',
//                    data: [0, 0, 0, 0, 0, 0, 160, 0, 80, 0, 0, 0]
//                },

            }
        })
    }

    function monthInfo(jsonReturn){
        var month = "[";//月份的拼接字符串

        var companyArray = new Array();//所有公司名字的字符串数组
        var tag;
        //提取所有公司的名字
        for(var i=0;i<jsonReturn.length;i++){
            var middleCom = jsonReturn[i].company;
            tag = 0;
            for(var j = 0;j < companyArray.length;j ++){
                if(middleCom == companyArray[j]){
                    tag = 1;
                }
            }
            if(tag == 0){
                companyArray.push(middleCom);
            }
        }

        month = month + "{[name:'" + companyArray[i] + "',"  +
                "data : [";

        for(var i=0;i<companyArray.length-1;i++){
            var middleNum = 0;
            for(var j=0;j<jsonReturn.length-1;j++){
                if(jsonReturn[j].company == companyArray[i]){
                    middleNum ++;
                }
            }
            month = month + middleNum.toString() + ",";
            middleNum = 0;
        }

        for(var i=companyArray.length-1;i<companyArray.length;i++){
            var middleNum = 0;
            for(var j=0;j<jsonReturn.length-1;j++){
                if(jsonReturn[j].company == companyArray[i]){
                    middleNum ++;
                }
            }
            month = month + middleNum.toString() + "}]";
        }
    }
</script>

<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden" onload="CreateHighcharts('Month');"
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
            <li class="breadcrumb-item active">完成库</li>
        </ol>
        <div class="container-fluid"><%--设置左右边距，分别为15px--%>
            <div class="animated fadeIn"><%--lhy--%>
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
                    <div class="col-sm-6 col-lg-3" ondblclick="javascript:location.href='widgets.jsp' ">
                        <div class="card card-inverse card-danger" style="box-shadow:0px 0px 13px 0px #000">
                            <div class="card-block pb-0">
                                <h4 class="mb-0">完成库</h4>
                                <p class="p-picture">标签已经完成化的图片库</p>
                            </div>
                            <div class="px-1" style="height:70px;">
                                <%--<div class="dropdown">--%>
                                    <%--<button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">--%>
                                        <%--&lt;%&ndash;<span class="caret"></span>&ndash;%&gt;--%>
                                    <%--</button>--%>
                                    <%--<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">--%>
                                        <%--<li role="presentation">--%>
                                            <%--<a role="menuitem" tabindex="-1" href="#">图片预览</a>--%>
                                        <%--</li>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>

                            </div>
                        </div>
                    </div>
                    <!--/.col-->
                </div>
                <!--/.row-->
                <div class="card">
                    <div class="card-block">
                        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                        <!-- Data from www.netmarketshare.com. Select Browsers => Desktop share by version. Download as tsv. -->
                        <pre id="tsv" style="display:none">Browser Version	Total Market Share
                医学 【手术器械】	26.61%
                医学 【科室】	16.96%
                体育运动 【球类运动】	8.01%
                体育运动 【棋类运动】	7.73%
                服装 【女士服装】	6.72%
                医学 【医疗设施】	6.40%
                服装 【男士服装】	4.72%
                医学 【医护人员】	3.55%
                基础学科 【数学】	3.53%
                服装 【内衣】	2.16%
                服装 【袜子】	1.87%
                电子产品 【手机】	1.30%
                体育运动 【极限运动】	1.13%
                服装 【帽子】	0.90%
                电子产品 【电脑】	0.85%
                服装 【风衣】	0.65%
                服装 【配饰】	0.55%
                服装 【夏装】	0.50%
                电子产品 【电子手表】	0.45%
                电子产品 【电子烟】	0.36%
                服装 【春款】	0.36%
                服装 【秋衣】	0.32%
                服装 【冬装】	0.31%
                服装 【帽子】	0.29%
                基础学科 【哲学】	0.29%
                体育运动 【运动器械】  - Maxthon Edition	0.26%
                体育运动 【体育赛事】	0.25%
                基础学科 【物理】	0.24%
                基础学科 【化学】	0.18%
                基础学科 【生物】	0.16%
                电子产品 【二极管】	0.15%
                电子产品 【晶体管】	0.14%
                电子产品 【电池】	0.13%
                基础学科 【社会科学】	0.12%
                电子产品 【集成电路】	0.10%
                服装 【穿衣风格】	0.10%
                服装 【鞋子】	0.09%
                体育运动 【体育服装】	0.09%
                电子产品 【耳机】	0.09%
                医学 【医学院】 - Tencent Traveler Edition	0.09%</pre>

                        <script>
                            $(function () {
                                Highcharts.data({
                                    csv: document.getElementById('tsv').innerHTML,
                                    itemDelimiter: '\t',
                                    parsed: function (columns) {
                                        var brands = {},
                                                brandsData = [],
                                                versions = {},
                                                drilldownSeries = [];
                                        // 解析百分比字符串
                                        columns[1] = $.map(columns[1], function (value) {
                                            if (value.indexOf('%') === value.length - 1) {
                                                value = parseFloat(value);
                                            }
                                            return value;
                                        });
                                        $.each(columns[0], function (i, name) {
                                            var brand,
                                                    version;
                                            if (i > 0) {
                                                // Remove special edition notes
                                                name = name.split(' -')[0];
                                                // 拆分
                                                version = name.match(/【(.*?)】/);
                                                if (version) {
                                                    version = version[0];
                                                }
                                                brand = name.replace(version, '');
                                                //创建主数据
                                                if (!brands[brand]) {
                                                    brands[brand] = columns[1][i];
                                                } else {
                                                    brands[brand] += columns[1][i];
                                                }
                                                // 创建版本数据
                                                if (version !== null) {
                                                    if (!versions[brand]) {
                                                        versions[brand] = [];
                                                    }
                                                    /*version = version(version,'','');*/
                                                    version = version.replace('【', '');
                                                    version = version.replace('】', '');
                                                    versions[brand].push([version, columns[1][i]]);//columns是百分比数据，version是版本信息
                                                }
                                            }
                                        });
                                        $.each(brands, function (name, y) {
                                            brandsData.push({
                                                name: name,
                                                y: y,
                                                drilldown: versions[name] ? name : null
                                            });
                                        });
                                        $.each(versions, function (key, value) {
                                            drilldownSeries.push({
                                                name: key,
                                                id: key,
                                                data: value
                                            });
                                        });
                                        // 创建图例
                                        $('#container').highcharts({
                                            chart: {
                                                type: 'pie'
                                            },
                                            title: {
                                                text: '各个图片分属类型'
                                            },
                                            subtitle: {
                                                text: '单击每个大类型下的具体分类信息，数据来源: 老马识图团队'
                                            },
                                            plotOptions: {
                                                series: {
                                                    dataLabels: {
                                                        enabled: true,
                                                        format: '{point.name}: {point.y:.1f}%'
                                                    }
                                                }
                                            },
                                            tooltip: {
                                                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                                                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
                                            },
                                            series: [{
                                                name: '类型',
                                                colorByPoint: true,
                                                data: brandsData
                                            }],
                                            drilldown: {
                                                series: drilldownSeries
                                            }
                                        });
                                    }
                                });
                            });
                        </script>
                    </div>
                </div>
                <div class="card">
                    <div class="card-block">
                        <div class="row">
                            <div class="col-sm-5">
                                <h4 class="card-title mb-0">老马识图团队</h4>
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
                                                   onclick="CreateHighcharts('Day');">天
                                        </label>
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
                        <!--/.row-->

                        <!--Highcharts折线图-->
                        <div id="HighchartsLine" style="min-width:250px;height:400px"></div>
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
                                    chart = new Highcharts.Chart('HighchartsLine', {
                                        title: {
                                            text: '不同管理员上传图片的完成库的增加数量',
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
                                            name: '管理员1',
                                            data: [0, 0, 0, 0, 0, 0, 160, 0, 80, 0, 0, 0]
                                        }, {
                                            name: '管理员2',
                                            data: [0, 80, 19, 13, 10, 20, 8, 21, 01, 11, 6, 25]
                                        }, {
                                            name: '管理员3',
                                            data: [90, 6, 97, 90, 21, 15, 86, 19, 41, 90, 39, 10]
                                        }, {
                                            name: '管理员4',
                                            data: [10, 80, 3, 4, 115, 157, 171, 6, 0, 0, 66, 43]
                                        }]
                                    });
                                } else if (time == 'Month') {
                                    elementA.className = b;
                                    elementB.className = a;
                                    elementC.className = b;
                                    var chart = new Highcharts.Chart('HighchartsLine', {
                                        title: {
                                            text: '不同管理员上传图片的完成库的增加数量',
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
                                            name: '管理员1',
                                            data: [12, 10, 50, 10, 0, 0, 10, 110, 200, 30, 20, 10, 50, 10, 0,
                                                0, 10, 110, 170, 200, 0, 78, 34, 22, 11, 16, 34, 55, 13, 14]
                                        }, {
                                            name: '管理员2',
                                            data: [0, 80, 19, 11, 170, 200, 28, 0, 20, 154, 86, 25, 3, 6, 78,
                                                99, 34, 55, 56, 45, 88, 90, 23, 16, 19, 14, 9, 3, 10, 9]
                                        }, {
                                            name: '管理员3',
                                            data: [90, 0, 0, 80, 15, 10, 16, 19, 14, 9, 3, 10, 40, 77, 1,
                                                0, 57, 23, 2, 13, 10, 489, 11, 12, 0, 78, 34, 22, 11, 40]
                                        }, {
                                            name: '管理员4',
                                            data: [10, 80, 93, 489, 11, 12, 10, 156, 12, 40, 66, 83, 15, 19, 14,
                                                9, 90, 154, 86, 25, 3, 6, 78, 99, 34, 55, 76, 94, 39, 72]
                                        }]
                                    });
                                } else if (time == 'Year') {
                                    elementA.className = b;
                                    elementB.className = b;
                                    elementC.className = a;
                                    var chart = new Highcharts.Chart('HighchartsLine', {
                                        title: {
                                            text: '不同管理员上传图片的完成库的增加数量',
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
                                            valueSuffix: '°C'
                                        },
                                        legend: {
                                            layout: 'vertical',
                                            align: 'right',
                                            verticalAlign: 'middle',
                                            borderWidth: 0
                                        },
                                        series: [{
                                            name: '管理员1',
                                            data: [120, 110, 21, 30, 1, 500, 1200, 1000, 800, 183, 139, 96]
                                        }, {
                                            name: '管理员2',
                                            data: [0, 80, 119, 113, 1700, 2200, 248, 241, 201, 11, 806, 25]
                                        }, {
                                            name: '管理员3',
                                            data: [900, 6, 35, 840, 135, 170, 186, 179, 141, 90, 39, 10]
                                        }, {
                                            name: '管理员4',
                                            data: [1000, 800, 963, 489, 1159, 1572, 1710, 1656, 1412, 400, 606, 483]
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
</body>
</html>
