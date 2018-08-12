package gromcode.main.lesson4;

public class HomeworkL4 {
    public static void main(String[] args) {
        System.out.println(findDivCount((short) 1,(short)32767,10));

        //test
        //b<a
        //a,b > (short)
        System.out.println(findDivCount((short)1, (short)-10, 2));
        System.out.println(findDivCount((short)1, (short)32768, 2));
    }

    public static int findDivCount(short a, short b, int n){
        if(n > 0 && 0 <= a && a <=b) {
            int count = 0;
            for (int i = a; i <= b; i++) {
                if (i % n == 0)
                    count++;
            }
            return count;
        }
        else return 0;
    }

    public static String concat(String a, String b, String c){
        return a + b + c;
    }

    public static long sum(int from, int to){
        long sum = 0;
        for(long i = from; i<=to; i++)
            sum += i;
        return sum;
    }

    public static boolean compareSums(int a, int b, int c, int d){
        return sum(a,b) > sum(c,d) ? true : false;
    }

}
