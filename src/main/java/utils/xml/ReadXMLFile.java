package utils.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

    public static String getIdAssertion(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("saml2p:Response");
        String id = "";
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            id = nNode.getAttributes().getNamedItem("ID").getNodeValue();
        }
        return id;
    }

    public static String getVersion(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("saml2p:Response");
        String version = "";
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            version = nNode.getAttributes().getNamedItem("Version").getNodeValue();
        }
        return version;
    }

    public static String getIssueInstant(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("saml2p:Response");
        String instant = "";
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            instant = nNode.getAttributes().getNamedItem("IssueInstant").getNodeValue();
        }
        return instant;
    }

    public static String getAP(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("saml2:Issuer");
        String AP = "";
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            AP = nNode.getFirstChild().getNodeValue();
        }
        return AP;
    }

    public static String getSubject(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("saml2:Subject");
        String subject = "";
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            subject = nNode.getFirstChild().getFirstChild().getNodeValue();
        }
        return subject;
    }

    public static String file2String(File file) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        }
    }

    public static String getValue(Document document) {
        NodeList nodeList = document.getElementsByTagName("saml2:AuthnContextClassRef");
        String value = "";
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            value = nNode.getFirstChild().getNodeValue();
        }
        return value.substring(value.lastIndexOf(":")+1);
    }

    public static String getValidity(Document document) {
        NodeList nodeList = document.getElementsByTagName("saml2:Subject");
        String subject = "";
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            subject = nNode.getLastChild().getFirstChild().getAttributes().getNamedItem("NotOnOrAfter").getNodeValue();
        }
        return subject;
    }
    public static String readFile(String url) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (url));
        String line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return line;
    }
}