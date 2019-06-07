package servlet;

import java.io.IOException;


public class ServletDispatcher extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "L":
                request.getRequestDispatcher("login").forward(request, response);
                break;
            case "A":
                request.getRequestDispatcher("account").forward(request, response);
                break;
            case "C":
                request.getRequestDispatcher("challenge").forward(request, response);
                break;
            case "D":
                request.getRequestDispatcher("logout").forward(request, response);
                break;
            case "check":
                request.getRequestDispatcher("check.jsp").forward(request, response);
                break;
            case "R":
                request.getRequestDispatcher("result").forward(request, response);
                break;
            case "O":
                request.getRequestDispatcher("owner").forward(request, response);
                break;
            default:
                break;
        }
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "L":
                request.getRequestDispatcher("login").forward(request, response);
                break;
            case "A":
                request.getRequestDispatcher("account").forward(request, response);
                break;
            case "C":
                request.getRequestDispatcher("challenge").forward(request, response);
                break;
            case "D":
                request.getRequestDispatcher("logout").forward(request, response);
                break;
            case "check":
                request.getRequestDispatcher("check.jsp").forward(request, response);
                break;
            case "R":
                request.getRequestDispatcher("result").forward(request, response);
                break;
            case "O":
                request.getRequestDispatcher("owner").forward(request, response);
            default:
                break;
        }
    }

}
