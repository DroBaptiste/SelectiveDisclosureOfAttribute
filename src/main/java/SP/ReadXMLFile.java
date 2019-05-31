package SP;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.*;

public class ReadXMLFile {

    public static Document readXMLFile(String _path) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(_path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();
        return doc;
    }

    public static String getIdAssertion(Document doc){
        NodeList nodeList = doc.getElementsByTagName("saml2p:Response");
        String id = "";
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode =nodeList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            System.out.println(nNode.getAttributes().getNamedItem("ID").getNodeValue());
        }
        return id;
    }

    public static String file2String(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }
}