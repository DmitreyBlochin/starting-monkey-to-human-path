package AIT4.Blochin.wdad.data.managers;

import AIT4.Blochin.wdad.data.storage.DataSourceFactory;
import AIT4.Blochin.wdad.learn.xml.Department;
import AIT4.Blochin.wdad.learn.xml.Employee;


import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCDataManager implements DataManager {

    private Connection conn = null;
    private Statement st = null;

    public JDBCDataManager() throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException,
            InvocationTargetException, ClassNotFoundException {
        conn = DataSourceFactory.createDataSource();
        st = conn.createStatement();
    }

    public JDBCDataManager(String className, String driverType, String host, int port, String dbName, String user, String password)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException,
            ClassNotFoundException {
        conn = DataSourceFactory.createDataSource(className, driverType, host, port, dbName, user, password);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    @Override
    public ArrayList<Employee> getOrganization() throws RemoteException, SQLException {
        ArrayList<Employee> list = new ArrayList<Employee>();
        int quaEmpls = 0;
        ResultSet r = st.executeQuery( "SELECT COUNT(id) FROM employee" );
        quaEmpls = r.getInt(0);
        for (int i = 1; i <= quaEmpls; i++) {
            r = st.executeQuery("SELECT first_name FROM employees WHERE id = "+i);
            String firstname = r.getString(0);
            r = st.executeQuery("SELECT second_name FROM employees WHERE id = "+i);
            String secondname = r.getString(0);
            r = st.executeQuery("SELECT birth_date FROM employees WHERE id = "+i);
            String birthdate = r.getString(0);
            r = st.executeQuery("SELECT hire_date FROM employees WHERE id = "+i);
            String hiredate = r.getString(0);
            r = st.executeQuery("SELECT salary FROM employees WHERE id = "+i);
            int salary = r.getInt(0);
            r = st.executeQuery("SELECT jobtitles_id FROM employees WHERE id = "+i);
            String jobtitle = null;
            if(r.getInt(0)==1) jobtitle = "assistant";
            if(r.getInt(0)==2) jobtitle = "secretary";
            if(r.getInt(0)==3) jobtitle = "engineer";
            if(r.getInt(0)==4) jobtitle = "manager";
            if(r.getInt(0)==5) jobtitle = "head";
            r = st.executeQuery("SELECT departments_id FROM employees WHERE id = "+i);
            int noDepart = r.getInt(0);
            Employee empl = new Employee(firstname, secondname, hiredate, birthdate, salary, jobtitle, noDepart);
            list.add(empl);
        }
        return list;
    }

    @Override
    public int salaryAverage() throws RemoteException, SQLException {
        ResultSet r = st.executeQuery( "SELECT AVG(salary) FROM employees" );
        return r.getInt(0);
    }

    @Override
    public int salaryAverage(int departmentNo) throws RemoteException, SQLException {
        ResultSet r = st.executeQuery( "SELECT" + departmentNo + ", AVG(salary) FROM employees group by departments_id" );
        return r.getInt(0);
    }

    @Override
    public void setJobTitle(String firstName, String secondName, String newJobTitle) throws RemoteException, SQLException {
        int newJobNo = 0;
        if(newJobTitle.equals("assistant")) newJobNo = 1;
        if(newJobTitle.equals("secretary")) newJobNo = 2;
        if(newJobTitle.equals("engineer")) newJobNo = 3;
        if(newJobTitle.equals("manager")) newJobNo = 4;
        if(newJobTitle.equals("head")) newJobNo = 5;
        st.executeUpdate( "UPDATE employees SET salary = "+ newJobNo +" WHERE first_name = "+ firstName +" AND second_name = "+ secondName);
    }

    @Override
    public void setSalary(String firstName, String secondName, int newSalary) throws RemoteException, SQLException {
        st.executeUpdate( "UPDATE employees SET salary = "+ newSalary +" WHERE first_name = "+ firstName +" AND second_name = "+ secondName);
    }

    @Override
    public void fireEmployee(String firstName, String secondName) throws RemoteException, SQLException {
        st.executeUpdate("DELETE FROM employees WHERE first_name = "+ firstName +" AND second_name = "+ secondName);
    }
}
