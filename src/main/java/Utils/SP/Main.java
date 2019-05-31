package Utils.SP;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, org.xml.sax.SAXException {
        String path = "/home/dromard/Documents/JAva/apache-tomcat-9.0.20/O7UReKCkjxWOTAIdZehd.xml";
        SamlVerificator samlVerificator = new SamlVerificator();
                System.out.println(samlVerificator.getAssertion(path).getSamlString());

    }
}
