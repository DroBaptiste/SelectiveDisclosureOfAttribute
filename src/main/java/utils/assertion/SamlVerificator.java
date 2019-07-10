package utils.assertion;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import utils.CryptoUtils;
import utils.xml.ReadXMLFile;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static utils.xml.XMLFileTreatment.convertStringToXMLDocument;


public class SamlVerificator {

    private boolean verificationUrl(String URL) {
        File tempFile = new File(URL);
        return tempFile.exists();
    }

    public Assertion setAssertion(Assertion assertion, Document document, String URL) {
        assertion.setIdAssertion(ReadXMLFile.getIdAssertion(document));
        assertion.setVersionAssertion(ReadXMLFile.getVersion(document));
        assertion.setIssueInstant(ReadXMLFile.getIssueInstant(document));
        assertion.setAttributeProvider(ReadXMLFile.getAP(document));
        assertion.setURL(URL);
        assertion.setBlockchainAddressOfSubject(ReadXMLFile.getSubject(document));
        assertion.setValue(ReadXMLFile.getValue(document));
        assertion.setValidity(String.valueOf(CryptoUtils.nbrDays(ReadXMLFile.getValidity(document),assertion.getIssueInstant())));
        return assertion;
    }

    public Assertion getAssertion(String URL) throws IOException, ParserConfigurationException, SAXException {
        if (verificationUrl(URL)) {
            Assertion assertion = new Assertion();
            assertion.setSamlString(ReadXMLFile.file2String(new File(URL)));
            Document document = ReadXMLFile.readXMLFile(URL);
            return setAssertion(assertion, document, URL);
        } else {
            return null;
        }
    }

    public Assertion getAssertionOnline(String _url) throws IOException, ParserConfigurationException, SAXException {
        InputStream inputStream = new URL(_url).openStream();
        String gentext = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

        Assertion assertion = new Assertion();
        assertion.setSamlString(gentext);
        Document document = convertStringToXMLDocument( gentext );;
        return setAssertion(assertion, document, _url);
    }



}
