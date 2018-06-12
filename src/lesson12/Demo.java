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
        User user6 = new User(1001, "Denis1", 300, 40, "GMD", 1750, usBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        //--------------------------------------------------------------------------------------------------------------------------
        System.out.println("\n\n----------------------------------------------------------------------------------------");
        //UkrainianBankSystem Test
        System.out.println("UkrainianBankSystem Test");
        //method withdraw(User user, int amount)
        System.out.println("\nmethod withdraw(User user, int amount)");
        //1.user == null
        System.out.println("1.user == null");
        bankSystem.withdraw(null, 20);
        //2.amount <= 0
        System.out.println("2.amount <= 0");
        System.out.println(user1.toString());
        bankSystem.withdraw(user1, -89);
        System.out.println(user1.toString());
        //3.balance < amount+commission
        System.out.println("3.balance < amount+commission");
        bankSystem.withdraw(user1, (int) user1.getBalance()+100);
        System.out.println(user1.toString());
        //4.amount+commission > limit
        System.out.println("4.amount+commission > limit");
        user1.setBalance(user1.getBank().getLimitOfWithdrawal()+100);
        bankSystem.withdraw(user1, 1000);
        //5. user bank is null
        System.out.println("5.user bank is null");
        user6 = new User(1001, "Denis", 300, 40, "GMD", 1750, null);
        bankSystem.withdraw(user6, 20);

        //method fund(User user, int amount)
        System.out.println("\nmethod fund(User user, int amount)");
        //1.user == null
        System.out.println("1.user == null");
        bankSystem.fund(null, 600);
        //2.amount <= 0
        System.out.println("2.amount <= 0");
        bankSystem.fund(user1, -200);
        //3.amount > limit
        System.out.println("3.amount > limit");
        bankSystem.fund(user3, user3.getBank().getLimitOfFunding()+100); //EUR
        bankSystem.fund(user1, user1.getBank().getLimitOfFunding()+100); //USD
        System.out.println(user3.toString());
        System.out.println(user1.toString());
        //4. user bank is null
        System.out.println("4.user bank is null");
        bankSystem.fund(user6, 100); //USD

        //method transferMoney(User fromUser, User toUser, int amount)
        System.out.println("\nmethod transferMoney(User fromUser, User toUser, int amount)");
        //1.users == null
        System.out.println("1.users == null");
        bankSystem.transferMoney(null, user1, 200);
        bankSystem.transferMoney(user1, null, 200);
        //2.amount <= 0
        System.out.println("2.amount <= 0");
        bankSystem.transferMoney(user1, user2, -90);
        //3.amount > limit
        System.out.println("3.amount > limit");
        bankSystem.transferMoney(user3, user5, user3.getBank().getLimitOfWithdrawal()+500);
        //4. different currencies
        System.out.println("4. different currencies");
        bankSystem.transferMoney(user1, user5, 500);
        //5. user bank is null
        System.out.println("5.user bank is null");
        bankSystem.transferMoney(user6, user1, 20);

        //method paySalary(User user)
        System.out.println("\nmethod paySalary(User user)");
        //1.user == null
        System.out.println("1.user == null");
        bankSystem.paySalary(null);
        //2. salary < 0
        System.out.println("2. salary < 0");
        user1.setSalary(-900);
        bankSystem.paySalary(user1);
        System.out.println(user1.toString());
        //3. user bank is null
        System.out.println("3.user bank is null");
        bankSystem.paySalary(user6);
    }
}
