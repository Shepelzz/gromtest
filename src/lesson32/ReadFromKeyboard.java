package lesson32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException{

        //readKeyboardWithScanner();

        readKeyboardWithIOStream();

    }

    private static void readKeyboardWithScanner(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name");
        String input = scanner.nextLine();

        if(validate(input))
            System.out.println("Hello "+input+"!");
        else
            System.out.println("error");

        scanner.close();

    }

    private static void readKeyboardWithIOStream() throws IOException{

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");
        String input = br.readLine();

        if(validate(input))
            System.out.println("Hello "+input+"!");
        else
            System.out.println("error");
    }

    private static boolean validate(String text){
        return text.split(" ").length == 1 ? true : false;
    }
}
