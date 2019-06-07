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
    Send this random text to the address 0x8fa7173202d86C746bd884C9f116E356600c6b0E "${random}" : <br/>
    <input type="hidden" name="random" value="${random}">
    <input type="hidden" name="address" value="${address}">
    <input type="hidden" name="assertionString" value="${assertionString}">
    <input type="text" placeholder="Transaction Number" name="hash">
    <input type="submit" value="Press">
</form>

<%@ include file="javascript.jsp" %>
</body>
</html>
