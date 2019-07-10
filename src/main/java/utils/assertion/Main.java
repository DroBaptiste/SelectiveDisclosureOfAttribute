package utils.assertion;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException, TransformerException, ParseException {

        Assertion assertion = new Assertion("Driver class","Driver licence B","Dromard Baptiste","365");
        assertion = new SamlVerificator().getAssertionOnline("https://stupid-dragonfly-33.localtunnel.me/1r9TmsVhvvmIJ6i8rWXY.xml");
        String address = assertion.getBlockchainAddressOfSubject();
        System.out.println(address);
    }
}
