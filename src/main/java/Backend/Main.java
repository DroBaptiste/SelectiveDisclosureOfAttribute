package Backend;

import Utils.CryptoUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws SAXException, TransformerException, ParserConfigurationException, IOException, NoSuchAlgorithmException {
        Assertion assertion = new Assertion("ENSICAEN", "Diplome d'ingénieur", "Baptiste Dromard");
        System.out.println(CryptoUtils.sha256Payload(assertion.getBlockchainAddressOfSubject(), assertion.getSamlString()
                , assertion.getURL()));
        System.out.println(CryptoUtils.sha256Payload("0x8fa7173202d86C746bd884C9f116E356600c6b0E", "<?xml version=\"1.0\" encoding=\"UTF-8\"?><saml2p:Response xmlns:saml2p=\"urn:oasis:names:tc:SAML:2.0:protocol\" ID=\"cf9a47f2-4b23-4bcf-831f-fe43b5359c4e\" IssueInstant=\"2019-05-31T09:50:38.008Z\" Version=\"2.0\"><saml2:Issuer xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\">ENSICAEN</saml2:Issuer><saml2p:Status><saml2p:StatusCode Value=\"urn:oasis:names:tc:SAML:2.0:status:Success\"/></saml2p:Status><saml2:Assertion xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\" ID=\"78fe85fa-720d-4896-8dd9-291c7808b495\" IssueInstant=\"2019-05-31T09:50:38.005Z\" Version=\"2.0\"><saml2:Issuer>ENSICAEN</saml2:Issuer><saml2:Subject><saml2:NameID Format=\"urn:oasis:names:tc:SAML:2.0:nameid-format:persistent\">0x8fa7173202d86C746bd884C9f116E356600c6b0E</saml2:NameID><saml2:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\"><saml2:SubjectConfirmationData NotOnOrAfter=\"2019-06-12T09:50:37.998Z\"/></saml2:SubjectConfirmation></saml2:Subject><saml2:AuthnStatement AuthnInstant=\"2019-05-31T09:50:36.428Z\"><saml2:AuthnContext><saml2:AuthnContextClassRef>urn:oasis:names:tc:SAML:2.0:ac:classes:selfSouvreignIdentity</saml2:AuthnContextClassRef></saml2:AuthnContext></saml2:AuthnStatement></saml2:Assertion></saml2p:Response>" , "../7g0lFGvD7qHYJLNS4C7v.xml"));
    }
}