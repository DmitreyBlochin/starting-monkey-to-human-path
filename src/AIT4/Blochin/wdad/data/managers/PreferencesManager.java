package AIT4.Blochin.wdad.data.managers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class PreferencesManager {

    private static PreferencesManager ourInstance = new PreferencesManager();
    private Document doc;
    private String filepath = "src/AIT4/Blochin/wdad/resources/configuration/appconfig.xml";

    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new File(filepath));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private PreferencesManager() { }

    public static PreferencesManager getInstance() {
        return ourInstance;
    }

    public Document getDoc() {
        return doc;
    }

    public void setCreateregistry(String newValue) {
        Node elem = doc.getElementsByTagName("createregistry").item(0).getFirstChild();
        elem.setNodeValue(newValue);
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("Изменения сохранены");
    }

    public String getCreateregistry(){
        Node elem = doc.getElementsByTagName("createregistry").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    public void setRegistryaddress(String newValue) {
        Node elem = doc.getElementsByTagName("registryaddress").item(0).getFirstChild();
        elem.setNodeValue(newValue);
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("Изменения сохранены");
    }

    public String getRegistryaddress(){
        Node elem = doc.getElementsByTagName("registryaddress").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    public void setRegistryport(String newValue) {
        Node elem = doc.getElementsByTagName("registryport").item(0).getFirstChild();
        elem.setNodeValue(newValue);
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("Изменения сохранены");
    }

    public String getRegistryport(){
        Node elem = doc.getElementsByTagName("registryport").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    public void setPolicypath(String newValue) {
        Node elem = doc.getElementsByTagName("policypath").item(0).getFirstChild();
        elem.setNodeValue(newValue);
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("Изменения сохранены");
    }

    public String getPolicypath(){
        Node elem = doc.getElementsByTagName("policypath").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    public void setUsecodebaseonly(String newValue) {
        Node elem = doc.getElementsByTagName("usecodebaseonly").item(0).getFirstChild();
        elem.setNodeValue(newValue);
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("Изменения сохранены");
    }

    public String getUsecodebaseonly(){
        Node elem = doc.getElementsByTagName("usecodebaseonly").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    public void setClassprovider(String newValue) {
        Node elem = doc.getElementsByTagName("classprovider").item(0).getFirstChild();
        elem.setNodeValue(newValue);
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("Изменения сохранены");
    }

    public String getClassprovider(){
        Node elem = doc.getElementsByTagName("classprovider").item(0).getFirstChild();
        return elem.getNodeValue();
    }

}
