<%--
  Created by IntelliJ IDEA.
  User: dromard
  Date: 27/05/19
  Time: 16.02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Challenge</title>
</head>
<body>
    <form action="./test" method="post">
        <input type="text" placeholder="ETH adress" name="text"></br>
        Tapez le code suivant : ${code} </br>
        <input type="hidden" name="inputCode" value=${code} />
        <input type="text" placeholder="code" name="code">
        <input type="submit" value="Press">
    </form>
</body>
</html>
