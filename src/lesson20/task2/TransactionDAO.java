package lesson20.task2;
import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private  Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException{
        validate(transaction);

        int index = 0;
        for(Transaction tr : transactions) {
            if (tr == null){
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }
        throw new InternalServerException("Not enough space to save transaction with id: "+transaction.getId());
     }

    public Transaction[] transactionList(){
        int count = 0;
        for(Transaction tr : transactions)
            if(tr != null)
                count++;

        Transaction[] result = new Transaction[count];
        int index = 0;
        if(result.length != 0){
            for (Transaction tr : transactions)
                if (count != 0 && tr != null) {
                    result[index] = tr;
                    index++;
                }
        }
        return result;
    }

    public Transaction[] transactionList(String city) throws BadRequestException{
        if(city == null)
            throw new BadRequestException("Can`t show transaction list by null city");

        int count = 0;
        for(Transaction tr : transactions)
            if(tr != null && tr.getCity().equals(city))
                count++;

        Transaction[] result = new Transaction[count];
        int index = 0;
        if(result.length != 0){
            for (Transaction tr : transactions)
                if (tr != null && tr.getCity().equals(city)) {
                    result[index] = tr;
                    index++;
                }
        }
        return result;

    }

    public Transaction[] transactionList(int amount) throws BadRequestException{
        if(amount < 0)
            throw new BadRequestException("Can`t show transaction list by negative or zero amount");

        int count = 0;
        for(Transaction tr : transactions)
            if(tr != null && tr.getAmount() == amount)
                count++;

        Transaction[] result = new Transaction[count];
        int index = 0;
        if(result.length != 0) {
            for (Transaction tr : transactions)
                if (tr != null && tr.getAmount() == amount) {
                    result[index] = tr;
                    index++;
                }
        }
        return result;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurrentTracsaction){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurrentTracsaction);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for(Transaction transaction : transactions){
            if(transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trYear = calendar.get(Calendar.YEAR);
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if(trYear == year && trMonth == month && trDay == day){
                    count++;
                }
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for(Transaction transaction : transactions){
            if(transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trYear = calendar.get(Calendar.YEAR);
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if(trYear == year && trMonth == month && trDay == day){
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;
    }

    private void validate(Transaction transaction) throws BadRequestException, InternalServerException{

        checkSimpleTransactionLimit(transaction.getId(), transaction.getAmount());  //сумма транзакций больше указ лимита
        checkTransactionsPerDayLimit(transaction.getId(), transaction.getDateCreated(), transaction.getAmount());  //сумма и кол-во транз за день больше дневн лимита
        checkTransactionCity(transaction.getId(), transaction.getCity());  //город не разрешен
        checkTransactionDAOSpace(transaction.getId());  //не хватило места
    }

    private void checkSimpleTransactionLimit(long transactionId, int transactionAmount) throws LimitExceeded{
        if(transactionAmount > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit amount exceeded "+ transactionId + ". Can`t be saved");
    }

    private void checkTransactionsPerDayLimit(long transactionId, Date transactionDate, int currentTransactionAmount) throws LimitExceeded{
        int sum = currentTransactionAmount;
        int count = 1;
        for(Transaction tr : getTransactionsPerDay(transactionDate)){
            sum += tr.getAmount();
            count++;
        }
        if(sum >= utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded "+ transactionId + ". Can`t be saved");

        if(count >= utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded "+ transactionId + ". Can`t be saved");
    }

    private void checkTransactionCity(long transactionId, String transactionCity) throws BadRequestException{
        for(String c : utils.getCities())
            if(transactionCity.equals(c))
                return;
        throw new BadRequestException("Transaction city is not accepted: "+ transactionId+". Can`t be saved");
    }

    private void checkTransactionDAOSpace(long transactionId) throws InternalServerException{
        for(Transaction tr : transactions)
            if(tr == null)
                return;
        throw new InternalServerException("Not enough space to save transaction with id: "+transactionId);
    }
}
