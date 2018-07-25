package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        //проверить лимит
        //проверить достаточно ли денег
        if(!checkUser(user) || !checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "sdfsd");
    }

    @Override
    public void fund(User user, int amount) {
        //проверить amount >= 0
        //проверить лимит
        if(!checkUser(user) || !checkFundLimits(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "sdfsd");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //снимаем деньги
        //пополняем с fromUser - ToUser
        if(!checkUser(fromUser) || !checkWithdraw(fromUser, amount))
            return;
        if(!checkUser(toUser) || !checkFundLimits(toUser, amount))
            return;
        if(fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()){
            System.err.println("Cant send money "+ amount + " from user: different currency");
            return;
        }


        withdraw(fromUser, amount);
        fund(toUser, amount);

        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "sdfsd");
    }

    @Override
    public void paySalary(User user) {
        if(!checkUser(user)){
            paySallaryErrorMsg();
            return;
        }
        //зачислить к зп
        fund(user, user.getSalary());

        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "sdfsd");
    }

    private void withdrawalErrorMsg(User user, int amount){
        if(user == null)
            System.err.println("Cant withdraw money "+ amount);
        System.err.println("Cant withdraw money "+ amount + " from user" + user.toString());
    }
    private void fundingErrorMsg(User user, int amount){
        if(user == null)
            System.err.println("Cant fund money "+ amount);
        System.err.println("Cant fund money "+ amount + " to user" + user.toString());
    }
    private void paySallaryErrorMsg(){
        System.err.println("Cant pay salary");
    }

    private boolean checkWithdraw(User user, int amount){
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal())
                && checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit){
        if(amount <= 0 || amount + user.getBank().getCommission(amount) > limit) {
            withdrawalErrorMsg(user, amount);
            return false;
        }
        return true;
    }

    private boolean checkFundLimits(User user, int amount){
        if(amount <= 0 || amount > user.getBank().getLimitOfFunding()){
            fundingErrorMsg(user, amount);
            return false;
        }
        return true;
    }

    private boolean checkUser(User user){
        if(user == null || user.getBank() == null)
            return false;
        return true;
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr){
        Random random = new Random();
        Transaction tr = new Transaction(random.nextLong(), dateCreated, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
