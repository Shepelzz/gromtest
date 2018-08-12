package gromcode.main.lesson6;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        /*Car carPbject = new Car(10000, 2015, "Anton");

        System.out.println(carPbject.color);
        System.out.println(carPbject.horsePower);

        System.out.println(carPbject.ownerName);

        carPbject.horsePower = 100;

        System.out.println(carPbject.horsePower);

        carPbject.startRun();
        carPbject.stopRun();

        carPbject.changeOwner("Test");
        System.out.println(carPbject.ownerName);*/


        Order order = new Order(1000, new Date(), true, new Date(), "City", "Country", "Sale");
        //confirmOrder тест
        order.confirmOrder();
        System.out.println(order.toString());

        //checkPrice тест

        //isValidType тест
    }
}
