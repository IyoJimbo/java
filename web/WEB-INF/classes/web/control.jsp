<%@ page import="javax.print.attribute.standard.RequestingUserName" %><%--
  Created by IntelliJ IDEA.
  User: RunWsh
  Date: 2019/5/27
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理登入页面信息的请求</title>
</head>
<body>
    <%--获得上一个页面的请求信息--%>
    <%
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("pwd");
//        如果账号匹配成功，那么转发页面信息到下一个页面welcome.jsp,否则失败重定向再次登入
        if ("admin".equals(username)&&"admin".equals(password)){
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }else {
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
