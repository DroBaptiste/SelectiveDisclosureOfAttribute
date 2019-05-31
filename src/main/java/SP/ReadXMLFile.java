package SP;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class ReadXMLFile {

    public static Document readXMLFile(String _path) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(_path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();
        return doc;
    }

    public static void getElement(Document doc, String _element){
        NodeList nodeList = doc.getElementsByTagName(_element);
        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node nNode =nodeList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            System.out.println(nNode.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
        }
    }
}