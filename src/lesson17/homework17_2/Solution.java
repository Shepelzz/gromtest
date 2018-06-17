package lesson17.homework17_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    public String maxWord(String input){
        if(!(input == null) && !(input.trim().equals("")))
            for(String w : sortDescending(getWords(input)))
                if(w != null && checkBytes(w.getBytes()))
                    return w;
        return null;
    }

    public String minWord(String input){
        if(!(input == null) && !(input.trim().equals("")))
            for(String w : sortAscending(getWords(input)))
                if(w != null && checkBytes(w.getBytes()))
                    return w;
        return null;
    }

    private String[] getWords(String input){
        return input.trim().split(" |,|//|;");
    }

    private String[] sortAscending(String[] words){
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++)
                if (words[j].length() < words[i].length()) {
                    String min = words[j];
                    words[j] = words[i];
                    words[i] = min;
                }
        }
        return words;
    }

    private String[] sortDescending(String[] words){
        for(int i = words.length-1; i >= 0; i--){
            for(int j = i-1; j >= 0; j--)
                if (words[j].length() < words[i].length()) {
                    String max = words[i];
                    words[i] = words[j];
                    words[j] = max;
                }
        }
        return words;
    }

    private boolean checkBytes(byte[] bytes){
        boolean checkWord = false;
        for (byte b : bytes) {
            if ((b >= 65 && b <= 90) || (b >= 97 && b <= 122)) {
                checkWord = true;
            }
            else {
                return false;
            }
        }
        return checkWord;
    }

}
