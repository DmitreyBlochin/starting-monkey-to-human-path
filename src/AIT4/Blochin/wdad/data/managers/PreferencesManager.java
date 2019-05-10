package AIT4.Blochin.wdad.data.managers;

import AIT4.Blochin.wdad.utils.PreferencesManagerConstants;
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
    private String className;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setProperty(String key, String value){
        String[] subStr = key.split("\\.");
        String tag = subStr[subStr.length-1];
        Node elem = doc.getElementsByTagName(tag).item(0).getFirstChild();
        elem.setNodeValue(value);
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

    public String getProperty(String key){
        String[] subStr = key.split("\\.");
        String tag = subStr[subStr.length-1];
        Node elem = doc.getElementsByTagName(tag).item(0).getFirstChild();
        return elem.getNodeValue();
     }

    public void setProperties(Properties prop){
        Node elem = doc.getElementsByTagName("createregistry").item(0).getFirstChild();
        elem.setNodeValue(prop.getCreateRegistry());
        Node elem1 = doc.getElementsByTagName("registryaddress").item(0).getFirstChild();
        elem1.setNodeValue(prop.getRegistryAddress());
        Node elem2 = doc.getElementsByTagName("registryport").item(0).getFirstChild();
        elem2.setNodeValue(prop.getRegistryPort());
        Node elem3 = doc.getElementsByTagName("policypath").item(0).getFirstChild();
        elem3.setNodeValue(prop.getPolicyPath());
        Node elem4 = doc.getElementsByTagName("usecodebaseonly").item(0).getFirstChild();
        elem4.setNodeValue(prop.getUseCodeBaseOnly());
        Node elem5 = doc.getElementsByTagName("classprovider").item(0).getFirstChild();
        elem5.setNodeValue(prop.getClassProvider());
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

    public Properties getProperties(){
        Node elem = doc.getElementsByTagName("createregistry").item(0).getFirstChild();
        String createRegistry = elem.getNodeValue();
        Node elem1 = doc.getElementsByTagName("registryaddress").item(0).getFirstChild();
        String registryAddress = elem1.getNodeValue();
        Node elem2 = doc.getElementsByTagName("registryport").item(0).getFirstChild();
        String registryPort = elem2.getNodeValue();
        Node elem3 = doc.getElementsByTagName("policypath").item(0).getFirstChild();
        String policyPath = elem3.getNodeValue();
        Node elem4 = doc.getElementsByTagName("usecodebaseonly").item(0).getFirstChild();
        String useCodeBaseOnly = elem4.getNodeValue();
        Node elem5 = doc.getElementsByTagName("classprovider").item(0).getFirstChild();
        String classProvider = elem5.getNodeValue();

        Properties props = new Properties(createRegistry,registryAddress,registryPort,policyPath,useCodeBaseOnly,classProvider);
        return props;
    }

    public void addBindedObject(String name, String className) {
        Node root = doc.getDocumentElement();
        NodeList rmi = root.getChildNodes();
        NodeList rmiElems = rmi.item(1).getChildNodes();
        Node innerRmi = rmiElems.item(1);

        Element bindeobjectTag = doc.createElement("bindeobject");
        Element nameTag = doc.createElement("name");
        nameTag.setTextContent(name);
        Element classTag = doc.createElement("class");
        classTag.setTextContent(className);
        bindeobjectTag.appendChild(nameTag);
        bindeobjectTag.appendChild(classTag);

        innerRmi.appendChild(bindeobjectTag);
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
        this.className = className;
        System.out.println("Изменения сохранены");
    }

    public void removeBindedObject(String name){
        Node server = doc.getElementsByTagName("server").item(0);
        NodeList nodeList = server.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
        Node nextNode = nodeList.item(i);
        System.out.println(nextNode);
            if (nextNode.getNodeName().equals(name)) {
            server.removeChild(nextNode); }
        }
            this.className = "";
    }




    @Deprecated
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

    @Deprecated
    public String getCreateregistry(){
        Node elem = doc.getElementsByTagName("createregistry").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    @Deprecated
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

    @Deprecated
    public String getRegistryaddress(){
        Node elem = doc.getElementsByTagName("registryaddress").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    @Deprecated
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

    @Deprecated
    public String getRegistryport(){
        Node elem = doc.getElementsByTagName("registryport").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    @Deprecated
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

    @Deprecated
    public String getPolicypath(){
        Node elem = doc.getElementsByTagName("policypath").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    @Deprecated
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

    @Deprecated
    public String getUsecodebaseonly(){
        Node elem = doc.getElementsByTagName("usecodebaseonly").item(0).getFirstChild();
        return elem.getNodeValue();
    }

    @Deprecated
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

    @Deprecated
    public String getClassprovider(){
        Node elem = doc.getElementsByTagName("classprovider").item(0).getFirstChild();
        return elem.getNodeValue();
    }

}
