package AIT4.Blochin.wdad.learn.xml.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface XmlDataManager extends Remote {

    int salaryAverage() throws RemoteException;
    int salaryAverage(String departmentName) throws RemoteException;
    void setJobTitle(String firstName, String secondName, String newJobTitle) throws RemoteException;
    void setSalary(String firstName, String secondName, int newSalary) throws RemoteException;
    void fireEmployee(String firstName, String secondName) throws RemoteException;

}
