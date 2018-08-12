package gromcode.main.lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        //проверить лимит
        //проверить достаточно ли денег
        if(!checkUser(user) || !checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        //проверить amount >= 0
        //проверить лимит
        if(!checkUser(user) || !checkFundLimits(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);
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
    }

    @Override
    public void paySalary(User user) {
        if(!checkUser(user)){
            paySallaryErrorMsg();
            return;
        }
        //зачислить к зп
        fund(user, user.getSalary());
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
}
