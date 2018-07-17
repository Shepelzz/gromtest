package lesson22.homework22_1;

import lesson22.homework22_1.exception.BadRequestException;
import lesson22.homework22_1.exception.InternalServerException;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(Controller.transactionList()));

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

            Controller.save(t1);
            Controller.save(t2);
            Controller.save(t3);
            Controller.save(t4);
            Controller.save(t5);
            Controller.save(t6);
            Controller.save(t7);
            Controller.save(t8);
            Controller.save(t9);
            Controller.save(t10);

            Controller.save(t11);

        }catch (BadRequestException | InternalServerException e){
            System.out.println(e.getMessage());
        }

        try{
            Transaction t2 = new Transaction(1009, "Kiev", 8, "notes", TransactionType.INCOME, new Date());
            Controller.save(t2);
        }catch (BadRequestException | InternalServerException e){
            System.out.println(e.getMessage());
        }

        for (Transaction tr : Controller.transactionList())
            System.out.print("["+tr.getId()+"] ");

        try{
            Transaction t2 = new Transaction(1010, "Kiev", 8, "notes", TransactionType.INCOME, new Date());
            Controller.save(t2);
        }catch (BadRequestException | InternalServerException e){
            System.out.println(e.getMessage());
        }

        System.out.print("\nCity = Odessa: ");
        for (Transaction tr : Controller.transactionList("Odessa"))
            System.out.print("["+tr.getId()+"] ");

        System.out.print("\nCity = LA: ");
        for (Transaction tr : Controller.transactionList("LA"))
            System.out.print("["+tr.getId()+"] ");

        System.out.print("\nAmount = 1: ");
        for (Transaction tr : Controller.transactionList(1))
            System.out.print("["+tr.getId()+"] ");
    }
}
