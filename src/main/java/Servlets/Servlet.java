package Servlets;

import Backend.Assertion;
import Backend.XMLFileTreatment;
import Utils.Utils;
import Utils.Web3Utils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;


public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if(request.getParameter("code").equals(request.getParameter("inputCode"))) {
            BigInteger balance = null;
            Assertion assertion = null;
            try {
                assertion = new Assertion("ENSICAEN","Diplome d'ingénieur",request.getParameter("address"));
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            String path = null;
            try {
                path = XMLFileTreatment.StringToFile(assertion.getSamlString());
            } catch (SAXException | ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
            }
            try {
                balance = Web3Utils.getBalance(request.getParameter("address"));
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

            request.setAttribute("path", path);
            request.setAttribute("balance", balance);
            request.getRequestDispatcher("Checked.jsp").forward(request, response);
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
