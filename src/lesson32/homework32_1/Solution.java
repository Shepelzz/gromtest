package lesson32.homework32_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public void readNumbers() throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int sum = 0;
        int numberOfAttempts = 3;

        while(numberOfAttempts > 0){
            String input = br.readLine();

            try {
                if (input.split(" ").length == 10) {
                    for (String str : input.split(" "))
                        if (Integer.parseInt(str) <= 100)
                            sum += Integer.parseInt(str);

                    System.out.println(sum);
                    break;
                }
            } catch (NumberFormatException ex){}

            numberOfAttempts--;
            if (numberOfAttempts > 0)
                System.out.println("Your numbers are wrong. You have " + numberOfAttempts + " attempts to try again");
            else {
                System.out.println("Your numbers are wrong. Number attempts exceeded");
                break;
            }
        }
    }
}
