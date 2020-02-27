
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
    <base >
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">

    <title>通勤情况登记系统</title>
    <link rel="stylesheet" type="text/css" href="styles/edumis.css">
    <link rel="stylesheet" type="text/css" href="styles/login.css">

    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="styles/hack/ie6.css" /><![endif]-->
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="styles/hack/ie7.css" /><![endif]-->
    <!--[if IE 8]><link rel="stylesheet" type="text/css" href="styles/hack/ie8.css" /><![endif]-->
    <style type="text/css">
        #Mycanvas{
            text-align: center;
            overflow: hidden;
        }
    </style>
</head>
<body>
<div id="body-bg"></div>
<div class="clear"></div>
<canvas id="Mycanvas"></canvas>
<div class="panel login center-block">
    <div id="logo">
        <h3 style="margin-left:150px;font-size: 16px;margin-bottom: 20px;">通勤情况登记系统</h3>
    </div>
    ${message}
    <!--  login modules  -->
    <form  id="login-action" action="testServlet" method="post">
        <div class="form-group">
            <label for="inputUser" class="control-label">用户名：</label>
            <div class="form-item">
                <input type="text" class="form-control normal" id="inputUser" value="" name="username" placeholder="姓名">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label">密&nbsp;&nbsp;&nbsp;码：</label>
            <div class="form-item">
                <input type="password" class="form-control normal" id="inputPassword" value="" name="password" placeholder="请输入密码" >
            </div>
        </div>
        <div class="form-group">
            <label  class="control-label">  </label>
            <div class="form-item">
                <input id="log" type="submit" value="登录" class="btn btn-success">
            </div>
        </div>
        <div class="clear"></div>
    </form>
    <div class="clear"></div>
</div>
<!-- reg modules -->
<div class="modal-dialog" style="width:520px;">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title"><a href="welcome.jsp" class="close"></a></h4>
        </div>

    </div>
</div>

</body>


</html>