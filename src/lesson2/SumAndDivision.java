package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int s = 0, c1, c2;
        boolean b;

        for(int i = 1; i <= 1000; i++){
            s += i;
        }

        c1 = s / 1234;
        c2 = s % 1234;
        b = c2 > c1;
        System.out.println(b);
    }
}
