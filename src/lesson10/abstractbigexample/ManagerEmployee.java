package lesson10.abstractbigexample;

public class ManagerEmployee extends Employee{

    @Override
    void paySallary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth();
        newBalance += newBalance * 0.25;
        getBankAccount().setBalance(newBalance);
    }
}
