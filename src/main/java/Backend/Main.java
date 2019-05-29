package Backend;

import Utils.CryptoUtils;
import org.apache.log4j.BasicConfigurator;
import org.joda.time.DateTime;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.impl.ResponseMarshaller;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SAXException, TransformerException, ParserConfigurationException, IOException, NoSuchAlgorithmException {
        Assertion assertion = new Assertion("ENSICAEN","Diplome d'ingénieur","Baptiste Dromard");
        assertion.setURL(XMLFileTreatment.StringToFile(assertion.generateSAML()));
        System.out.println(CryptoUtils.sha256Payload(assertion.getBlockchainAddressOfSubject(),assertion.generateSAML(),assertion.getURL()));
    }
}