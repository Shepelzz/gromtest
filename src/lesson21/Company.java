package lesson21;

public class Company {
    private int numberOfEmployees;
    private String name;

    private static String license;
    private static int maxNumberOfEmployees;

    static {
        System.out.println("code block is called");
        init();
    }

    public Company(int numberOfEmployees, String name) throws Exception{
        if(numberOfEmployees > maxNumberOfEmployees)
            throw new Exception("Company can have "+maxNumberOfEmployees+" employees");
        this.numberOfEmployees = numberOfEmployees;
        this.name = name;
    }

    public static void validate() throws Exception{
        if(license != "1234")
           throw new Exception("Wrong license");
    }

    public static void setLicense(String license) {
        Company.license = license;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }

    private static void init(){
        maxNumberOfEmployees = 100;
    }

//    private static class Test{
//
//
//    }
}
