package lesson8.hw8_1;

public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();
        int[] array = {10,2,3,4,50};

        System.out.println(adder.check(array));
        System.out.println(adder.add(2,6));
    }
}
