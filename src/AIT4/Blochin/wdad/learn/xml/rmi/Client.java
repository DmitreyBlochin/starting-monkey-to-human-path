package AIT4.Blochin.wdad.learn.xml.rmi;

import AIT4.Blochin.wdad.data.managers.PreferencesManager;

import java.rmi.Naming;

public class Client {

    public static void main(String[] args) throws Exception {

        PreferencesManager pm = PreferencesManager.getInstance();
        String address = pm.getProperties().getRegistryAddress();
        String port = pm.getProperties().getRegistryPort();
        String name = pm.getClassName();
        String path = "rmi://"+address+":"+port+"/"+name;
        System.out.println(path);
        //XmlDataManager xdm = (XmlDataManager) Naming.lookup("rmi://127.0.0.1:2099/XmlDataManager");



        //System.setProperty("java.rmi.server.hostname", "127.0.0.1");
    }
}
