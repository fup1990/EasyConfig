<%--
  Created by IntelliJ IDEA.
  User: fupeng-ds
  Date: 2017/6/14
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>propertyhelper</title>
</head>
<body>
  <form action="<%=request.getContextPath()%>/save">
    <input type="hidden" name="id" value="${property.id}"><br>
    项目编号:<input type="text" name="projectId" value="${property.projectId}"><br>
    分组名称:<input type="text" name="groupName" value="${property.groupName}"><br>
    内容:<textarea name="data">${property.data}</textarea>
    <input type="submit" value="保存">
    <input type="button" value="返回">
  </form>
</body>
</html>
