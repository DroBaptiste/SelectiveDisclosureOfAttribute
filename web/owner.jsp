<%--
  Created by IntelliJ IDEA.
  User: dromard
  Date: 07/06/19
  Time: 10.11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Challenge/response</title>
    <%@ include file="stylesheet.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp" %>

<form action="request?action=O" method="post">
    Prove that you own the adress ${address} : <br/>
    Encrypt this random text "${random}" : <br/>
    <input type="hidden" name="random" value="${random}">
    <input type="text" placeholder="Transaction Number" name="hash">
    <input type="submit" value="Press">
</form>

<%@ include file="javascript.jsp" %>
</body>
</html>
