package AIT4.Blochin.wdad.data.managers;

import AIT4.Blochin.wdad.learn.xml.Department;
import AIT4.Blochin.wdad.learn.xml.Employee;
import org.w3c.dom.Document;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DataManager extends Remote {

    ArrayList<Employee> getOrganization() throws RemoteException, SQLException;
    int salaryAverage() throws RemoteException, SQLException;
    int salaryAverage(int departmentNo) throws RemoteException, SQLException;
    void setJobTitle(String firstName, String secondName, String newJobTitle) throws RemoteException, SQLException;
    void setSalary(String firstName, String secondName, int newSalary) throws RemoteException, SQLException;
    void fireEmployee(String firstName, String secondName) throws RemoteException, SQLException;

}
