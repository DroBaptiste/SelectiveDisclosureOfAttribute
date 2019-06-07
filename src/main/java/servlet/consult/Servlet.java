package servlet.consult;

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
            request.setAttribute("assertion", assertion);
            request.setAttribute("assertionString", "Issuer : " + assertion.getAttributeProvider() +  "<br/>" + "Value : " + assertion.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Web3Utils.verifyAssertion(hashBlockchain, hash)) {
            request.setAttribute("result", true);

        } else {
            request.setAttribute("result", false);
        }
        request.setAttribute("random", "0x12");
        request.getRequestDispatcher("owner.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
    }
}
