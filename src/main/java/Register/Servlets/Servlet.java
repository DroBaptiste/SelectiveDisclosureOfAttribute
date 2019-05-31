package Register.Servlets;

import Register.Backend.Assertion;
import Utils.CryptoUtils;
import Utils.Utils;
import Utils.Web3Utils;

import java.io.IOException;
import java.math.BigInteger;


public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if(request.getParameter("code").equals(request.getParameter("inputCode"))) {
            BigInteger balance = null;
            Assertion assertion = null;
            String hashBlockchain;
            String path = "";
            String address = request.getParameter("address");
            try {
                assertion = new Assertion("ENSICAEN","Diplome d'ingénieur", address);
                path = assertion.getURL();
                String payload = CryptoUtils.sha256Payload(address, assertion.getSamlString(), path);
                hashBlockchain = Web3Utils.doTransaction(address, payload);
                request.setAttribute("address", address);
                request.setAttribute("path", path);
                request.setAttribute("hash", hashBlockchain);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (path.isEmpty()) {
                request.setAttribute("error", "Error, can't handle the request");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("answer.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("error", "Error, wrong check code");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String code = Utils.randomAlphaNumeric(10);
        request.setAttribute("code", code);
        request.getRequestDispatcher("challenge.jsp").forward(request, response);
    }
}
