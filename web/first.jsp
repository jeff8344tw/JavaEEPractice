<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/6/29
  Time: 下午 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date date = new Date();
        out.write(date.toLocaleString());
    %>
</body>
</html>
