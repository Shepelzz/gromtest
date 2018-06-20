package lesson17.homework17_3;

public class Solution {
    public String mostCountedWord(String input){
        if(input == null || input.trim().equals(""))
            return null;

        String[] words = input.trim().split(" ");
        int currentCounter = 0, maxCounter = 0;
        String maxCountedWord = null;

        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(words[i].equals(words[j]) && checkWord(words[i])){
                    currentCounter++;
                }
            }
            if(currentCounter > maxCounter){
                maxCounter = currentCounter;
                maxCountedWord = words[i];
            }
            currentCounter = 0;
        }
        return maxCountedWord;
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
