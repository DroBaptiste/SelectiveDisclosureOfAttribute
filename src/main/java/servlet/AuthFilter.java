package servlet;

import utils.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = ((HttpServletRequest) request).getSession();
        Account account = null;

        if (session != null) {
            account = (Account) session.getAttribute("account");
        }
        boolean isLoggedIn = (account != null);
        if (req.getRequestURI().equals(
                req.getContextPath() + "/index.jsp")) {
            if (isLoggedIn) {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath()
                        + "/choice.jsp");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (isLoggedIn) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath() + "/index.jsp");
            }
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public boolean isLoggable(LogRecord record) {
        return false;
    }
}