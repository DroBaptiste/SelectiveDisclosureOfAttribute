package utils.assertion;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import utils.xml.ReadXMLFile;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SamlVerificator {

    private boolean verificationUrl(String URL) {
        File tempFile = new File(URL);
        return tempFile.exists();
    }

    public Assertion getAssertion(String URL) throws IOException, ParserConfigurationException, SAXException {
        if (verificationUrl(URL)) {
            Assertion assertion = new Assertion();
            assertion.setSamlString(ReadXMLFile.file2String(new File(URL)));
            Document document = ReadXMLFile.readXMLFile(URL);
            assertion.setIdAssertion(ReadXMLFile.getIdAssertion(document));
            assertion.setVersionAssertion(ReadXMLFile.getVersion(document));
            assertion.setIssueInstant(ReadXMLFile.getIssueInstant(document));
            assertion.setAttributeProvider(ReadXMLFile.getAP(document));
            assertion.setURL(URL);
            assertion.setBlockchainAddressOfSubject(ReadXMLFile.getSubject(document));
            assertion.setValue(ReadXMLFile.getValue(document));
            assertion.setValidity(ReadXMLFile.getValidity(document));
            return assertion;
        } else {
            return null;
        }
    }
}
