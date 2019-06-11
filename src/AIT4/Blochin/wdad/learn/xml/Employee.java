package AIT4.Blochin.wdad.learn.xml;

import java.io.Serializable;

public class Employee implements Serializable {

    private String firstname;
    private String secondname;
    private String hiredate;
    private int salary;
    private String jobtitle;

    public Employee(String firstname, String secondname, String hiredate, int salary, String jobtitle) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.hiredate = hiredate;
        this.salary = salary;
        this.jobtitle = jobtitle;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getHiredate() {
        return hiredate;
    }

    public int getSalary() {
        return salary;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }
}
