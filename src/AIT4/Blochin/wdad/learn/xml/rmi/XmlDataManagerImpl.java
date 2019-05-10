package AIT4.Blochin.wdad.learn.xml.rmi;

import AIT4.Blochin.wdad.learn.xml.Department;
import AIT4.Blochin.wdad.learn.xml.XmlTask;
import org.w3c.dom.Document;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class XmlDataManagerImpl extends UnicastRemoteObject implements XmlDataManager, Serializable {

    public XmlTask xml = new XmlTask("src/AIT4/Blochin/wdad/learn/xml/organization.xml");

    protected XmlDataManagerImpl() throws RemoteException {
    }

    public ArrayList<Department> getOrganization(){
        return xml.getOrganization();
    }

    public Document getDocument(){
        return xml.getDoc();
    }

    public int salaryAverage() {
        return xml.salaryAverage();
    }

    public int salaryAverage(String departmentName){
        return xml.salaryAverage(departmentName);
    }

    public void setJobTitle(String firstName, String secondName, String newJobTitle){
       xml.setJobTitle(firstName,secondName,newJobTitle);
    }

    public void setSalary(String firstName, String secondName, int newSalary){
       xml.setSalary(firstName,secondName,newSalary);
    }

    public void fireEmployee(String firstName, String secondName){
       xml.fireEmployee(firstName, secondName);
    }

}
