<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/7/1
  Time: 下午 08:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date date = new Date();
        pageContext.setAttribute("date", date);
    %>
    <!-- formatDate -->
    ${date}<br>
    <form>
        <!-- 在頁面中直接顯示 -->
        <fmt:formatDate value="${date}" pattern="yyyy-MM-dd" /><br>
        <!-- 將格式化後的日期保存到變量中 -->
        <fmt:formatDate value="${date}" var="birth" pattern="yyyy-MM-dd" /><br>
        <input type="text" name="birthday" value="${birth}" >
    </form>
    <br>
    <!-- parseDate -->
    <%
        String dateStr = "2019-07-01";
        pageContext.setAttribute("dateStr", dateStr);
    %>
    <fmt:parseDate value="${dateStr}" pattern="yyyy-MM-dd"></fmt:parseDate>
</body>
</html>
