package lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {
        long s = 0;
        for(int i = 0; i <= 1000; i++){
            s += i;
        }
        System.out.println(s);
    }
}
