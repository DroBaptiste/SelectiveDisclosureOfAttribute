package utils.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import utils.Randomizer;

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
import java.nio.file.Paths;

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
        String genName = generateFileName();
        String path = Paths.get("").toAbsolutePath().toString() + File.separator + genName;
        StreamResult result = new StreamResult(new File(path));
        transformer.transform(source, result);
        return genName;
    }

    private static String generateFileName() {
        String name = Randomizer.randomAlphaNumeric(20);
        name = name + ".xml";
        return name;
    }
    public static void addUrl(String url) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(url);
        Node statues = doc.getElementsByTagName("saml2p:StatusCode").item(0);
        NamedNodeMap attr = statues.getAttributes();
        Node nodeAttr = attr.getNamedItem("Value");
        nodeAttr.setTextContent(url+"%");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(url));
        transformer.transform(source, result);
    }

    public static void addBckchID(String url, String _bckID) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String filepath = url;
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filepath);
        Node statues = doc.getElementsByTagName("saml2p:StatusCode").item(0);
        NamedNodeMap attr = statues.getAttributes();
        Node nodeAttr = attr.getNamedItem("Value");
        nodeAttr.setTextContent(url+"%"+_bckID);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);
    }
}
