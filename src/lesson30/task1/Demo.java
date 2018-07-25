package lesson30.task1;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        Bank euBank = new EUBank(1373, "Sweden", Currency.EUR, 120, 1800, 5,84400);
        User user1 = new User(1001, "Denis", 1000, 40, "GMD", 1750, euBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        bankSystem.withdraw(user1, 150);
        Thread.sleep(2000);
        bankSystem.withdraw(user1, 10);

        System.out.println(((UkrainianBankSystem) bankSystem).getTransactions());
    }
}