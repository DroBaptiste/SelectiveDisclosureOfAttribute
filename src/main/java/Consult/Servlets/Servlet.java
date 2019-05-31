package Consult.Servlets;

import java.io.IOException;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String url = request.getParameter("url");
        String hash = request.getParameter("hash");
        if(true) {
            request.setAttribute("result", "The assertion is valid");
        } else {
            request.setAttribute("result", "The assertion is invalid");
        }
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException {
    }
}
