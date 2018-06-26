package lesson18.exercise2;

public class Converter {
    public static void main(String[] args) {

        System.out.println("\nintToString test:");
        System.out.println(intToString(121));
        System.out.println(intToString(-23));
        System.out.println(intToString(0));

        System.out.println("\nstringToInt test:");
        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("text"));
        System.out.println(stringToInt("123text"));
        System.out.println(stringToInt("-123"));
        System.out.println(stringToInt(null));
        System.out.println(stringToInt("2147483648"));

    }

    public static String intToString(int input){
        try{
            return String.valueOf(input);
        } catch (Exception e){
            System.out.println(input+" can not be converted to int");
            return null;
        }

    }

    public static int stringToInt(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException | ClassCastException e){
            System.out.println(input+" can not be converted to int");
            return 0;
        }
    }
}
