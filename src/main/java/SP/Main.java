package SP;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        String path = "D://Stage2A//LoSUJ52mXKleKiwFHtVI.xml";
        SamlVerificator.getAssertion(path);
    }
}
