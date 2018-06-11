package lesson2;

public class LoopExercise {
    public static void main(String[] args) {
        int i=1;
        while (i<=20){
            if((i >= 5 && i <= 10) || (i >= 15 && i <= 20))
                System.out.println(i);
            i++;
        }
    }
}
