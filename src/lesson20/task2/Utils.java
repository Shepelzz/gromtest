package lesson20.task2;

public class Utils {
    private int limitTransactionsOerDayCount = 10;
    private int limitTransactionsOerDayAmount = 100;
    private int limitSimpleTransactionAmount = 40;
    private String[] cities = {"Kiev", "Odessa"} ;

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsOerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsOerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
