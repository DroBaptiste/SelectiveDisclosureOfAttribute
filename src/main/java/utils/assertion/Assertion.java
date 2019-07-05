package utils.assertion;

import org.apache.log4j.BasicConfigurator;
import org.joda.time.DateTime;
import org.json.simple.parser.ParseException;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.impl.ResponseMarshaller;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import utils.xml.ReadXMLFile;
import utils.xml.XMLFileTreatment;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class Assertion {

    //!-- Attribute of assertion
    private String idAssertion;
    private String versionAssertion;
    private String issueInstant;
    private String attributeProvider;
    private String URL;
    private String samlString;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        this.transactionID = transactionID;
        XMLFileTreatment.addBckchID(this.getURL(),transactionID);
    }

    private String validity;
    private String value;

    private String blockchainAddressOfSubject;
    private String transactionID;


    Assertion() {
    }

    public Assertion(String _attributeProvider, String _value, String _blockchainAddressOfSubject, String _validity) throws SAXException, TransformerException, ParserConfigurationException, IOException, ParseException {
        this.attributeProvider = _attributeProvider;
        this.value = _value;
        this.validity = _validity;
        this.blockchainAddressOfSubject = _blockchainAddressOfSubject;
        this.samlString = generateSAML(_value, _validity,"", "" );
        URL = XMLFileTreatment.StringToFile(samlString);
        XMLFileTreatment.addUrl(URL);
        updateSamlString();
    }

    private void updateSamlString() throws IOException, SAXException, ParserConfigurationException {
        this.samlString = ReadXMLFile.readFile(this.getURL());
    }
    public String getURL() {
        return URL;
    }

    void setURL(String URL) {
        this.URL = URL;
    }

    private String generateSAML(String _credantialtype, String _validity, String url, String idBlockchain) {
        BasicConfigurator.configure();
        try {
            HashMap<String, List<String>> attributes = new HashMap<>();
            String issuer = attributeProvider;
            String subject = blockchainAddressOfSubject;


            SamlAssertionProducer producer = new SamlAssertionProducer();
            Response responseInitial = producer.createSAMLResponse(subject, new DateTime(),
                    url,_credantialtype, attributes, issuer, Integer.valueOf(_validity));

            ResponseMarshaller marshaller = new ResponseMarshaller();
            Element element = marshaller.marshall(responseInitial);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            XMLHelper.writeNode(element, baos);
            return new String(baos.toByteArray());

        } catch (Throwable t) {
            return "Fatal error:Creation of assertion";
        }
    }

    public String getIdAssertion() {
        return idAssertion;
    }

    void setIdAssertion(String idAssertion) {
        this.idAssertion = idAssertion;
    }

    public String getVersionAssertion() {
        return versionAssertion;
    }

    void setVersionAssertion(String versionAssertion) {
        this.versionAssertion = versionAssertion;
    }

    public String getIssueInstant() {
        return issueInstant;
    }

    void setIssueInstant(String issueInstant) {
        this.issueInstant = issueInstant;
    }

    public String getAttributeProvider() {
        return attributeProvider;
    }

    void setAttributeProvider(String attributeProvider) {
        this.attributeProvider = attributeProvider;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBlockchainAddressOfSubject() {
        return blockchainAddressOfSubject;
    }

    void setBlockchainAddressOfSubject(String blockchainAddressOfSubject) {
        this.blockchainAddressOfSubject = blockchainAddressOfSubject;
    }

    public String getSamlString() {
        return samlString.replaceAll("\n", "");
    }

    void setSamlString(String samlString) {
        this.samlString = samlString;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}
