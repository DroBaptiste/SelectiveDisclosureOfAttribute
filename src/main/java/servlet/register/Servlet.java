package servlet.register;

import utils.Account;
import utils.CryptoUtils;
import utils.Randomizer;
import utils.Web3Utils;
import utils.assertion.Assertion;
import utils.assertion.SamlVerificator;

import java.io.IOException;
import java.math.BigInteger;


public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        SamlVerificator samlVerificator = new SamlVerificator();
        BigInteger balance = null;
        Assertion assertion;
        String hashBlockchain;
        String path = "";
        Account account = (Account) request.getSession().getAttribute("account");
        String address = account.getAddress();
        request.setAttribute("address", address);
        try {
            assertion = new Assertion("ENSICAEN", request.getParameter("assertion"), address);
            path = assertion.getURL();
            String payload = CryptoUtils.sha256Payload(address, samlVerificator.getAssertion(path).getSamlString(), path);
            hashBlockchain = Web3Utils.doTransaction(address, payload);
            request.setAttribute("hash", hashBlockchain);
            request.setAttribute("path", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (path.isEmpty()) {
            request.setAttribute("error", "Error, can't handle the request");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("answer.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String code = Randomizer.randomAlphaNumeric(10);
        request.setAttribute("code", code);
        request.getRequestDispatcher("challenge.jsp").forward(request, response);
    }
}
