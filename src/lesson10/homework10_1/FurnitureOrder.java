package lesson10.homework10_1;

import java.util.Date;

public class FurnitureOrder extends Order{
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        String[] cities = {"Киев","Львов"};

        if(checkCity(cities, getShipFromCity()) && getBasePrice() >= 500 && getCustomerOwned().getName() != "Тест"){
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        double shipmentPrice = getBasePrice() * 0.02;
        if(getBasePrice() < 5000)
            shipmentPrice = getBasePrice() * 0.05;
        double totalPrice = getBasePrice()+shipmentPrice;
        setTotalPrice(totalPrice);
    }
}
