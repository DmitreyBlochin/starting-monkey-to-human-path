package AIT4.Blochin.wdad.learn.xml;

public class TestXmlTask {

    public static void main(String[] args) {

        XmlTask xml = new XmlTask("src/AIT4/Blochin/wdad/learn/xml/organization.xml");

        for (int i = 0; i < xml.organization.size(); i++) {
            for (int j = 0; j < xml.organization.get(i).getEmplsList().size(); j++) {
                System.out.println(xml.organization.get(i).getEmplsList().get(j).getFirstname());
                System.out.println(xml.organization.get(i).getEmplsList().get(j).getSecondname());
                System.out.println(xml.organization.get(i).getEmplsList().get(j).getHiredate());
                System.out.println(xml.organization.get(i).getEmplsList().get(j).getSalary());
                System.out.println(xml.organization.get(i).getEmplsList().get(j).getJobtitle());
            }
            System.out.println("<<<<<<<<<<<<  >>>>>>>>>>>>");
        }

        int salAver = xml.salaryAverage();
        System.out.println(" Средняя ЗП сотрудников организации: "+salAver);

        int salAverDepartm = xml.salaryAverage("It1");
        System.out.println(" Средняя ЗП сотрудников первого отдела: "+salAverDepartm);

        System.out.println("Name: "+xml.organization.get(1).getEmplsList().get(2).getFirstname());
        System.out.println("Old JobTitle: "+xml.organization.get(1).getEmplsList().get(2).getJobtitle());
        xml.setJobTitle("greg","greys","assistant");
        System.out.println("Name: "+xml.organization.get(1).getEmplsList().get(2).getFirstname());
        System.out.println("New JobTitle: "+xml.organization.get(1).getEmplsList().get(2).getJobtitle());

        System.out.println("Name: "+xml.organization.get(0).getEmplsList().get(0).getFirstname());
        System.out.println("Old salary: "+xml.organization.get(0).getEmplsList().get(0).getSalary());
        xml.setSalary("jack","jackson",1000);
        System.out.println("Name: "+xml.organization.get(0).getEmplsList().get(0).getFirstname());
        System.out.println("New salary: "+xml.organization.get(0).getEmplsList().get(0).getSalary());

        System.out.println("Список отдела до увольнения: ");
        for (int j = 0; j < xml.organization.get(0).getEmplsList().size(); j++) {
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getFirstname());
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getSecondname());
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getHiredate());
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getSalary());
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getJobtitle());
            System.out.println();
        }
        xml.fireEmployee("josh","jordan");
        System.out.println("Список отдела после увольнения: ");
        for (int j = 0; j < xml.organization.get(0).getEmplsList().size(); j++) {
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getFirstname());
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getSecondname());
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getHiredate());
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getSalary());
            System.out.println(xml.organization.get(0).getEmplsList().get(j).getJobtitle());
            System.out.println();
        }

    }

}
