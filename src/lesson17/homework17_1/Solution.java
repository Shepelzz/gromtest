package lesson17.homework17_1;

import java.util.Arrays;

public class Solution {

    int countWords(String input){
        String[] words = input.split(" ");

        int countWords = 0;
        for(String w : words){
            boolean checkWord = true;
            for(int i = 0; i< w.length(); i++){
                //System.out.println(w.charAt(i)+ "-"+ (int) w.charAt(i));
                if(!((int) w.charAt(i) >= 65 && (int) w.charAt(i) <= 90) && !((int) w.charAt(i) >= 97 && (int) w.charAt(i) <= 122)){
                    checkWord = false;
                    break;
                }
            }
            if(checkWord)
                countWords++;
        }

        return countWords;
    }
}
