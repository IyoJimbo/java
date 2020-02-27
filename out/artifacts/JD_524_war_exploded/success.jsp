<%--
  Created by IntelliJ IDEA.
  User: Iyo
  Date: 2020-2-23
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<label>姓名：</label>
<%=request.getParameter("username")%>
<label>日期：</label>
<%=request.getParameter("userDate")%>
<label>登记成功</label>
</body>
<head>
    <title>登记成功</title>
</head>
</html>