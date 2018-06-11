package lesson3;


public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 60;
        int b = 13;
        int c = 0;

        c = a & b;
        System.out.println(c);

        c = a | b;
        System.out.println(c);

        c = a ^ b;
        System.out.println(c);

        c = a << 2;
        System.out.println(c);

        c = a >> 2;
        System.out.println(c);
    }
}
