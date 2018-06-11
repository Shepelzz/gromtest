package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int s = 0;
        int a = 1000;

        for(int i = 0; i <= 1000; i++) {
            if(i%2 != 0) {
                System.out.println("Found");

                s += i;
            }
        }

        s *= 5;

        if(s > a)
            System.out.println("Bigger");
        else
            System.out.println("Smaller or equals");
    }
}
