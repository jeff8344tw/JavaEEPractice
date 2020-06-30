<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/6/30
  Time: 上午 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- 因為使用了forward標籤，所以該頁面中的內容不會顯示 --%>
    forward.jsp
    <%
        request.setAttribute("name", "jeff"); 
    %>
    <jsp:forward page="/next.jsp"></jsp:forward>
</body>
</html>
