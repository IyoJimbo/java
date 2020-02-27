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






<div id="body-bg"></div>
<div class="clear"></div>
<canvas id="Mycanvas"></canvas>
<!-- reg modules -->
<div class="modal-dialog" style="width:520px;">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title"><a href="welcome.jsp" class="close"></a></h4>
        </div>

    </div>
</div>
<div class="zhuce_body">
    ${message}
    <div class="zhuce_kong">
        <div class="zc">
            <div class="bj_bai">
                <h3>通勤信息登记</h3>
                <form action="registServlet" method="post">
                    <div class="form-group">
                        <span style="width:2rem;float:left">用户名</span>
                    <input name="username" type="text" class="kuang_txt phone" placeholder="用户名" readonly="readonly" value="<%=request.getParameter("username")%>">
                    </div>
                    <input name="userDate" type="date" class="kuang_txt write" placeholder="通勤日期">
                    <input type="radio" name="userGender" value="1" style="margin-left: 30px;"><span>公交</span>
                    <input type="radio" name="userGender" value="2" style="margin-left: 15px;"><span>地铁</span>
                    <input type="radio" name="userGender" value="3" style="margin-left: 15px;"><span>出租车</span>
                    <input type="radio" name="userGender" value="0" style="margin-left: 15px;"><span>自驾</span>
                    <input name="userRoute" type="text" class="kuang_txt write" placeholder="路线/车牌号">
                    <input name="userBd_time" id="inputBdTime" type="time" class="kuang_txt write" placeholder="上车时间">
                    <input name="userBd_st" type="text" class="kuang_txt write" placeholder="上车地点/站">
                    <input name="userDrop_time" type="time" class="kuang_txt write" placeholder="下车时间">
                    <input name="userDrop_st" type="text" class="kuang_txt write" placeholder="下车地点/站)">
                    <input name="submit" type="submit" class="btn_zhuce" value="登记">
                </form>
             </div>
        </div>
    </div>

</div>

</body>
</html>
