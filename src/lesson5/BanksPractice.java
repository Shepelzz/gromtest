package lesson5;

import java.util.Arrays;

public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack","Ann", "Denis","Andrey","Nikolay","Irina","John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        //System.out.println(Arrays.toString(findClientsByBalance(names, balances, -100)));
        //System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));

        //depositMoney(names, balances, "Ann", 2000);
        //System.out.println(Arrays.toString(balances));


        //findClientsByBalance testing
        //массив клиентов null
        System.out.println(Arrays.toString(findClientsByBalance(null, balances, 40)));

        System.out.println(Arrays.toString(findClientsByBalance(names, balances, 40)));
        System.out.println(Arrays.toString(findClientsByBalance(names, balances, 0)));
        System.out.println(Arrays.toString(findClientsByBalance(names, balances, -60)));

        //findClientsWithNegativeBalance testing
        //массив клиентов null
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(null, balances)));

        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));
        balances = new int[]{-100, 500, 8432, -99, 12000, -54, 0};
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));

        //depositMoney testing
        //имя не в базе
        depositMoney(names, balances, "Jack1", 9000);
        //баланс отрицательный
        depositMoney(names, balances, "Jack", -9000);
        System.out.println(Arrays.toString(balances));
        //массив клиентов null
        depositMoney(null, balances, "Jack", 9000);
        //клиент null
        depositMoney(names, balances, null, 9000);

        //findClientIndexByName testing
        //массив клиентов null
        System.out.println(findClientIndexByName(null, "Ann"));
        //клиент null
        System.out.println(findClientIndexByName(names, null));
        //имя не в базе
        System.out.println(findClientIndexByName(names, "Kolya"));

        //calculateDepositAmountAfterCommission testing
        // <= 100 == 0.02
        System.out.println(calculateDepositAmountAfterCommission(98));
        // > 100 == 0.01
        System.out.println(calculateDepositAmountAfterCommission(1010));
        // отрицательное
        System.out.println(calculateDepositAmountAfterCommission(-1));
    }

    static String[] findClientsByBalance(String[] clients, int[] balances, int n){
        if(clients == null)
            return null;

        int count = 0;
        for (int balance : balances) {
            if(balance >= n)
                count++;
        }
        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if(balance >= n){
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    static String[] findClientsWithNegativeBalance(String[] clients, int[] balances){
        if(clients == null)
            return null;

        int count = 0;
        for (int balance : balances) {
            if(balance < 0)
                count++;
        }
        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if(balance < 0){
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    static void depositMoney(String[] clients, int[] balances, String client, int money){
        if(money <= 0 || clients == null || client == null)
            return;
        for(String c : clients){
            if(c == client)
                balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterCommission(money);
        }
    }

    static int findClientIndexByName(String[] clients, String client){
        if(clients == null || client == null)
            return 0;

        int clientIndex = 0;
        int index = 0;
        for (String cl : clients){
            if(cl == client){
                clientIndex = index;
                break;
            }
            index++;
        }
        return clientIndex;
    }

    static int calculateDepositAmountAfterCommission(int money){
        return money <=100 ? (int) (money - money * 0.02) : (int)(money - money *0.01);
    }
}
