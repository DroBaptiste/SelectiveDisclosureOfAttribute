package Backend;

import Utils.Utils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class XMLFileTreatment {
    public static String StringToFile(String xmlSource) throws SAXException, ParserConfigurationException, IOException, TransformerException {
        // Parse the given input
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlSource)));

        // Write the parsed document to an xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        String path = "/home/dromard/Documents/"+ generateFileName();
        StreamResult result =  new StreamResult(new File(path));
        transformer.transform(source, result);
        return path;
    }

    private static String generateFileName(){
        String name = Utils.randomAlphaNumeric(20);
        name = name + ".xml";
        return name;
    }
}
