package gromcode.main.lesson22.homework22_1;

import gromcode.main.lesson22.homework22_1.exception.BadRequestException;
import gromcode.main.lesson22.homework22_1.exception.InternalServerException;

public class Controller {

    public static Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        return TransactionDAO.save(transaction);
    }

    public static Transaction[] transactionList(){
        return TransactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city){
        return TransactionDAO.transactionList(city);
    }

    public static Transaction[] transactionList(int amount){
        return TransactionDAO.transactionList(amount);
    }

}
