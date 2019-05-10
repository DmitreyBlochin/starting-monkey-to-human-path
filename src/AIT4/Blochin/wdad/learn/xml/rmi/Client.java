package AIT4.Blochin.wdad.learn.xml.rmi;

import AIT4.Blochin.wdad.data.managers.PreferencesManager;

import java.rmi.Naming;

public class Client {

    public static void main(String[] args) throws Exception {

        //Определение параметров RMI с помощью класса PreferencesManager
        PreferencesManager pm = PreferencesManager.getInstance();
        String address = pm.getProperties().getRegistryAddress();
        String port = pm.getProperties().getRegistryPort();
        String name = pm.getClassName();
        String path = "rmi://"+address+":"+port+"/"+name;
        System.out.println(path);

        //Обращение к реестру RMI
        XmlDataManager xdm = (XmlDataManager) Naming.lookup(path);

        //Вызовы удаленных методов
        int salAver = xdm.salaryAverage();
        System.out.println(" Средняя ЗП сотрудников организации: "+salAver);
        int salAverDepartm = xdm.salaryAverage("It1");
        System.out.println(" Средняя ЗП сотрудников первого отдела: "+salAverDepartm);

        System.out.println("Name: "+xdm.getOrganization().get(1).getEmplsList().get(2).getFirstname());
        System.out.println("Old JobTitle: "+xdm.getOrganization().get(1).getEmplsList().get(2).getJobtitle());
        xdm.setJobTitle("greg","greys","assistant");
        System.out.println("Name: "+xdm.getOrganization().get(1).getEmplsList().get(2).getFirstname());
        System.out.println("New JobTitle: "+xdm.getOrganization().get(1).getEmplsList().get(2).getJobtitle());

        System.out.println("Name: "+xdm.getOrganization().get(0).getEmplsList().get(0).getFirstname());
        System.out.println("Old salary: "+xdm.getOrganization().get(0).getEmplsList().get(0).getSalary());
        xdm.setSalary("jack","jackson",1000);
        System.out.println("Name: "+xdm.getOrganization().get(0).getEmplsList().get(0).getFirstname());
        System.out.println("New salary: "+xdm.getOrganization().get(0).getEmplsList().get(0).getSalary());

        System.out.println("Список отдела до увольнения: ");
        for (int j = 0; j < xdm.getOrganization().get(0).getEmplsList().size(); j++) {
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getFirstname());
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getSecondname());
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getHiredate());
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getSalary());
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getJobtitle());
            System.out.println();
        }
        xdm.fireEmployee("josh","jordan");
        System.out.println("Список отдела после увольнения: ");
        for (int j = 0; j < xdm.getOrganization().get(0).getEmplsList().size(); j++) {
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getFirstname());
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getSecondname());
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getHiredate());
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getSalary());
            System.out.println(xdm.getOrganization().get(0).getEmplsList().get(j).getJobtitle());
            System.out.println();
        }




    }
}
