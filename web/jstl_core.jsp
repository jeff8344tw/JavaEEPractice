<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/7/1
  Time: 下午 07:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.jeff.servlet.bean.Student" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- c:out標籤 -->
    <%
        pageContext.setAttribute("user", "admin");
    %>
    el表達式:${user}<br>
    使用c:out標籤:<c:out value="${user}"></c:out>

    <!-- c:catch標籤 -->
    <c:catch var="e">
        ${pageContext.name}<br>
    </c:catch>
    <!-- 錯誤訊息 -->
    ${e.message}<br>

    <!-- c:if標籤 -->
    <c:if test="${user == 'admin'}" var="falg">
        歡迎登入
        ${flag}
    </c:if>

    <!-- c:choose標籤 -->
    <%
        pageContext.setAttribute("hobby", "basketball");
    %>

    <c:choose>
        <c:when test="${hobby == 'basketball'}">
            I like basketball
        </c:when>
        <c:when test="${hobby == 'football'}">
            I like football
        </c:when>
        <c:when test="${hobby == 'volleyball'}">
            I like volleyball
        </c:when>
        <c:otherwise>
            I don't have hobby
        </c:otherwise>
    </c:choose>

    <!-- c:forEach標籤 -->
    <br>----------遍歷數組-----------<br>
    <%
        Object[] city = {"city1", "city2", "city3", "city4"};
        pageContext.setAttribute("city", city);
    %>
    <c:forEach items="${city}" var="c">
        ${c}<br>
    </c:forEach>

    <br>----------遍歷list-----------<br>
    <%
        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        pageContext.setAttribute("names", names);
    %>

    <c:forEach items="${names}" var="name">
        ${name}<br>
    </c:forEach>

    <br>----------遍歷map-----------<br>
    <%
        Map<String, String> map = new HashMap<>();
        map.put("1","11");
        map.put("2","22");
        map.put("3","33");
        map.put("4","44");
        pageContext.setAttribute("map", map);
    %>
    <c:forEach items="${map}" var="m">
        ${m.key}:${m.value}<br>
    </c:forEach>

    <!-- 指定遍歷的起始索引即步長 -->
    <%
        Object[] country = {"country1","country2","country3","country4","country5","country6","country7","country8","country8"};
        pageContext.setAttribute("country", country);
    %>

    <c:forEach items="${country}" var="c" begin="1" end="4">
        ${c}<br>
    </c:forEach>

    <c:forEach items="${country}" var="c" begin="1" end="7" step="2">
        ${c}<br>
    </c:forEach>

    <!-- varStatus -->
    <%
        List<Student> students = new ArrayList<>();
        students.add(new Student("name1", 1));
        students.add(new Student("name2", 2));
        students.add(new Student("name3", 3));
        students.add(new Student("name4", 4));
        students.add(new Student("name5", 5));
        students.add(new Student("name6", 6));
        students.add(new Student("name7", 7));
        students.add(new Student("name8", 8));
        pageContext.setAttribute("students", students);
    %>

    <table border="1">
        <tr>
            <td>序號</td>
            <td>姓名</td>
            <td>年齡</td>
        </tr>
        <c:forEach items="${students}" var="student" varStatus="obj">
            <tr style="background-color: ${obj.index % 2 == 0?'orange':'red'}">
                <td>${obj.count}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
