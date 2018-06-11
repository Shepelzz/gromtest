package lesson10.homework10_1;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        String[] cities = {"Киев","Одесса","Днепр","Харьков"};

        if(checkCity(cities, getShipFromCity()) && checkCity(cities, getShipToCity()) && getBasePrice() >= 100 && getCustomerOwned().getGender() == "Женский"){
                setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        int price = getBasePrice();
        double shipmentPrice = price * 0.1;
        if(getShipToCity() != "Киев" && getShipToCity() != "Одесса")
            shipmentPrice = price * 0.15;
        double totalPrice = price+shipmentPrice;
        if(price > 1000)
            totalPrice = totalPrice - totalPrice * 0.05;
        setTotalPrice(totalPrice);
    }
}
