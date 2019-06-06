package consult.servlets;

import utils.Web3Utils;
import utils.assertion.Assertion;
import utils.assertion.SamlVerificator;

import java.io.IOException;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String path = request.getParameter("url");
        String hashBlockchain = request.getParameter("hash");
        String content = "";
        String address;
        String hash = "";
        SamlVerificator samlVerificator = new SamlVerificator();
        try {
            Assertion assertion = samlVerificator.getAssertion(path);
            address = assertion.getBlockchainAddressOfSubject();
            hash = "0x" + utils.CryptoUtils.sha256Payload(address, assertion.getSamlString(), path);
            request.setAttribute("address", address);
            request.setAttribute("path", path);
            request.setAttribute("hash", hash);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Web3Utils.verifyAssertion(hashBlockchain, hash)) {
            request.setAttribute("result", "The assertion is valid");

        } else {
            request.setAttribute("result", "The assertion is invalid");
        }
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
    }
}
