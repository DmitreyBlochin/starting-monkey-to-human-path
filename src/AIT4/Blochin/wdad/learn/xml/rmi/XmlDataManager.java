package AIT4.Blochin.wdad.learn.xml.rmi;

import AIT4.Blochin.wdad.learn.xml.Department;
import AIT4.Blochin.wdad.learn.xml.XmlTask;
import org.w3c.dom.Document;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface XmlDataManager extends Remote {

    ArrayList<Department> getOrganization() throws RemoteException;
    Document getDocument() throws RemoteException;
    int salaryAverage() throws RemoteException;
    int salaryAverage(String departmentName) throws RemoteException;
    void setJobTitle(String firstName, String secondName, String newJobTitle) throws RemoteException;
    void setSalary(String firstName, String secondName, int newSalary) throws RemoteException;
    void fireEmployee(String firstName, String secondName) throws RemoteException;

}
