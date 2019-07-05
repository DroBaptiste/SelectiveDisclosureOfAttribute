package servlet.register;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utils.Account;
import utils.CryptoUtils;
import utils.Randomizer;
import utils.Web3Utils;
import utils.assertion.Assertion;
import utils.assertion.SamlVerificator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;


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
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/home/dromard/Documents/JAva/apache-tomcat-9.0.20/bin/config.json"));

            JSONObject jsonObject =  (JSONObject) obj;
            String domain = (String) jsonObject.get("domain");
            path = assertion.getURL();
            String hash = CryptoUtils.sha256Payload(samlVerificator.getAssertion(Paths.get("").toAbsolutePath().toString() + File.separator + path).getSamlString());
            token = Web3Utils.indexHash(hash);

            JSONObject credential = new JSONObject();
            credential.put("location", domain + File.separator + path);
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
