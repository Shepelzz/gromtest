package gromcode.main.lesson6;

public class Car {

    //test git
    //test2

    int price;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;

    public Car(int price, int yearOfManufacturing, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.ownerName = ownerName;
    }

/*    void startRun(){
        System.out.println("I am running....");
    }*/

    void stopRun(){
        System.out.println("I am stopping....");
    }

    void changeOwner(String newOwnerName){
        ownerName = newOwnerName;
    }
}
