package AIT4.Blochin.wdad.data.managers;

import AIT4.Blochin.wdad.data.storage.DataSourceFactory;
import AIT4.Blochin.wdad.learn.xml.Department;
import org.w3c.dom.Document;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCDataManager implements DataManager {

    private Connection conn = null;

    public JDBCDataManager() throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
        conn = DataSourceFactory.createDataSource();
    }

    public JDBCDataManager(String className, String driverType, String host, int port, String dbName, String user, String password) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
        conn = DataSourceFactory.createDataSource(className, driverType, host, port, dbName, user, password);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    @Override
    public ArrayList<Department> getOrganization() throws RemoteException {
        return null;
    }

    @Override
    public Document getDocument() throws RemoteException {
        return null;
    }

    @Override
    public int salaryAverage() throws RemoteException {
        return 0;
    }

    @Override
    public int salaryAverage(String departmentName) throws RemoteException {
        return 0;
    }

    @Override
    public void setJobTitle(String firstName, String secondName, String newJobTitle) throws RemoteException {

    }

    @Override
    public void setSalary(String firstName, String secondName, int newSalary) throws RemoteException {

    }

    @Override
    public void fireEmployee(String firstName, String secondName) throws RemoteException {

    }
}
