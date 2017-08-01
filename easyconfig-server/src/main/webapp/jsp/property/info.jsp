<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>EasyConfig</title>
</head>
<body>
  <table>
    <thead></thead>
    <tbody>
      <tr>
        <td>项目编号:${property.projectId}</td>
        <td>分组名称:${property.groupName}</td>
      </tr>
      <c:forEach var="data" items="${property.metadataList}" varStatus="status">
        <tr>
          <td>${data.key}=${data.value}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="<%=request.getContextPath()%>/">返回首页</a>
</body>
</html>
