package utils.assertion;

import org.xml.sax.SAXException;
import utils.CryptoUtils;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException, TransformerException {

        Assertion assertion = new Assertion("Driver class","Driver licence B","Dromard Baptiste","365");
        SamlVerificator samlVerificator = new SamlVerificator();
        Assertion assertion1 = new Assertion();
        assertion1 = samlVerificator.getAssertion(assertion.getURL());
        System.out.println(CryptoUtils.dateExpiration(assertion.getIssueInstant(),assertion.getValidity()));
    }
}
