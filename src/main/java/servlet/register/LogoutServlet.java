package servlet.register;

import java.io.IOException;


public class LogoutServlet extends javax.servlet.http.HttpServlet {



    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getSession().removeAttribute("account");
        request.getSession().invalidate();
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
