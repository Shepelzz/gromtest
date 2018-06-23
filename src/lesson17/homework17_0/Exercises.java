package lesson17.homework17_0;

public class Exercises {


    public String replace(String input, String target, String replacement){
        if(input == null)
            return input;
        if(target == null || replacement == null || target.trim() == "")
            return input;

        int cnt = getCount(input.toCharArray(), target.toCharArray()[0]);

        for(int i = 0; i < cnt; i++){
            int index = findStartIndex(input.toCharArray(), target.toCharArray()[0]);
            if(checkReplace(input.toCharArray(), target.toCharArray(), index)){
                input = replaceSingle(input, target, replacement, index);
            }
        }

        return input;
    }

    private int getCount(char[] inputChars, char beginningChar){
        int count = 0;
        for(char ch : inputChars)
            if(ch == beginningChar)
                count++;
        return count;
    }

    private int findStartIndex(char[] inputChars, char beginningChar){
        int index = 0;
        for(int i = 0; i < inputChars.length; i++)
            if(inputChars[i] == beginningChar) {
                index = i;
                break;
            }
        return index;
    }

    private boolean checkReplace(char[] inputChars, char[] replaceChars, int index){
        for(int i = 0; i < replaceChars.length && index < inputChars.length; i++, index++){
            if(inputChars[index] != replaceChars[i]){
                return false;
            }
        }
        return true;
    }

    private String replaceSingle(String input, String target, String replacement, int index){
        char[] res1 = new char[index];

        for(int i = 0; i < index; i++){
            res1[i] = input.toCharArray()[i];
        }

        char[] res3 = new char[input.length() - res1.length - target.length()];
        for(int i = 0, j = res1.length + target.length(); i < res3.length && j < input.length(); i++, j++){
            res3[i] = input.toCharArray()[j];
        }

        return new String(res1) + replacement + new String(res3);
    }
}
