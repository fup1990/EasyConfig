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
    <title>EasyConfig</title>
</head>
<body>
  <form action="<%=request.getContextPath()%>/save">
    <input type="hidden" name="id" value="${property.id}"><br>
    项目编号:<input type="text" name="projectId" value="${property.projectId}"><br>
    分组名称:<input type="text" name="groupName" value="${property.groupName}"><br>
    内容:<textarea name="data" id="data"></textarea>
    <textarea id="hidden" style="display: none">
      <c:forEach items="${property.metadataList}" varStatus="status" var="data">
        ${data.key} = ${data.value};
      </c:forEach>
    </textarea>
    <input type="submit" value="保存">
    <input type="button" value="返回">
  </form>
</body>
</html>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script>
  $(function() {
    var str = '';
    var text = $('#hidden').text();
    var split = text.split(";");
    for (var i = 0; i < split.length; i++) {
      str += split[i].trim() + '\n';
    }
    $('#data').text(str);
  })
</script>
