<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/7/1
  Time: 下午 06:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://localhost/jsp/jeffeltld" prefix="jeffellib" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${pageContext.request}<br>
    ${pageContext.request.contextPath}<br>

    <form action="${pageContext.request.contextPath}/showBookServlet"></form>

    <!-- ?name=???&hobby=???&hobby=???-->
    ${param.name}<br>
    ${paramValues.hobby[0]}<br>
    ${paramValues.hobby[1]}<br>

    <!-- 獲取web.xml中的初始化參數值-->
    ${initParam.admin}

    ${jeffellib:toUpper("jeff")}

</body>
</html>
