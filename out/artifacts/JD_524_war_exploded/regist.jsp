<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>通勤记录登记</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="css/dmaku.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body class="login_bj" >
<div class="zhuce_body">
    ${message}
    <div class="logo"><a href="#"><img src="images/logo.png" border="0"></a></div>
    <div class="zhuce_kong">
        <div class="zc">
            <div class="bj_bai">
                <h3>通勤信息登记</h3>
                <form action="registServlet" method="post">
                    <input name="username" type="text" class="kuang_txt phone" placeholder="用户名">
                    <input name="userPassword" type="password" class="kuang_txt possword" placeholder="密码">
                    <input name="userPhone" type="text" class="kuang_txt phone" placeholder="手机号">
                    <input name="userEmail" type="text" class="kuang_txt email" placeholder="邮箱">
                    <input type="radio" name="userGender" value="1" style="margin-left: 30px;"><span>男</span>
                    <input type="radio" name="userGender" value="0" style="margin-left: 30px;"><span>女</span>
                    <!--
        <div>
            <input name="" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《江西联微使用协议》</span></a></span>
        </div>
        -->
                    <input name="submit" type="submit" class="btn_zhuce" value="登记">
                </form>
            </div>
            <!--
            <div class="bj_right">
             <p>已有账号，直接登录</p>
             <div>
                 <img src="images/logo-ecjtu.png" style="height: 150px;width:150px; margin-top: 60px;">
             </div>
             <p>已有账号？<a href="login.jsp">立即登录</a></p>

            </div>
            -->
        </div>
    </div>

</div>

</body>
</html>