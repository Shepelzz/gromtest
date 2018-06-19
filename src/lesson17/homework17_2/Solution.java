package lesson17.homework17_2;

public class Solution {
    public String maxWord(String input){
        if(!(input == null) && !(input.trim().equals("")))
            for(String w : sortDescending(getWords(input)))
                if(checkWord(w))
                    return w;
        return null;
    }

    public String minWord(String input){
        if(!(input == null) && !(input.trim().equals("")))
            for(String w : sortAscending(getWords(input)))
                if(checkWord(w))
                    return w;
        return null;
    }



    private String[] getWords(String input){
        return input.trim().split(" |,|//|;");
    }

    private String[] sortAscending(String[] words){
        for(int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if (words[j].length() < words[i].length()) {
                    String min = words[j];
                    words[j] = words[i];
                    words[i] = min;
                }
        return words;
    }

    private String[] sortDescending(String[] words){
        for(int i = words.length-1; i >= 0; i--)
            for (int j = i - 1; j >= 0; j--)
                if (words[j].length() < words[i].length()) {
                    String max = words[i];
                    words[i] = words[j];
                    words[j] = max;
                }
        return words;
    }

    private boolean checkWord(String word){
        if(word == null || word.equals(""))
            return false;
        for(Character ch : word.toCharArray())
            if(!Character.isLetter(ch))
                return false;
        return true;
    }
}
