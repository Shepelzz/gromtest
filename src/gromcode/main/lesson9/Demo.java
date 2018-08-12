package gromcode.main.lesson9;

import gromcode.main.lesson9.utils.Checker;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company("IBL", "Ukraine");
        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());

        //company.name = "IBM";

        Checker checker = new Checker();
        System.out.println(checker.checkCompanyName(company.getName()));
        System.out.println(checker.companyNamesValidatedCount);
    }
}
