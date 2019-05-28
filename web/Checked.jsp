<jsp:useBean id="balance" scope="request" type="java.math.BigInteger"/>
<%--
  Created by IntelliJ IDEA.
  User: dromard
  Date: 27/05/19
  Time: 16.19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Congratulation</title>
</head>
<body>
    Congratulation, the transaction will (one day) be sent to <%= request.getParameter("address") %> !
You have ${balance} ETH !
</body>
</html>
