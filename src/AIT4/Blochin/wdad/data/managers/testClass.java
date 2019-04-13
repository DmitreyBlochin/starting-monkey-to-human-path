package AIT4.Blochin.wdad.data.managers;

import org.w3c.dom.NodeList;

public class testClass {

    public static void main(String[] args) {

        PreferencesManager pm = PreferencesManager.getInstance();

        System.out.println(pm.getCreateregistry());
        pm.setCreateregistry("no");
        System.out.println(pm.getCreateregistry());

        System.out.println(pm.getRegistryaddress());
        pm.setRegistryaddress("172.0.0.1");
        System.out.println(pm.getRegistryaddress());

        System.out.println(pm.getRegistryport());
        pm.setRegistryport("2020");
        System.out.println(pm.getRegistryport());

        System.out.println(pm.getPolicypath());
        pm.setPolicypath("admin.policy");
        System.out.println(pm.getPolicypath());

        System.out.println(pm.getUsecodebaseonly());
        pm.setUsecodebaseonly("yes");
        System.out.println(pm.getUsecodebaseonly());

        System.out.println(pm.getClassprovider());
        pm.setClassprovider("http://www.randomhost.com");
        System.out.println(pm.getClassprovider());


    }
}
