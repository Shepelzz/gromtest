package lesson10.abstractbigexample;

public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExpirience;
    private String curPosition;

    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10];
    private String[] positionsWorked = new String[10];

    int getBalance(){
        return bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }

    abstract void paySallary();

    void changePosition(String newPosition){
        saveCurPositionToHistory();
        curPosition = newPosition;
    }

    private void saveCurPositionToHistory(){
        int index = 0;
        for (String pos : positionsWorked){
            if(pos != null){
                positionsWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }
}
