<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/6/30
  Time: 上午 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    系統異常
    <!-- 需要先設置isErrorPage="true",否則無法使用exception對象 -->
    <%
        exception.printStackTrace();
    %>
</body>
</html>
