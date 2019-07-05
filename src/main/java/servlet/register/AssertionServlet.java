package servlet.register;

import org.json.simple.JSONObject;
import utils.Account;
import utils.CryptoUtils;
import utils.Randomizer;
import utils.Web3Utils;
import utils.assertion.Assertion;
import utils.assertion.SamlVerificator;

import java.io.IOException;


public class AssertionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        SamlVerificator samlVerificator = new SamlVerificator();
        Assertion assertion;
        String token;
        String path;
        Account account = (Account) request.getSession().getAttribute("account");
        String address = account.getAddress();
        request.setAttribute("address", address);
        try {
            assertion = new Assertion("ENSICAEN", request.getParameter("assertion"), address , "365");
            path = assertion.getURL();
            String hash = CryptoUtils.sha256Payload(samlVerificator.getAssertion(path).getSamlString());
            token = Web3Utils.indexHash(hash);

            JSONObject credential = new JSONObject();
            credential.put("location", path);
            credential.put("token", token);

            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition","attachment; filename=\"" + "credential.json\"");
            response.getWriter().write(credential.toJSONString());

        } catch (Exception e) {
            request.setAttribute("error", "Error, can't handle the request : " + e);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String code = Randomizer.randomAlphaNumeric(10);
        request.setAttribute("code", code);
        request.getRequestDispatcher("choice.jsp").forward(request, response);
    }
}
