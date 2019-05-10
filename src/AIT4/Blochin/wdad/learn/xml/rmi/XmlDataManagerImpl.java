package AIT4.Blochin.wdad.learn.xml.rmi;

import AIT4.Blochin.wdad.learn.xml.XmlTask;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class XmlDataManagerImpl extends UnicastRemoteObject implements XmlDataManager {

    XmlTask xml = new XmlTask("src/AIT4/Blochin/wdad/learn/xml/organization.xml");

    protected XmlDataManagerImpl() throws RemoteException {
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
