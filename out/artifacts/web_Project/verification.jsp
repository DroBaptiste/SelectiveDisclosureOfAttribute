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


<div class="col">
    <div class="card blue-grey darken-1">
        <div class="card-content white-text">
            <%
                if (request.getAttribute("error") != null) {
            %>
            <div class="card red darken-1">
                <div class="card-content white-text">
                    <p>${error}</p>
                </div>
            </div>
            <%
                }
            %>
            <form action="request?action=U" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit"/>
            </form>
        </div>
    </div>
</div>

<%@ include file="javascript.jsp" %>
</body>
</html>
