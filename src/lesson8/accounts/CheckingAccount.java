package lesson8.accounts;

public class CheckingAccount extends Account{
    int limitOfExpences;

    public CheckingAccount(String bankName, String ownerName, int moneyAmount, int limitOfExpences) {
        super(bankName, ownerName, moneyAmount);
        this.limitOfExpences = limitOfExpences;
    }

    void withdraw(int amount){
        if(amount > limitOfExpences)
            return;
        moneyAmount -= amount;
    }
}
