package SP;

import Backend.Assertion;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SamlVerificator {

    public static boolean verificationUrl(String URL){
        File tempFile = new File(URL);
        return tempFile.exists();
    }

    public static void getAssertion(String URL) throws IOException, ParserConfigurationException, SAXException {
        if(verificationUrl(URL)){
            Assertion assertion = new Assertion();
            assertion.setSamlString(ReadXMLFile.file2String(new File(URL)));
            Document document =ReadXMLFile.readXMLFile(URL);
            assertion.setIdAssertion(ReadXMLFile.getIdAssertion(document));
            System.out.println(assertion.getIdAssertion());
            //return assertion;
        }else{
            //return null;
        }
    }
}
