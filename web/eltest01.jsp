<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/6/30
  Time: 上午 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.jeff.servlet.bean.*"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("name", "page");
        request.setAttribute("name1", "request");
        session.setAttribute("name2", "session");
        application.setAttribute("name3", "application");
    %>
    ${name} ${name1} ${name2} ${name3}
    <!-- 使用域屬性空間相關的內置對象獲取數據 -->
    ${pageScope.name}
    ${requestScope.name1}
    ${sessionScope.name2}
    ${applicationScope.name3}
    <!-- 訪問bean屬性 -->
    <%
        Student student = new Student("jeff", 26);
        request.setAttribute("student", student);
    %>
    ${student.name}
    <br>
    ${student.age}
    ${student["name"]}

    <%
        School school = new School("123", student);
        request.setAttribute("school", school);
    %>
    從school中取得的學生姓名: ${school.student.name}

</body>
</html>
