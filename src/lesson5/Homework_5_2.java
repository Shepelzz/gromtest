package lesson5;

import java.util.Arrays;

public class Homework_5_2 {
    public static void main(String[] args) {
        String[] names = {"Jack","Ann", "Denis","Andrey","Nikolay","Irina","John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        /*System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(balances));

        System.out.println(withdraw(names, balances, "Denis", 55000));

        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(balances));*/

        //withdraw тест
        //массим клиентов null
        System.out.println(withdraw(null, balances, "Jack", 50));
        //клиент null
        System.out.println(withdraw(names, balances, null, 50));
        //сумма больше балланса
        System.out.println(withdraw(names, balances, "Jack", 500));
        //сумма меньше 0
        System.out.println(withdraw(names, balances, "Jack", -50));

        //findClientIndexByName тест
        //массим клиентов null
        System.out.println(findClientIndexByName(null, "Ann"));
        //клиент null
        System.out.println(findClientIndexByName(names, null));
        //проверка результата
        System.out.println(Arrays.toString(names));
        System.out.println(findClientIndexByName(names, "Ann"));

    }

    static int withdraw(String[] clients, int[] balances, String client, int amount){
        if(clients == null || client == null || balances[findClientIndexByName(clients, client)] < amount || amount <= 0)
            return 0;

        balances[findClientIndexByName(clients, client)] -= amount;
        return balances[findClientIndexByName(clients, client)];
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
}
