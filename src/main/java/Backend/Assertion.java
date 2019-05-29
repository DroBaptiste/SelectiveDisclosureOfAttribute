package Backend;

import org.apache.log4j.BasicConfigurator;
import org.joda.time.DateTime;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.impl.ResponseMarshaller;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Element;

import java.io.ByteArrayOutputStream;
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
    private String Value;
    private String blockchainAddressOfSubject;

    public Assertion(String attributeProvider, String value, String blockchainAddressOfSubject) {
        this.attributeProvider = attributeProvider;
        Value = value;
        this.blockchainAddressOfSubject = blockchainAddressOfSubject;
    }

    //!-- Creation of a SAML file
    public String generateSAML() {
        BasicConfigurator.configure();
        try {
            HashMap<String, List<String>> attributes = new HashMap<>();
            String issuer = attributeProvider;
            String subject = blockchainAddressOfSubject;
            // String privateKey = null;
            // String publicKey = null;
            Integer samlAssertionExpirationDays = 12;

            SamlAssertionProducer producer = new SamlAssertionProducer();
            // producer.setPrivateKeyLocation(privateKey);
            // producer.setPublicKeyLocation(publicKey);

            Response responseInitial = producer.createSAMLResponse(subject, new DateTime(), "password", attributes, issuer, samlAssertionExpirationDays);

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
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getBlockchainAddressOfSubject() {
        return blockchainAddressOfSubject;
    }

    public void setBlockchainAddressOfSubject(String blockchainAddressOfSubject) {
        this.blockchainAddressOfSubject = blockchainAddressOfSubject;
    }
}
