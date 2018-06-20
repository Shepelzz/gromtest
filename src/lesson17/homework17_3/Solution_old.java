package lesson17.homework17_3;

public class Solution_old {
    public String mostCountedWord(String input){
        if(input == null || input.trim().equals(""))
            return null;
        String[] words = input.trim().split(" ");
        if((getIndexOfMaxValue(getSizes(words)) != -1))
            return getWords(input)[getIndexOfMaxValue(getSizes(words))];
        return null;
    }

    private String[] getWords(String input){
        if(input == null || input.trim().equals(""))
            return null;
        return input.trim().split(" ");
    }


    private int[] getSizes(String[] words){
        if(words == null)
            return null;
        int[] counts = new int[words.length];
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if (checkWord(words[i]) && words[i].equals(words[j]))
                    counts[i] += 1;
        return counts;
    }

    private int getIndexOfMaxValue(int[] arr){
        if (arr == null || arr.length == 0)
            return -1;

        int index = 0;
        int size = arr[0];
        for ( int i = 1; i < arr.length; i++ )
            if ( arr[i] > arr[index]) {
                index = i;
                size = arr[i];
            }
        return size <= 0 ? -1 : index;
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
