package lesson17.homework17_3;


public class Solution {
    public String mostCountedWord(String input){
        if(!(input == null) && !(input.trim().equals("")) && !(getIndexOfMaxValue(getSizes(getWords(input))) == -1))
            return getWords(input)[getIndexOfMaxValue(getSizes(getWords(input)))];
        return null;
    }

    private String[] getWords(String input){
        return input.trim().split(" |,|//|;");
    }

    private int[] getSizes(String[] words){
        int[] counts = new int[words.length];
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if (words[i] != null && checkBytes(words[i].getBytes()) && words[i].equals(words[j]))
                    counts[i] += 1;
        return counts;
    }

    private boolean checkBytes(byte[] bytes){
        boolean checkWord = false;
        for (byte b : bytes) {
            if ((b >= 65 && b <= 90) || (b >= 97 && b <= 122))
                checkWord = true;
            else
                return false;
        }
        return checkWord;
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
}
