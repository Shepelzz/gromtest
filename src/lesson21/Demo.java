package lesson21;

public class Demo {

    public static void main(String[] args) throws Exception{
        Company company = new Company(100, "Nokia");
        Company.setLicense("GTtpods4");

        System.out.println(company.getLicense());

        Company company1 = new Company(9, "Test");
        System.out.println(company1.getLicense());

        Company.setLicense("1234");

        System.out.println(company.getLicense());
        System.out.println(company1.getLicense());

        //Company.validate();

        //demo utils
        int min = ArrayUtils.minElement(new int[]{1,2,3,4});

    }
}
