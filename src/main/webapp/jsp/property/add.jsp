<%--
  Created by IntelliJ IDEA.
  User: fupeng-ds
  Date: 2017/6/14
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
  <form action="<%=request.getContextPath()%>/property/save">
    项目编号:<input type="text" name="projectId" value=""><br>
    分组名称:<input type="text" name="groupName" value=""><br>
    内容:<textarea name="data"></textarea>
    <input type="submit" value="保存">
    <input type="button" value="返回">
  </form>
</body>
</html>
