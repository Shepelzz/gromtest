package lesson18.homework18_2;

public class Solution {
    public int[] findNumbers(String text){
        String[] words = text.trim().split(" ");

        int intCount = 0;
        for (String word : words) {
            if(checkWord(word))
                intCount++;
        }

        int[] numbers = new int[intCount];

        int index = 0;
        for (String word : words) {
            if(checkWord(word)) {
                numbers[index] = Integer.parseInt(word);
                index++;
            }
            else
                System.out.println("not a number");
        }
        return numbers;
    }

    private boolean checkWord(String word){
        for(Character ch : word.toCharArray())
            if(!Character.isDigit(ch))
                return false;
        return true;
    }
}
