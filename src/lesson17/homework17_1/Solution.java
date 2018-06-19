package lesson17.homework17_1;

public class Solution {
    public int countWords(String input){
        if(input == null || input.trim().equals(""))
            return 0;

        String[] words = input.trim().split(" |,|//|;");

        int count = 0;
        for(String word : words)
            if(checkWord(word))
                count++;
        return count;
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
