<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/6/30
  Time: 上午 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- html註釋 -->
    <%-- jsp註釋 --%>
    <%--
        聲明變量不能添加訪問修飾符
        不能定義方法
        不能定義靜態語句塊
    --%>
    <%
        int i = 0;
    %>
    <%
        out.write(i);
    %>
    <%!
        public void m1() {
            System.out.println("m1");
        }
    %>
    <%-- 直接在頁面輸出 %-->
    <%=i %>
    <%="test" %>
</body>
</html>
