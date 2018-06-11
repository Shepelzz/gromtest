package lesson7;

import java.util.Date;

public class DemoHomeWork {
    Order createOrder(){
        Order o = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy" );
        return o;
    }

    Order createOrderAndCallMethods(){
        Order o = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue" );
        o.checkPrice();
        o.confirmOrder();
        o.isValidType();
        return o;
    }
}
