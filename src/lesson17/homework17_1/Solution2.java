package lesson17.homework17_1;

public class Solution2 {
    public int countWords(String input){
        if(input != null) {
            int wordsCount = 0;
            char[] charList = input.toCharArray();

            String tempWord = "";
            for (int i = 0; i < charList.length; i++) {
                if (Character.isWhitespace(charList[i]) || i == charList.length - 1) {
                    if (checkWord(tempWord))
                        wordsCount++;
                    tempWord = "";
                } else {
                    tempWord = tempWord + charList[i];
                }
            }
            return wordsCount;
        }
        return 0;
    }

    private static boolean checkWord(String word){
        if(word == null || word.equals(""))
            return false;
        for(Character ch : word.toCharArray())
            if(!Character.isLetter(ch))
                return false;
        return true;
    }
}
