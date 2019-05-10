package AIT4.Blochin.wdad.learn.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XmlTask {

    ArrayList<Department> organization = new ArrayList<Department>();
    Document doc;

    public XmlTask(String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = (Document) builder.parse(new File(path));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        NodeList departmentList = doc.getElementsByTagName("department");
        for (int i = 0; i < departmentList.getLength(); i++) {
            Node department = departmentList.item(i);
            NamedNodeMap attributes = department.getAttributes();
            Department dep = new Department(attributes.getNamedItem("name").getNodeValue());

            NodeList employeesList = department.getChildNodes();

            for (int j = 1; j < employeesList.getLength(); j+=2) {
                Node employee = employeesList.item(j);
                NamedNodeMap attributesEmployee = employee.getAttributes();
                String firstname = attributesEmployee.getNamedItem("firstname").getNodeValue();
                String secondname = attributesEmployee.getNamedItem("secondname").getNodeValue();
                NodeList employeesProp = employee.getChildNodes();
                String hiredate = employeesProp.item(1).getTextContent();
                String salaryStr = employeesProp.item(3).getTextContent().trim();
                int salary = Integer.parseInt(salaryStr);
                String jobtitle = employeesProp.item(5).getAttributes().getNamedItem("value").getNodeValue();

                Employee empl = new Employee(firstname, secondname, hiredate, salary, jobtitle);
                dep.getEmplsList().add(empl);
            }

            organization.add(dep);
        }
    }

    public int salaryAverage(){
        int sum = 0;
        int quantEmployees = 0;
        for (int i = 0; i < organization.size(); i++) {
            for (int j = 0; j < organization.get(i).getEmplsList().size() ; j++) {
                sum+= organization.get(i).getEmplsList().get(j).getSalary();
                quantEmployees++;
            }
        }
        return (sum/quantEmployees);
    }

    public int salaryAverage(String departmentName){
        int sum = 0;
        int quantEmployees = 0;
        for (int i = 0; i < organization.size(); i++) {
            if(organization.get(i).getName().equals(departmentName)){
                for (int j = 0; j < organization.get(i).getEmplsList().size(); j++) {
                    sum+=organization.get(i).getEmplsList().get(j).getSalary();
                    quantEmployees++;
                }
            }
        }
        return (sum/quantEmployees);
    }

    public void setJobTitle(String firstName, String secondName, String newJobTitle){
        for (int i = 0; i < organization.size(); i++) {
            for (int j = 0; j < organization.get(i).getEmplsList().size() ; j++) {
                if(organization.get(i).getEmplsList().get(j).getFirstname().equals(firstName) && organization.get(i).getEmplsList().get(j).getSecondname().equals(secondName)){
                    organization.get(i).getEmplsList().get(j).setJobtitle(newJobTitle);
                }
            }
        }
    }

    public void setSalary(String firstName, String secondName, int newSalary){
        for (int i = 0; i < organization.size(); i++) {
            for (int j = 0; j < organization.get(i).getEmplsList().size() ; j++) {
                if(organization.get(i).getEmplsList().get(j).getFirstname().equals(firstName) && organization.get(i).getEmplsList().get(j).getSecondname().equals(secondName)){
                    organization.get(i).getEmplsList().get(j).setSalary(newSalary);
                }
            }
        }
    }

    public void fireEmployee(String firstName, String secondName){
        for (int i = 0; i < organization.size(); i++) {
            for (int j = 0; j < organization.get(i).getEmplsList().size() ; j++) {
                if(organization.get(i).getEmplsList().get(j).getFirstname().equals(firstName) && organization.get(i).getEmplsList().get(j).getSecondname().equals(secondName)){
                    organization.get(i).getEmplsList().remove(j);
                }
            }
        }
    }

}
