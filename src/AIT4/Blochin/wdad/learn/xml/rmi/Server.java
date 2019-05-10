package AIT4.Blochin.wdad.learn.xml.rmi;

import AIT4.Blochin.wdad.data.managers.PreferencesManager;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) throws Exception{

        // Создание удаленного RMI объекта
        XmlDataManagerImpl service = new XmlDataManagerImpl();

        //Определение параметров RMI и регистрация (создание или подключение) в реестре
        PreferencesManager pm = PreferencesManager.getInstance();
        String port = pm.getProperties().getRegistryPort();
        if(pm.getProperties().getCreateRegistry().equals("yes")){
            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind("XmlDataManager", service);
        } else {
            Registry registry = LocateRegistry.createRegistry(Integer.parseInt(port));
            registry.rebind("XmlDataManager", service);
        }

        //Добавление в конфигурационный файл информацию по добавленному объекту
        pm.addBindedObject("XmlDataManager","src/AIT4/Blochin/wdad/learn/rmi/XmlDataManager");

        System.out.println("Server is running ...");



    }

}
