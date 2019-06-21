package servlet.consult;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.Web3Utils;
import utils.assertion.Assertion;
import utils.assertion.SamlVerificator;

import javax.servlet.http.Part;
import java.io.FileReader;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class AssertionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String path = (String) request.getAttribute("location");
        String hashBlockchain = (String) request.getAttribute("hash");
        response.getWriter().println(path + hashBlockchain);
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
