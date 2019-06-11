package AIT4.Blochin.wdad.learn.xml;

public class Employee {

    private String firstname;
    private String secondname;
    private String birthdate;
    private String hiredate;
    private int salary;
    private String jobtitle;
    private int noDepart;

    public Employee(String firstname, String secondname, String hiredate, String birthdate, int salary, String jobtitle, int noDepart) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.birthdate = birthdate;
        this.hiredate = hiredate;
        this.salary = salary;
        this.jobtitle = jobtitle;
        this.noDepart = noDepart;
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

    public int getNoDepart() {
        return noDepart;
    }

    public void setNoDepart(int noDepart) {
        this.noDepart = noDepart;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
