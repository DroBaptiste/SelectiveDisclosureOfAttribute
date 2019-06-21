<%--
  Created by IntelliJ IDEA.
  User: dromard
  Date: 04/06/19
  Time: 18.01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Look at the accounts</title>
    <%@ include file="stylesheet.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container">${accountList}</div>
<%@ include file="javascript.jsp" %>
</body>
</html>
