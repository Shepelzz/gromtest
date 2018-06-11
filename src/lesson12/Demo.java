package lesson12;

public class Demo {
    public static void main(String[] args) {
        //bank test

        Bank usBank = new USBank(1222, "USA", Currency.USD, 520, 2100, 4,10000505);
        Bank euBank = new EUBank(1373, "Sweden", Currency.EUR, 120, 1800, 5,84400);
        Bank chinaBank = new ChinaBank(1004, "China", Currency.USD, 1500, 500, 34,94008008);

        User user1 = new User(1001, "Denis", 300, 40, "GMD", 1750, usBank);
        User user2 = new User(1002, "Anton", 500, 3, "GMD", 600, usBank);
        User user3 = new User(1003, "Liza", 50877, 84, "GMD", 3220, euBank);
        User user4 = new User(1005, "Chu", 5, 2, "GMD", 300, chinaBank);
        User user5 = new User(1004, "Matt", 120, 1, "GMD", 1100, euBank);


        BankSystem bankSystem = new UkrainianBankSystem();

        //UkrainianBankSystem Test

        //method withdraw(User user, int amount)
        //1.user == null
        bankSystem.withdraw(null, 20);
        //2.amount <= 0
        System.out.println(user1.toString());
        bankSystem.withdraw(user1, -89);
        System.out.println(user1.toString());
        //3.balance < amount+commission
        bankSystem.withdraw(user1, 105110);
        System.out.println(user1.toString());
        //4.amount+commission > limit
        user1.setBalance(5000);
        bankSystem.withdraw(user1, 1000);

        //method fund(User user, int amount)
        //1.user == null
        bankSystem.fund(null, 600);
        //2.amount <= 0
        bankSystem.fund(user1, -200);
        //3.amount > limit
        bankSystem.fund(user3, 40000); //EUR
        bankSystem.fund(user1, 40000); //USD
        System.out.println(user3.toString());
        System.out.println(user1.toString());

        //method transferMoney(User fromUser, User toUser, int amount)
        //1.users == null
        bankSystem.transferMoney(null, user1, 200);
        bankSystem.transferMoney(user1, null, 200);
        //2.amount <= 0
        bankSystem.transferMoney(user1, user2, -90);
        //3.amount > limit
        bankSystem.transferMoney(user3, user5, 40000);
        //4. different currencies
        bankSystem.transferMoney(user1, user5, 500);

        //method paySalary(User user)
        //1.user == null
        bankSystem.paySalary(null);
        //2. salary < 0
        user1.setSalary(-900);
        bankSystem.paySalary(user1);
        System.out.println(user1.toString());
    }
}
