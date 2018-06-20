package lesson17.homework17_3;

public class Solution {
    public String mostCountedWord(String input){
        if(input == null || input.trim().equals(""))
            return null;

        String[] words = input.trim().split(" ");

        int wordCount = 1;
        String mostCountedWord = null;

        for(String w1 : words){
            int counter = 0;
            for(String w2 : words){
                if(checkWord(w1) && w1.equals(w2)){
                    counter++;
                }
            }
            if(counter > wordCount) {
                wordCount = counter;
                mostCountedWord = w1;
            }
        }
        return mostCountedWord;
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
