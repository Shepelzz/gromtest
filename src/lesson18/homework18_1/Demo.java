package lesson18.homework18_1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(Arrays.toString(solution.findNumbers("123 h5 45_ it 4 5 60 -444")));

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
