package gromcode.main.lesson10.homework10_1;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        testElectronicsOrder();
        testFurnitureOrder();

        /*Customer customer1 = new Customer("Альона", "Одесса", "Женский");
        Customer customer2 = new Customer("Михаил", "Буча", "Мужской");
        Customer customer3 = new Customer("Test", "Полтава", "Мужской");
        Customer customer4 = new Customer("Анна", "Киев", "Женский");

        ElectronicsOrder eOrder1 = new ElectronicsOrder("Пылесос", new Date(), "Киев", "Одесса", 4500, customer1, 12);
        eOrder1.validateOrder();
        eOrder1.calculatePrice();
        eOrder1.confirmShipping();

        ElectronicsOrder eOrder2 = new ElectronicsOrder("Флешка", new Date(), "Одесса", "Буча", 300, customer2, 3);
        eOrder2.validateOrder();
        eOrder2.calculatePrice();
        eOrder2.confirmShipping();

        FurnitureOrder fOrder1 = new FurnitureOrder("Шторы", new Date(), "Полтава", "Киев", 1000, customer3, "Str99734");
        fOrder1.validateOrder();
        fOrder1.calculatePrice();
        fOrder1.confirmShipping();

        FurnitureOrder fOrder2 = new FurnitureOrder("Ковер", new Date(), "Харьков", "Одесса", 2100, customer4, "453rfdtg");
        fOrder2.validateOrder();
        fOrder2.calculatePrice();
        fOrder2.confirmShipping();*/


        /*Customer customer7 = new Customer("Альона", "Одесса", "Женский");
        FurnitureOrder eOrder7 = new FurnitureOrder("Пылесос", new Date(), "xcvfxc", "Бровары", 1001, customer7, "fdgd");
        eOrder7.validateOrder();
        eOrder7.calculatePrice();
        System.out.println(eOrder7.getDateConfirmed());
        System.out.println(eOrder7.getTotalPrice());*/
    }

    static void testElectronicsOrder(){
        {
            //validateOrder city not in list
            System.out.print("testElectronicsOrder - validateOrder - city not in list: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new ElectronicsOrder("Пылесос", new Date(), "Житомир", "Одесса", 4500, customer, 12);
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //validateOrder cities are null
            System.out.print("testElectronicsOrder - validateOrder - cities are null: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new ElectronicsOrder("Пылесос", new Date(), null, null, 4500, customer, 12);
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //validateOrder customer is null
            System.out.print("testElectronicsOrder - validateOrder - customer is null: ");
            Order eOrder = new ElectronicsOrder("Пылесос", new Date(), "Одесса", "Киев", 4500, null, 12);
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //validateOrder price < 100
            System.out.print("testElectronicsOrder - validateOrder - price < 100: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new ElectronicsOrder("Пылесос", new Date(), "Одесса", "Киев", 50, customer, 12);
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //validateOrder gender = m
            System.out.print("testElectronicsOrder - validateOrder - gender = m: ");
            Customer customer = new Customer("Саня", "Киев", "Мужской");
            Order eOrder = new ElectronicsOrder("Пылесос", new Date(), "Одесса", "Киев", 50, customer, 12);
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //calculatePrice toCity is Kiev or Odessa
            System.out.print("testElectronicsOrder - calculatePrice - price < 0: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            String[] cities = {"Киев","Одесса"};
            boolean check = false;
            for(String c : cities){
                Order eOrder = new ElectronicsOrder("Пылесос", new Date(), "Ужгород", c, 150, customer, 12);
                eOrder.calculatePrice();
                if(eOrder.getTotalPrice() == 165)
                    check = true;
            }
            System.out.println(check ? "\tOk" : "\tFAIL!");
        }
        {
            //calculatePrice toCity is not Kiev or Odessa
            System.out.print("testElectronicsOrder - calculatePrice - price < 0: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new ElectronicsOrder("Пылесос", new Date(), "Ужгород", "Ужгород", 150, customer, 12);
            eOrder.calculatePrice();
            System.out.println(eOrder.getTotalPrice() == 172.5 ? "\tOk" : "\tFAIL!");
        }
        {
            //calculatePrice price < 0
            System.out.print("testElectronicsOrder - calculatePrice - price < 0: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new ElectronicsOrder("Пылесос", new Date(), "Ужгород", "Ужгород", -500, customer, 12);
            eOrder.calculatePrice();
            System.out.println(eOrder.getTotalPrice() == 0 ? "\tOk" : "\tFAIL!");
        }
        {
            //calculatePrice shipment for price > 1000
            System.out.print("testElectronicsOrder - calculatePrice - shipment for price > 1000: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new ElectronicsOrder("Пылесос", new Date(), "Ужгород", "Ужгород", 2000, customer, 12);
            eOrder.calculatePrice();
            System.out.println(eOrder.getTotalPrice() == 2185.0 ? "\tOk" : "\tFAIL!");
        }
    }

    static void testFurnitureOrder(){
        {
            //validateOrder city not in list
            System.out.print("testFurnitureOrder - validateOrder - city not in list: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new FurnitureOrder("Ковер", new Date(), "Харьков", "Одесса", 2100, customer, "453rfdtg");
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //validateOrder cities are null
            System.out.print("testFurnitureOrder - validateOrder - cities are null: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new FurnitureOrder("Ковер", new Date(), "Киев", null, 2100, customer, "453rfdtg");
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //validateOrder customer id null
            System.out.print("testFurnitureOrder - validateOrder - customer id null: ");
            Order eOrder = new FurnitureOrder("Ковер", new Date(), "Харьков", "Одесса", 2100, null, "453rfdtg");
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //validateOrder price < 500
            System.out.print("testFurnitureOrder - validateOrder - price < 500: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new FurnitureOrder("Ковер", new Date(), "Киев", "Харьков", 100, customer, "453rfdtg");
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //validateOrder name = "Тест"
            System.out.print("testFurnitureOrder - validateOrder - name = \"Тест\": ");
            Customer customer = new Customer("Тест", "Одесса", "Женский");
            Order eOrder = new FurnitureOrder("Ковер", new Date(), "Киев", "Харьков", 8000, customer, "453rfdtg");
            eOrder.validateOrder();
            System.out.println(eOrder.getDateConfirmed() == null ? "\tOk" : "\tFAIL!");
        }
        {
            //calculatePrice shipment for price >= 5000
            System.out.print("testFurnitureOrder - calculatePrice - shipment for price > 5000: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new FurnitureOrder("Ковер", new Date(), "Киев", "Харьков", 8000, customer, "453rfdtg");
            eOrder.calculatePrice();
            System.out.println(eOrder.getTotalPrice() == 8160.0 ? "\tOk" : "\tFAIL!");
        }
        {
            //calculatePrice shipment for price < 5000
            System.out.print("testFurnitureOrder - calculatePrice - shipment for price > 5000: ");
            Customer customer = new Customer("Альона", "Одесса", "Женский");
            Order eOrder = new FurnitureOrder("Ковер", new Date(), "Киев", "Харьков", 3000, customer, "453rfdtg");
            eOrder.calculatePrice();
            System.out.println(eOrder.getTotalPrice() == 3150.0 ? "\tOk" : "\tFAIL!");
        }
    }
}
