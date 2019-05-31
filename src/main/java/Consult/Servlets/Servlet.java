package Consult.Servlets;

import Register.Backend.Assertion;
import Utils.SP.SamlVerificator;
import Utils.Web3Utils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String path = request.getParameter("url");
        String hashBlockchain = request.getParameter("hash");
        String content = "";
        String address = "";
        String hash = "";
        SamlVerificator samlVerificator = new SamlVerificator();
        try {
            Assertion assertion = samlVerificator.getAssertion(path);
            address = assertion.getBlockchainAddressOfSubject();
            hash = "0x" + Utils.CryptoUtils.sha256Payload(address, assertion.getSamlString(), path);
            request.setAttribute("address", address);
            request.setAttribute("path", path);
            request.setAttribute("hash", hash);
        } catch (ParserConfigurationException | SAXException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if(Web3Utils.verifyAssertion(hashBlockchain, hash)) {
            request.setAttribute("result", "The assertion is valid");

        } else {
            request.setAttribute("result", "The assertion is invalid");
        }
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException {
    }
}
