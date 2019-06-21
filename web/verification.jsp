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
    <%@ include file="stylesheet.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp" %>
${error}
<form action="request?action=U" method="post" enctype="multipart/form-data">
    <input type="file" name="assertion">
    <input type="submit" value="Press">
</form>

<%@ include file="javascript.jsp" %>
</body>
</html>
