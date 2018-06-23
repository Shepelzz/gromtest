package lesson17.homework17_0;

public class Solution {

    public String replace(String input, String target, String replacement){
        if(input == null || input.trim().equals(""))
            return null;

        while(input.indexOf(target) != -1){
            String beforeTarget = input.substring(0, input.indexOf(target));
            String afterTarget = input.substring(input.indexOf(target) + target.length());

            input = beforeTarget + replacement + afterTarget;
        }

        return input;
    }
}
