<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>propertyhelp</title>
</head>
<body>
  ${property.id}<br
  ${property.projectId}<br>>
  ${property.groupName}<br>
  ${property.data}<br>
  <a href="<%=request.getContextPath()%>/">返回首页</a>
</body>
</html>
