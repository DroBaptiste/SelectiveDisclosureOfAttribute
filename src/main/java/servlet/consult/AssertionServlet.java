package servlet.consult;

import utils.Web3Utils;

import java.io.IOException;

public class AssertionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String url = (String) request.getAttribute("location");
        String token = (String) request.getAttribute("token");

        try {
            if (Web3Utils.verifyAssertion(token, url)) {
                request.setAttribute("result", true);
                request.setAttribute("random", "0x12");
                request.getRequestDispatcher("owner.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "invalid assertion " + url);
                request.getRequestDispatcher("verification.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            request.getRequestDispatcher("verification.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

    }
}
