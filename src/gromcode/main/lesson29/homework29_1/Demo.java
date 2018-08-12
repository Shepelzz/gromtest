package gromcode.main.lesson29.homework29_1;

public class Demo {
    public static void main(String[] args) {

        HashSetTest hashSetTest = new HashSetTest();

        for(Order order : hashSetTest.useHashTest()){
            System.out.println(order.getId());
        }

    }
}
