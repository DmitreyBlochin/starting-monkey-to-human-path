package AIT4.Blochin.wdad.learn.xml;

import java.util.ArrayList;

public class Department {
    private ArrayList<Employee> emplsList;
    private String name;


    public Department(String name){
        emplsList = new ArrayList<Employee>();
        this.name = name;
    }

    public ArrayList<Employee> getEmplsList() {
        return emplsList;
    }

    public String getName() {
        return name;
    }
}
