package lesson18.homework18_2;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Solution solution = new Solution();

        //1. letters in array
        System.out.println("letters in array: "+Arrays.toString(solution.findNumbers("1 2 3 hy 4k ii9 0")));
        System.out.println();

        //2. null input
        System.out.println("null input: "+Arrays.toString(solution.findNumbers(null)));
        System.out.println();

        //3. no digits
        System.out.println("letters in array: "+Arrays.toString(solution.findNumbers("q w e r t")));
        System.out.println();

    }
}
