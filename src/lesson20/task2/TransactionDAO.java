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

    private void validate(Transaction transaction) throws BadRequestException, InternalServerException{

        //сумма транзакций больше указ лимита
        if(transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit amount exceeded "+ transaction.getId()+ ". Can`t be saved");

        //сумма транз за день больше дневн лимита
        int sum = 0;
        int count = 0;
        for(Transaction tr : getTransactionsPerDay(transaction.getDateCreated())){
            sum += tr.getAmount();
            count++;
        }
        if(sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded "+ transaction.getId()+ ". Can`t be saved");

        //кол-во транз за день больше указ лимита
        if(count >= utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded "+ transaction.getId()+ ". Can`t be saved");

        //город не разрешен
        boolean isCityValid = false;
        for(String c : utils.getCities())
            if(transaction.getCity().equals(c))
                isCityValid = true;

        if(!isCityValid)
            throw new BadRequestException("Transaction city is not accepted: "+ transaction.getId()+". Can`t be saved");

        //не хватило места
        boolean isFreeCells = false;
        for(Transaction tr : transactions)
            if(tr == null){
                isFreeCells = true;
                break;
            }

        if(!isFreeCells)
            throw new InternalServerException("Not enough space to save transaction with id: "+transaction.getId());
    }

    public Transaction[] transactionList(){
        int count = 0;
        for(Transaction tr : transactions)
            if(tr != null)
                count++;

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions) {
            if (count != 0 && tr != null) {
                result[index] = tr;
                index++;
                count--;
            }
            else
                break;
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
        for (Transaction tr : transactions) {
            if (count != 0 && tr != null && tr.getCity().equals(city)) {
                result[index] = tr;
                index++;
                count--;
            } else
                break;
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
        for (Transaction tr : transactions) {
            if (count != 0 && tr != null && tr.getAmount() == amount) {
                result[index] = tr;
                index++;
                count--;
            } else
                break;
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
}
