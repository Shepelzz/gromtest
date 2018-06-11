package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "USA", Currency.USD, 520, 2100, 4,10000505);
        Bank euBank = new EUBank(1373, "Sweden", Currency.EUR, 120, 1800, 5,84400);
        Bank chinaBank = new ChinaBank(1004, "China", Currency.USD, 1500, 500, 34,94008008);

        User user1 = new User(1001, "Denis", 1000, 40, "GMD", 1750, usBank);
        User user2 = new User(1002, "Anton", 500, 3, "GMD", 600, usBank);
        User user3 = new User(1003, "Liza", 50877, 84, "GMD", 3220, euBank);
        User user4 = new User(1004, "Matt", 120, 1, "GMD", 1100, euBank);
        User user5 = new User(1005, "Chu", 5, 2, "GMD", 300, chinaBank);
        User user6 = new User(1006, "Ju", 8055, 26, "GMD", 1600, chinaBank);

        User[] users = {user1, user2, user3, user4, user5, user6};

        BankSystem bankSystem = new UkrainianBankSystem();

        /*System.out.println(user1.toString());
        System.out.println(user3.toString());

        bankSystem.transferMoney(user1, user3, 100);
        System.out.println();

        System.out.println(user1.toString());
        System.out.println(user3.toString());*/

        for(User user : users){
            bankSystem.withdraw(user, 150);
            bankSystem.fund(user, 59);
            bankSystem.transferMoney(user, user2, 43);
            bankSystem.paySalary(user);

            System.out.println(user.getBalance());
        }
    }
}
