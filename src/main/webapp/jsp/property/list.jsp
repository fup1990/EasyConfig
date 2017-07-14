<%--
  Created by IntelliJ IDEA.
  User: fupeng-ds
  Date: 2017/6/14
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>propertyhelp</title>
</head>
<body>
  <table>
    <c:forEach items="${list}" var="property" varStatus="vs">
      <tr>
        <td>${property.projectId}</td>
        <td>${property.groupName}</td>
        <td><a href="<%=request.getContextPath() %>/info?id=${property.id}">查看</a></td>
        <td><a href="<%=request.getContextPath() %>/edit?id=${property.id}">编辑</a></td>
      </tr>
    </c:forEach>
  </table>
  <a href="<%=request.getContextPath()%>/">返回首页</a>
</body>
</html>
