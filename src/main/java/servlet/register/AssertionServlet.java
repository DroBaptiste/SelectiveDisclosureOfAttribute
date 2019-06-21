package servlet.register;

import org.json.simple.JSONObject;
import utils.*;
import utils.assertion.Assertion;
import utils.assertion.SamlVerificator;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;


public class AssertionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        SamlVerificator samlVerificator = new SamlVerificator();
        Assertion assertion;
        String hashBlockchain;
        String path = "";
        Account account = (Account) request.getSession().getAttribute("account");
        String address = account.getAddress();
        request.setAttribute("address", address);
        try {
            assertion = new Assertion("ENSICAEN", request.getParameter("assertion"), address , "365");
            path = assertion.getURL();
            String payload = CryptoUtils.sha256Payload(address, samlVerificator.getAssertion(path).getSamlString(), path);
            hashBlockchain = Web3Utils.doTransaction(address, payload);

            request.setAttribute("hash", hashBlockchain);
            request.setAttribute("path", path);



            JSONObject credentials = new JSONObject();
            credentials.put("hash", hashBlockchain);
            credentials.put("location", path);

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.getWriter().write(credentials.toJSONString());

        } catch (Exception e) {
            request.setAttribute("error", "Error, can't handle the request : " + e);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
            //request.getRequestDispatcher("answer.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String code = Randomizer.randomAlphaNumeric(10);
        request.setAttribute("code", code);
        request.getRequestDispatcher("choice.jsp").forward(request, response);
    }
}
