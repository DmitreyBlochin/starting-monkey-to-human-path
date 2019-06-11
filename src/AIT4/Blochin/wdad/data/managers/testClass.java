package AIT4.Blochin.wdad.data.managers;

import AIT4.Blochin.wdad.data.storage.DataSourceFactory;
import AIT4.Blochin.wdad.utils.PreferencesManagerConstants;
import org.w3c.dom.NodeList;

import java.sql.Connection;
import java.sql.SQLException;

import static AIT4.Blochin.wdad.data.storage.DataSourceFactory.createDataSource;

public class testClass {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        String driverType = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.driverType);
        String host = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.hostName);
        String port = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.port);
        String dbName = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.DBName);
        String url = driverType + "://" + host + ":" + port + "/" + dbName;
        String user = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.user);
        String password = PreferencesManager.getInstance().getProperty(PreferencesManagerConstants.pass);

        System.out.println(url);
        System.out.println(user);
        System.out.println(password);





//        PreferencesManager pm = PreferencesManager.getInstance();
//
//        System.out.println(pm.getProperty(PreferencesManagerConstants.createRegistry));
//        pm.setProperty(PreferencesManagerConstants.createRegistry,"yes");
//        System.out.println(pm.getProperty(PreferencesManagerConstants.createRegistry));
//
//        System.out.println();
//
//        System.out.println(pm.getProperty(PreferencesManagerConstants.registryAddress));
//        pm.setProperty(PreferencesManagerConstants.registryAddress,"127.0.0.0");
//        System.out.println(pm.getProperty(PreferencesManagerConstants.registryAddress));
//
//        System.out.println();
//
//        Properties prop = new Properties("no","225.225.0.0","2099","user.policy","no","http://www.myhost.com");
//        pm.setProperties(prop);
//        Properties pr = pm.getProperties();
//        System.out.println(pr.getCreateRegistry());
//        System.out.println(pr.getRegistryAddress());
//        System.out.println(pr.getRegistryPort());
//        System.out.println(pr.getPolicyPath());
//        System.out.println(pr.getUseCodeBaseOnly());
//        System.out.println(pr.getClassProvider());
//
//        pm.addBindedObject("XmlDataManager","src/AIT4/Blochin/wdad/learn/rmi/XmlDataManager.java");
//
//        System.out.println();
//
//        pm.removeBindedObject("name");



    }
}
