package servlet.register;

import mock.MockTestLogin;
import utils.Account;
import utils.Randomizer;

import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("account") != null) {
            request.getRequestDispatcher("challenge.jsp").forward(request, response);
        } else if (request.getParameter("address") != null) {
            Account account = MockTestLogin.login(request.getParameter("address"), request.getParameter("password"));
            if (account != null) {
                session.setAttribute("account", account);

                /* Récupération de l'objet depuis la session */
                String chaine = (String) session.getAttribute("chaine");
                String code = Randomizer.randomAlphaNumeric(10);
                request.setAttribute("code", code);
                request.getRequestDispatcher("challenge.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Login/password invalid");
                request.getRequestDispatcher("check.jsp").forward(request, response);
            }
        }
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
    }

}
