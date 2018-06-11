package lesson5;

import java.util.Arrays;

public class FirstArray {
    public static void main(String[] args) {
        int a = 10;

        int[] firstArray = new int[4];

        System.out.println(Arrays.toString(firstArray));

        firstArray[0] = 11;
        firstArray[1] = 200;
        firstArray[2] = -10;

        for(int i = 0; i < firstArray.length; i++)
            System.out.println(firstArray[i]);

        System.out.println(Arrays.toString(firstArray));

        //---------------------------------------------------------

        int[] secondArray = {1, 10, 15, 20, -50};
        System.out.println(Arrays.toString(secondArray));

        //foreach
        for(int element : secondArray) {
            System.out.println("foreach: "+element);
        }


    }
}
