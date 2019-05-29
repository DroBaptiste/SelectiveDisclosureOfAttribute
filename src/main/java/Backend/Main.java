package Backend;

import org.joda.time.DateTime;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.impl.ResponseMarshaller;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Element;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            HashMap<String, List<String>> attributes = new HashMap<String, List<String>>();
            String issuer = "Issuesr";
            String subject = "Sujet";
            String privateKey = null;
            String publicKey = null;
            Integer samlAssertionExpirationDays = 12;

            SamlAssertionProducer producer = new SamlAssertionProducer();
            producer.setPrivateKeyLocation(privateKey);
            producer.setPublicKeyLocation(publicKey);

            Response responseInitial = producer.createSAMLResponse(subject, new DateTime(), "password", attributes, issuer, samlAssertionExpirationDays);

            ResponseMarshaller marshaller = new ResponseMarshaller();
            Element element = marshaller.marshall(responseInitial);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            XMLHelper.writeNode(element, baos);
            String responseStr = new String(baos.toByteArray());

            System.out.println(responseStr);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}