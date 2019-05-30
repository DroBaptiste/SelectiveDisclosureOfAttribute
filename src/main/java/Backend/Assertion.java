package Backend;

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
import java.sql.Time;
import java.util.HashMap;
import java.util.List;


public class Assertion {

    //!-- Attribute of assertion
    private String idAssertion;
    private String versionAssertion;
    private Time issueInstant;
    private String attributeProvider;
    private String signatureOfIssuer;
    private Time startValidityInstant;
    private Time endValidityInstant;
    private String value;
    private String URL;
    private String blockchainAddressOfSubject;
    private String samlString;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }



    public Assertion(String _attributeProvider, String _value, String _blockchainAddressOfSubject) throws SAXException, TransformerException, ParserConfigurationException, IOException {
        this.attributeProvider = _attributeProvider;
        this.value = _value;
        this.blockchainAddressOfSubject = _blockchainAddressOfSubject;
        URL = XMLFileTreatment.StringToFile(generateSAML());
    }



    private String generateSAML() {
        BasicConfigurator.configure();
        try {
            HashMap<String, List<String>> attributes = new HashMap<>();
            String issuer = attributeProvider;
            String subject = blockchainAddressOfSubject;

            Integer samlAssertionExpirationDays = 12;

            SamlAssertionProducer producer = new SamlAssertionProducer();
            Response responseInitial = producer.createSAMLResponse(subject, new DateTime(),
                    "password", attributes, issuer, samlAssertionExpirationDays);

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

    public void setIdAssertion(String idAssertion) {
        this.idAssertion = idAssertion;
    }

    public String getVersionAssertion() {
        return versionAssertion;
    }

    public void setVersionAssertion(String versionAssertion) {
        this.versionAssertion = versionAssertion;
    }

    public Time getIssueInstant() {
        return issueInstant;
    }

    public void setIssueInstant(Time issueInstant) {
        this.issueInstant = issueInstant;
    }

    public String getAttributeProvider() {
        return attributeProvider;
    }

    public void setAttributeProvider(String attributeProvider) {
        this.attributeProvider = attributeProvider;
    }

    public String getSignatureOfIssuer() {
        return signatureOfIssuer;
    }

    public void setSignatureOfIssuer(String signatureOfIssuer) {
        this.signatureOfIssuer = signatureOfIssuer;
    }

    public Time getStartValidityInstant() {
        return startValidityInstant;
    }

    public void setStartValidityInstant(Time startValidityInstant) {
        this.startValidityInstant = startValidityInstant;
    }

    public Time getEndValidityInstant() {
        return endValidityInstant;
    }

    public void setEndValidityInstant(Time endValidityInstant) {
        this.endValidityInstant = endValidityInstant;
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

    public void setBlockchainAddressOfSubject(String blockchainAddressOfSubject) {
        this.blockchainAddressOfSubject = blockchainAddressOfSubject;
    }

    public String getSamlString() {
        return samlString;
    }

    public void setSamlString(String samlString) {
        this.samlString = samlString;
    }
}
