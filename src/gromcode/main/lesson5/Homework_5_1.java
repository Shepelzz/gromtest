package gromcode.main.lesson5;

import java.util.Arrays;

public class Homework_5_1 {
    public static void main(String[] args) {
        int[] array = {1, 989882, 3, -4, -58888};
        System.out.println(Arrays.toString(array));
        //System.out.println(Arrays.toString(sortAscending(array)));
        //System.out.println(Arrays.toString(sortDescending(array)));

        //sortAscending тест
        //порядок
        System.out.println(Arrays.toString(sortAscending(array)));
        //порядок при повторении
        array = new int[]{1, 989882, 3, 3, -58888};
        System.out.println(Arrays.toString(sortAscending(array)));

        //sortDescending тест
        //порядок
        System.out.println(Arrays.toString(sortDescending(array)));
    }

    static int[] sortAscending(int[] array){
        //пройтись по очереди по всем элементам массива
        //сравнить их с оставшимся массивом
        //если есть меньшие - поменять их местами

        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[j] < array[i]){
                    int min = array[j];
                    array[j] = array[i];
                    array[i] = min;
                }
            }
        }
        return array;
    }

    static int[] sortDescending(int[] array){
        for(int i = array.length-1; i >= 0; i--){
            for(int j = i-1; j >= 0; j--){
                if(array[j] < array[i]){
                    int max = array[i];
                    array[i] = array[j];
                    array[j] = max;
                }
            }
        }
        return array;
    }
}
