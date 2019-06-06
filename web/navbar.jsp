<nav>
    <div class="nav-wrapper blue-grey darken-1">
        <a href="index.jsp" class="brand-logo center"><i class="material-icons">link</i>SDA</a>
        <ul id="nav-mobile" class="left hide-on-med-and-down">
            <li><a href="request?action=A">Account</a></li>
            <li><a href="about.jsp">About</a></li>
            <li><a href="request?action=check">Verify an assertion</a></li>
        </ul>
        <%
            if (request.getSession().getAttribute("account") != null)
            {
        %>
            <ul id="nav-mobile2" class="right hide-on-med-and-down">
                <li><p>Connected with address ${account.getAddress()}</p></li>
                <li><a href="request?action=D">Logout</a></li>
            </ul>
        <% }
        %>
    </div>
</nav>
