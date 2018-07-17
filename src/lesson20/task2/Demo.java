package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();

        System.out.println(Arrays.toString(controller.transactionList()));

        //System.out.println(Arrays.toString(controller.transactionList(5)));

        try{
            Transaction t1 = new Transaction(1001, "Kiev", 1, "notes", TransactionType.INCOME, new Date());
            Transaction t2 = new Transaction(1002, "Kiev", 5, "notes", TransactionType.INCOME, new Date());
            Transaction t3 = new Transaction(1003, "Odessa", 5, "notes", TransactionType.INCOME, new Date());
            Transaction t4 = new Transaction(1004, "Kiev", 5, "notes", TransactionType.INCOME, new Date());
            Transaction t5 = new Transaction(1005, "Kiev", 5, "notes", TransactionType.OUTCOME, new Date());
            Transaction t6 = new Transaction(1006, "Kiev", 1, "notes", TransactionType.INCOME, new Date());
            Transaction t7 = new Transaction(1007, "Odessa", 1, "notes", TransactionType.INCOME, new Date());
            Transaction t8 = new Transaction(1008, "Odessa", 5, "notes", TransactionType.OUTCOME, new Date());
            Transaction t9 = new Transaction(1009, "Kiev", 5, "notes", TransactionType.OUTCOME, new Date());
            Transaction t10 = new Transaction(1010, "Kiev", 5, "notes", TransactionType.OUTCOME, new Date());
            Transaction t11 = new Transaction(1011, "Kiev", 5, "notes", TransactionType.INCOME, new Date());

            controller.save(t1);
            controller.save(t2);
            controller.save(t3);
            controller.save(t4);
            controller.save(t5);
            controller.save(t6);
            controller.save(t7);
            controller.save(t8);
            controller.save(t9);
            controller.save(t10);

            controller.save(t11);

        }catch (BadRequestException | InternalServerException e){
            System.out.println(e.getMessage());
        }

        try{
            Transaction t2 = new Transaction(1009, "Kiev", 8, "notes", TransactionType.INCOME, new Date());
            controller.save(t2);
        }catch (BadRequestException | InternalServerException e){
            System.out.println(e.getMessage());
        }

        for (Transaction tr : controller.transactionList())
            System.out.print("["+tr.getId()+"] ");

        try{
            Transaction t2 = new Transaction(1010, "Kiev", 8, "notes", TransactionType.INCOME, new Date());
            controller.save(t2);
        }catch (BadRequestException | InternalServerException e){
            System.out.println(e.getMessage());
        }

        System.out.print("\nCity = Odessa: ");
        for (Transaction tr : controller.transactionList("Odessa"))
            System.out.print("["+tr.getId()+"] ");

        System.out.print("\nCity = LA: ");
        for (Transaction tr : controller.transactionList("LA"))
            System.out.print("["+tr.getId()+"] ");

        System.out.print("\nAmount = 1: ");
        for (Transaction tr : controller.transactionList(1))
            System.out.print("["+tr.getId()+"] ");
    }
}
