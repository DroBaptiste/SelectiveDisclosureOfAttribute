package utils.assertion;

import org.xml.sax.SAXException;
import utils.CryptoUtils;
import utils.xml.XMLFileTreatment;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException, TransformerException {

        Assertion assertion = new Assertion("Driver class","Driver licence B","Dromard Baptiste","365");
        assertion.setTransactionID("XXXXX");
        System.out.println(assertion.getTransactionID());
    }
}
