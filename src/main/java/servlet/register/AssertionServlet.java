package servlet.register;

import org.json.simple.JSONObject;
import utils.Account;
import utils.CryptoUtils;
import utils.Web3Utils;
import utils.assertion.Assertion;
import utils.assertion.SamlVerificator;
import utils.config.SetConfig;

import java.io.IOException;


public class AssertionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        SamlVerificator samlVerificator = new SamlVerificator();
        Assertion assertion;
        String token;
        String fileName;
        Account account = (Account) request.getSession().getAttribute("account");
        String address = account.getAddress();
        request.setAttribute("address", address);
        try {
            assertion = new Assertion("ENSICAEN", request.getParameter("assertion"), address , "365");
            String domain = new SetConfig().getDomain();
            System.out.println(domain);
            fileName = assertion.getURL();
            System.out.println(fileName);
            String hash = CryptoUtils.sha256Payload(samlVerificator.getAssertionOnline(domain + "/" + fileName).getSamlString());
            token = Web3Utils.indexHash(hash);

            JSONObject credential = new JSONObject();
            credential.put("location", domain + "/" + fileName);
            credential.put("token", token);

            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition","attachment; filename=\"" + "credential.json\"");
            response.getWriter().write(credential.toJSONString());

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error, can't handle the request : " + e);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
}
