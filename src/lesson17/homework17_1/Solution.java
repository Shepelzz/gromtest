package lesson17.homework17_1;

import java.util.Arrays;

public class Solution {

    public int countWords(String input){
        if(input == null || input.trim().equals(""))
            return 0;

        String[] words = input.trim().split(" |,|//|;");

        int countWords = 0;
        for(String w : words){
            if(checkBytes(w.getBytes())) {
                countWords++;
            }
        }
        return countWords;
    }
    private boolean checkBytes(byte[] bytes){
        boolean checkWord = false;
        for (byte b : bytes) {
            if ((b >= 65 && b <= 90) || (b >= 97 && b <= 122)) {
                checkWord = true;
            }
            else {
                checkWord = false;
                break;
            }
        }
        return checkWord;
    }
}
