<%--
  Created by IntelliJ IDEA.
  User: fupeng-ds
  Date: 2017/6/14
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>EasyConfig</title>
</head>
<body>
  <form action="<%=request.getContextPath()%>/search" method="post">
    <table>
      <thead>EasyConfig</thead>
      <tbody>
        <tr>
          <td>项目编号:</td>
          <td><input name="projectId" value=""></td>
        </tr>
        <tr>
          <td>分组名称:</td>
          <td><input name="groupName" value=""></td>
        </tr>
        <tr>
          <td><input type="submit" value="查询"></td>
          <td><input type="button" id="add" value="新建" onclick="addProperty()"></td>
        </tr>
      </tbody>
    </table>
  </form>
</body>
</html>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
  function addProperty() {
    window.location.href='<%=request.getContextPath()%>/add';
  }
</script>

