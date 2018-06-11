package lesson8.phones;

public class IPhone extends Phone{
    boolean fingerPrint;

    public IPhone(int price, double weight, String countryProduced, boolean fingerPrint) {
        super(price, weight, countryProduced);
        this.fingerPrint = fingerPrint;
        System.out.println("iPhone constructor was invoked...");
    }

    void deleteIPhoneFromDb(){
        System.out.println("delete iphone");
    }
}
