package lesson18.homework18_1;

public class Solution {
    public int[] findNumbers(String text){
        try {
            String[] words = text.trim().split(" ");

            int intCount = 0;
            for (String word : words) {
                try {
                    Integer.parseInt(word);
                    intCount++;
                } catch (Exception e) {
                }
            }

            int[] numbers = new int[intCount];

            int index = 0;
            for (String word : words) {
                try {
                    numbers[index] = Integer.parseInt(word);
                    index++;
                } catch (Exception e) {
                    System.out.println("not a number");
                }
            }

            return numbers;
        } catch (Exception e){
            return new int[0];
        }
    }
}
