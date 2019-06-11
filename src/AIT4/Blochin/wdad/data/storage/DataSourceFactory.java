package AIT4.Blochin.wdad.data.storage;


import AIT4.Blochin.wdad.data.managers.PreferencesManager;
import AIT4.Blochin.wdad.utils.PreferencesManagerConstants;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceFactory {

    public static Connection createDataSource() throws ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        String className = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.className);
        Class.forName(className).getDeclaredConstructor().newInstance();
        String driverType = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.driverType);
        String host = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.hostName);
        String port = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.port);
        String dbName = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.DBName);
        String url = driverType + "://" + host + ":" + port + "/" + dbName + "?serverTimezone=Europe/Moscow&useSSL=false";
        String user = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.user);
        String password = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.pass);
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static Connection createDataSource(String className, String driverType, String host, int port, String dbName, String user, String password)
            throws ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class.forName(className).getDeclaredConstructor().newInstance();
        String url = driverType + "://" + host + ":" + port + "/" + dbName + "?serverTimezone=Europe/Moscow&useSSL=false";
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

}
