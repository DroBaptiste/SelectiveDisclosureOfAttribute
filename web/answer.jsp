<%--
  Created by IntelliJ IDEA.
  User: dromard
  Date: 27/05/19
  Time: 16.19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Congratulation</title>
    <%@ include file="stylesheet.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
Congratulation, the transaction sent to ${address}
hash : "${hash}"!<br/>
Your assertion is at "${path}"<br/>
<%@ include file="javascript.jsp"%>
</body>
</html>
