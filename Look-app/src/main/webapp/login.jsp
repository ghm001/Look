<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="img/login/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Get Shit Done Bootstrap Wizard by Creative Tim</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

    <!-- CSS Files -->
    <link href="css/login/bootstrap.min.css" rel="stylesheet" />
    <link href="css/login/gsdk-bootstrap-wizard.css" rel="stylesheet" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="css/login/demo.css" rel="stylesheet" />

    <style>
        .wizard-card .picture-src {
            width: 100%;
            height: 100%;
        }
    </style>
</head>

<body>
<div class="image-container set-full-height" style="background-image: url('img/login/wizard-boat.jpg')">
    <!--  Made With Get Shit Done Kit  -->
    <a href="#/get-shit-done/index.html?ref=get-shit-done-bootstrap-wizard" class="made-with-mk">
        <div class="brand">GK</div>
        <div class="made-with">Made with <strong>GSDK</strong></div>
    </a>
    <!--   Big container   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <!--      Wizard container        -->
                <div class="wizard-container">
                    <div class="card wizard-card" data-color="orange" id="wizardProfile">
                        <form action="LoginServlet" method="get">
                            <!--        You can switch ' data-color="orange" '  with one of the next bright colors: "blue", "green", "orange", "red"          -->
                            <div class="wizard-header">
                                <h3>
                                    <b>构建</b>您的个人资料<br>
                                    <small>这个信息用来进行身份核验</small>
                                </h3>
                            </div>
                            <div class="wizard-navigation">
                                <ul>
                                    <li><a href="#about" data-toggle="tab">登录界面</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane" id="about">
                                    <div class="row">
                                        <h4 class="info-text">账号登录</h4>
                                        <div class="col-sm-4 col-sm-offset-1">
                                            <div class="picture-container">
                                                <div class="picture">
                                                    <img src="img/login/default-avatar.png" class="picture-src" id="wizardPicturePreview" title=""/>
                                                    <input type="file" id="wizard-picture">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>账号</label>
                                                <input name="loginname" type="text" class="form-control" placeholder="Andrew...">
                                            </div>
                                            <div class="form-group">
                                                <label>密码</label>
                                                <input name="password" type="text" class="form-control" placeholder="Smith...">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="wizard-footer height-wizard">
                                <div class="pull-right">
                                    <input type='button' class='btn btn-fill btn-warning btn-wd btn-sm' name='next' value='还没有账号？点击立即注册!'
                                           onclick="javascript:location.href='register.jsp'"/>
                                    <%--<script>
                                        function register(){
                                            var info = {
                                                'userName':$("#loginname").val(),
                                                'passWord':$("#password").val(),
                                            };
                                            $.ajax({
                                                url:'http://192.168.43.204:8080//look/adminB/UserNameLogin',
                                                dataType:'json',
                                                data:info,
                                                success:function (data) {
                                                    if(data.tag == "error"){
                                                        alert("登陆失败");
                                                    }
                                                    else if(data.tag == "success"){
                                                        javascript:location.href='pictureManage.jsp';
                                                    }

                                                }
                                            })
                                        }
                                        </script>--%>
                                    <input type='submit' class='btn btn-finish btn-fill btn-warning btn-wd btn-sm' name='finish' value='登录'
                                           onclick="javascript:location.href='initialize.jsp'"/>
                                </div>
                                <div class="pull-left">
                                    <input type='button' class='btn btn-previous btn-fill btn-default btn-wd btn-sm' name='previous' value='Previous' />
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div> <!-- wizard container -->
            </div>
        </div><!-- end row -->
    </div> <!--  big container -->
</div>
</body>

<!--   Core JS Files   -->
<script src="js/login/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="js/login/bootstrap.min.js" type="text/javascript"></script>
<script src="js/login/jquery.bootstrap.wizard.js" type="text/javascript"></script>

<!--  Plugin for the Wizard -->
<script src="js/login/gsdk-bootstrap-wizard.js"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="js/login/jquery.validate.min.js"></script>

</html>
