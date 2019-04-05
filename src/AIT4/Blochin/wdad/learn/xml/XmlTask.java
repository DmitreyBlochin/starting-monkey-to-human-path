package AIT4.Blochin.wdad.learn.xml;

import org.w3c.dom.Document;

import java.util.ArrayList;

public class XmlTask {

    ArrayList<Department> organization = new ArrayList<Department>();
    Document doc;


    public int salaryAverage(){
        int sum = 0;
        int quantEmployees = 0;
        for (int i = 0; i < organization.size(); i++) {
            for (int j = 0; j < organization.get(i).getEmplsList().size() ; j++) {
                sum+= organization.get(i).getEmplsList().get(j).getSalary();
                quantEmployees++;
            }
        }
        return (sum/quantEmployees);
    }

    public double salaryAverage(String departmentName){
        int sum = 0;
        int quantEmployees = 0;
        for (int i = 0; i < organization.size(); i++) {
            if(organization.get(i).getName().equals(departmentName)){
                for (int j = 0; j < organization.get(i).getEmplsList().size(); j++) {
                    sum+=organization.get(i).getEmplsList().get(j).getSalary();
                    quantEmployees++;
                }
            }
        }
        return (sum/quantEmployees);
    }

    public void setJobTitle(String firstName, String secondName, String newJobTitle){
        for (int i = 0; i < organization.size(); i++) {
            for (int j = 0; j < organization.get(i).getEmplsList().size() ; j++) {
                if(organization.get(i).getEmplsList().get(j).getFirstname().equals(firstName) && organization.get(i).getEmplsList().get(j).getSecondname().equals(secondName)){
                    organization.get(i).getEmplsList().get(j).setJobtitle(newJobTitle);
                }
            }
        }
    }

    public void setSalary(String firstName, String secondName, int newSalary){
        for (int i = 0; i < organization.size(); i++) {
            for (int j = 0; j < organization.get(i).getEmplsList().size() ; j++) {
                if(organization.get(i).getEmplsList().get(j).getFirstname().equals(firstName) && organization.get(i).getEmplsList().get(j).getSecondname().equals(secondName)){
                    organization.get(i).getEmplsList().get(j).setSalary(newSalary);
                }
            }
        }
    }

    public void fireEmployee(String firstName, String secondName){
        for (int i = 0; i < organization.size(); i++) {
            for (int j = 0; j < organization.get(i).getEmplsList().size() ; j++) {
                if(organization.get(i).getEmplsList().get(j).getFirstname().equals(firstName) && organization.get(i).getEmplsList().get(j).getSecondname().equals(secondName)){
                    organization.get(i).getEmplsList().remove(j);
                }
            }
        }
    }

}
