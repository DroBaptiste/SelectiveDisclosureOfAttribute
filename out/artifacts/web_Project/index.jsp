<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Providing an assertion</title>
    <%@ include file="stylesheet.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container">

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
    <div class="col darken-1">
        <form class="col" action="request?action=L" method="post">

            <div class='row'>
                <div class='input-field '>
                    <i class="material-icons prefix">account_circle</i>
                    <input class='validate darken-1' type='text' name='address' id='email'/>
                    <label for='email'>Enter your blockchain address</label>
                </div>
            </div>

            <div class='row'>
                <div class='input-field '>
                    <i class="material-icons prefix">lock</i>
                    <input class='validate darken-1' type='password' name='password' id='password'/>
                    <label for='password'>Enter your password</label>
                </div>
            </div>
            <br/>
            <button type='submit' name='btn_login' class='btn btn-large waves-effect'>Login</button>
        </form>
    </div>
    <div class="col hoverable">
        <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title">How to do</span>
                <p>You can get an attribute for the needed account. for more information about accounts just look at
                    Account page.</p>
            </div>
        </div>
    </div>
</div>
<%@ include file="javascript.jsp" %>
</body>
</html>