package lesson8.phones;

public class Android  extends Phone{
    String androidVersion;
    int screenSize;
    String secretdeviceCode;

    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secretdeviceCode) {
        super(price, weight, countryProduced);
        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretdeviceCode = secretdeviceCode;
    }

    void installNewAndroidVersion(){
        System.out.println("updating android...");
    }
}
