package lesson17.homework17_2;

public class Solution {
    public String maxWord(String input){
        if(input == null || input.trim().equals(""))
            return null;

        String[] words = input.trim().split(" ");
        String minWord = checkWord(words[0]) ? words[0] : "";
        for(int i = 1; i < words.length; i++){
            if(checkWord(words[i]) && words[i].length() > minWord.length()){
                minWord = words[i];
            }
        }
        return minWord.equals("") ? null : minWord;
    }

    public String minWord(String input){
        if(input == null || input.trim().equals(""))
            return null;

        String[] words = input.trim().split(" ");
        String minWord = checkWord(words[0]) ? words[0] : "";
        for(int i = 1; i < words.length; i++){
            if(checkWord(words[i]) && words[i].length() < minWord.length()){
                minWord = words[i];
            }
        }
        return minWord.equals("") ? null : minWord;
    }

    private boolean checkWord(String word){
        for(Character ch : word.toCharArray())
            if(!Character.isLetter(ch))
                return false;
        return true;
    }
}
