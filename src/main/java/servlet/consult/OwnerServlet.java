package servlet.consult;

import utils.Web3Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OwnerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Web3Utils.verifyOwner(request.getParameter("hash"), request.getParameter("random"), request.getParameter("address"))) {
            request.setAttribute("result", "This assertion is valid.");
            request.setAttribute("assertion", request.getParameter("assertionString"));
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } else {
            request.setAttribute("result", "Sorry, this assertion is invalid or the verification is incorrect.");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
