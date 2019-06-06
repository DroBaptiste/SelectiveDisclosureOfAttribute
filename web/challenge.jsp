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
    <title>Providing an assertion</title>
    <%@ include file="stylesheet.jsp"%>
<body>

<%@ include file="navbar.jsp"%>
    <div class="container">
    <div class="col darken-1">
        <form class="col" action="assertion" method="post">

            <div class='row'>
                <p>
                    <label>
                        <input name="assertion" type="radio" value="driver" checked />
                        <span>Driver License</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input name="assertion" type="radio" name="adult" />
                        <span>Adult proof</span>
                    </label>
                </p>
            </div>

            <br/>
            <button type='submit' name='btn_login' class='btn btn-large waves-effect'>Get assertion</button>
        </form>
    </div>
    </div>

<%@ include file="javascript.jsp"%>
</body>
</html>
