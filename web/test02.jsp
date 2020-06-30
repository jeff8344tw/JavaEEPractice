<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/6/30
  Time: 上午 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 如果當前頁面發生異常之後，會跳轉到指定的jsp頁面上 -->
<%@ page errorPage="/error.jsp" %>
<!-- 默認為true，若不想使用session對象可將其設為false -->
<%@ page session="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println(10/0);
    %>
</body>
</html>
