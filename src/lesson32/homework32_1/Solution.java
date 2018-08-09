package lesson32.homework32_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void readNumbers() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte numberOfAttempts = 3;

        while(numberOfAttempts != 0){
            String input = br.readLine();
            String[] items = input.split(" ");

            if(!validate(items)){
                if(numberOfAttempts == 1) {
                    System.out.println("Your numbers are wrong. Number attempts exceeded");
                    return;
                }

                System.out.println("Your numbers are wrong. You have " + --numberOfAttempts + " attempts to try again");
                continue;
            }

            int res = 0;
            for(String item : items)
                res += Integer.parseInt(item);

            System.out.println(res);
            return;
        }
    }

    private static boolean validate(String[] input){
        if(input.length != 10)
            return false;

        for(String item : input){
            for(char ch : item.toCharArray())
                if(!Character.isDigit(ch))
                    return false;

            if(Integer.parseInt(item) > 100)
                return false;
        }
        return true;
    }
}
