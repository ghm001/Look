<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/4
  Time: 18:59
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
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden" style="min-width: 975px">
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
                <li class="nav-item" style="background-color: #20a8d8">
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
    <main class="main">
        <!-- Breadcrumb -->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">管理员</li>
            <li class="breadcrumb-item active">A级管理员</li>
        </ol>
        <div class="container-fluid">
            <div class="animated fadeIn">
                <div class="row">
                    <script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
                    <script>
                        var nodes = [{name: "农业"}, {name: "林业"},
                            {name: "畜牧业"}, {name: "渔业"},
                            {name: "矿产"}, {name: "石油化工"},
                            {name: "金属制品"}, {name: "有色金属"},
                            {name: "非金属矿"}, {name: "矿产品"},
                            {name: "食品"}, {name: "食品副产"},
                            {name: "饮料等"}, {name: "烟草制品"},
                            {name: "纺织产品"}, {name: "日常用品"},
                            {name: "动物制品"}, {name: "木竹制品"},
                            {name: "家具及配件"}, {name: "纸及纸制品"},
                            {name: "记录媒介"}, {name: "文教体育用品"},
                            {name: "化工业"}, {name: "化学原料及化学制品"},
                            {name: "医药"}, {name: "化学纤维制品"},
                            {name: "橡胶制品"}, {name: "塑料制品"},
                            {name: "非金属矿物制品"}, {name: "工业器件"},
                            {name: "工业产品"}, {name: "金属制品"},
                            {name: "通用设备"}, {name: "塑料制品"},
                            {name: "专用设备"}, {name: "交通运输设备"},
                            {name: "电气机械及器材"}, {name: "通信行业"},
                            {name: "仪器行业"}, {name: "其他制造业"},
                            {name: "资源处理"}, {name: "动物"},
                            {name: "自然风景"}, {name: "生活场景"},
                            {name: "植物"}];

                        var nodes1 = [{name: "美国"}, {name: "哥伦比亚地区"},
                            {name: "佛罗里达"}, {name: "阿拉斯加"},
                            {name: "江苏"}, {name: "浙江"},
                            {name: "福建"}, {name: "上海"},
                            {name: "长沙"}, {name: "株洲"},
                            {name: "湘潭"}, {name: "武汉"},
                            {name: "荆州"}, {name: "大冶"},
                            {name: "广州"}, {name: "深圳"},
                            {name: "东莞"}, {name: "南京"},
                            {name: "苏州"}, {name: "无锡"},
                            {name: "福州"}, {name: "厦门"},
                            {name: "泉州"}, {name: "浦东"},
                            {name: "陆家嘴"}, {name: "徐家汇"},
                            {name: "杭州"}, {name: "温州"},
                            {name: "义乌"}];

                        var edges = [{source: 0, target: 1}, {source: 0, target: 2},
                            {source: 0, target: 3}, {source: 0, target: 4},
                            {source: 0, target: 5}, {source: 0, target: 6},
                            {source: 1, target: 7}, {source: 1, target: 8},
                            {source: 2, target: 9}, {source: 2, target: 10},
                            {source: 3, target: 11}, {source: 3, target: 12},
                            {source: 4, target: 13}, {source: 5, target: 14},
                            {source: 5, target: 15}, {source: 6, target: 16},
                            {source: 10, target: 17}, {source: 10, target: 18},
                            {source: 11, target: 19}, {source: 12, target: 20},
                            {source: 12, target: 21}, {source: 12, target: 22},
                            {source: 21, target: 23}, {source: 15, target: 24},
                            {source: 16, target: 25}, {source: 18, target: 26},
                            {source: 22, target: 27}, {source: 23, target: 28},
                            {source: 26, target: 29}, {source: 26, target: 30},
                            {source: 26, target: 31}, {source: 30, target: 32},
                            {source: 31, target: 33}, {source: 33, target: 34},
                            {source: 33, target: 35}, {source: 33, target: 36},
                            {source: 34, target: 37}, {source: 35, target: 38},
                            {source: 38, target: 39}, {source: 38, target: 40},
                            {source: 39, target: 41}, {source: 16, target: 42},
                            {source: 8, target: 43}, {source: 8, target: 44}];

                        var edges1 = [{source: 0, target: 1}, {source: 0, target: 2},
                            {source: 0, target: 3}, {source: 0, target: 4},
                            {source: 0, target: 5}, {source: 0, target: 6},
                            {source: 0, target: 7}, {source: 1, target: 8},
                            {source: 1, target: 9}, {source: 1, target: 10},
                            {source: 2, target: 11}, {source: 2, target: 12},
                            {source: 2, target: 13}, {source: 3, target: 14},
                            {source: 3, target: 15}, {source: 3, target: 16},
                            {source: 4, target: 17}, {source: 4, target: 18},
                            {source: 4, target: 19}, {source: 6, target: 20},
                            {source: 6, target: 21}, {source: 6, target: 22},
                            {source: 7, target: 23}, {source: 7, target: 24},
                            {source: 7, target: 25}, {source: 5, target: 26},
                            {source: 2, target: 27}, {source: 2, target: 28}];

                        var width = 1500;
                        var height = 700;

                        //添加一个svg画布，到时候说不定可以只改变画布的width和height就可以限制d3位置，以配合响应式
                        var svg = d3.select("body")
                                .append("svg")
                                .attr("width", width)
                                .attr("height", height);

                        var force = d3.layout.force()
                                .nodes(nodes)		//指定节点数组
                                .links(edges)		//指定连线数组
                                .size([width, height])	//指定范围
                                .linkDistance(100)	//指定连线长度
                                .charge(-300);	//相互之间的作用力

                        force.start();	//开始作用

                        console.log(nodes);
                        console.log(edges);

                        //添加连线
                        var svg_edges = svg.selectAll("line")
                                .data(edges)
                                .enter()
                                .append("line")
                                .style("stroke", "#ccc")
                                .style("stroke-width", 1);

                        var color = d3.scale.category20();

                        //添加节点
                        var svg_nodes = svg.selectAll("circle")
                                .data(nodes)
                                .enter()
                                .append("circle")
                                .attr("r", 20)
                                .attr("id",function (d) {
                                    return d.name;
                                })
                                .style("fill", function (d, i) {
                                    return color(i);
                                })
                                .call(force.drag);	//使得节点能够拖动

                        //添加描述节点的文字
                        var svg_texts = svg.selectAll("text")
                                .data(nodes)
                                .enter()
                                .append("text")
                                .style("fill", "black")
                                .attr("dx", 20)
                                .attr("dy", 8)
                                .text(function (d) {
                                    return d.name;
                                });

                        force.on("tick", function () {

                            //对于每一个时间间隔
                            //更新连线坐标
                            svg_edges.attr("x1", function (d) {
                                return d.source.x;
                            })
                                    .attr("y1", function (d) {
                                        return d.source.y;
                                    })
                                    .attr("x2", function (d) {
                                        return d.target.x;
                                    })
                                    .attr("y2", function (d) {
                                        return d.target.y;
                                    });

                            //更新节点坐标
                            svg_nodes.attr("cx", function (d) {
                                return d.x;
                            })
                                    .attr("cy", function (d) {
                                        return d.y;
                                    });

                            //更新文字坐标
                            svg_texts.attr("x", function (d) {
                                return d.x;
                            })
                                    .attr("y", function (d) {
                                        return d.y;
                                    });
                        });


//                        svg_nodes.on("dblclick",
//                                function(){
//                                    alert("lll");
//                                }
//                        );

                        /*svg_nodes.on("dblclick", function () {
                            $("svg").empty();

                            alert(this.getAttribute("id"));

                            force = d3.layout.force()
                                    .nodes(nodes1)		//指定节点数组
                                    .links(edges1)		//指定连线数组
                                    .size([width, height])	//指定范围
                                    .linkDistance(100)	//指定连线长度
                                    .charge(-300);	//相互之间的作用力

                            force.start();	//开始作用

                            console.log(nodes1);
                            console.log(edges1);

                            //添加连线
                            svg_edges = svg.selectAll("line")
                                    .data(edges1)
                                    .enter()
                                    .append("line")
                                    .style("stroke", "#ccc")
                                    .style("stroke-width", 1);

                            color = d3.scale.category20();

                            //添加节点
                            svg_nodes = svg.selectAll("circle")
                                    .data(nodes1)
                                    .enter()
                                    .append("circle")
                                    .attr("r", 20)
                                    .attr("id",function (d) {
                                        return d.name;
                                    })
                                    .style("fill", function (d, i) {
                                        return color(i);
                                    })
                                    .call(force.drag);	//使得节点能够拖动

                            //添加描述节点的文字
                            svg_texts = svg.selectAll("text")
                                    .data(nodes1)
                                    .enter()
                                    .append("text")
                                    .style("fill", "black")
                                    .attr("dx", 20)
                                    .attr("dy", 8)
                                    .text(function (d) {
                                        return d.name;
                                    });

                            force.on("tick", function () {

                                //对于每一个时间间隔
                                //更新连线坐标
                                svg_edges.attr("x1", function (d) {
                                    return d.source.x;
                                })
                                        .attr("y1", function (d) {
                                            return d.source.y;
                                        })
                                        .attr("x2", function (d) {
                                            return d.target.x;
                                        })
                                        .attr("y2", function (d) {
                                            return d.target.y;
                                        });

                                var middleOne = 0;
                                //更新节点坐标
                                svg_nodes.attr("cx", function (d) {
                                    return d.x;
                                })
                                        .attr("cy", function (d) {
                                            return d.y;
                                        });

                                //更新文字坐标
                                svg_texts.attr("x", function (d) {
                                    return d.x;
                                })
                                        .attr("y", function (d) {
                                            return d.y;
                                        });
                            });
                        });*/

                    </script>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>
