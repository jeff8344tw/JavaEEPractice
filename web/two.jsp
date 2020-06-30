<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/6/30
  Time: 上午 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int sum = 100;
    %>
    <!-- 動態引入會生成兩個不同的java servlet -->
    <jsp:include page="one.jsp" />
    <br>
    two sum = <%=sum  %>
</body>
</html>
