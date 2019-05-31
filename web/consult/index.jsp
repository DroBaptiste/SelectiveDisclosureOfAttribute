<%--
  Created by IntelliJ IDEA.
  User: dromard
  Date: 31/05/19
  Time: 13.47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home consulting</title>
</head>
<body>
<form action="./servlet" method="post">
    URL of the assertion :
    <input type="text" placeholder="Assertions URL" name="url"></br>
    Transaction Number :
    <input type="text" placeholder="Transaction Number" name="hash">
    <input type="submit" value="Press">
</form>
</body>
</html>
