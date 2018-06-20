package lesson17.homework17_3;

public class Demo {
    public static void main(String[] args) {
        String str = " 33 iui 33 iui oo oo o o oo";
        Solution solution = new Solution();
        System.out.println(solution.mostCountedWord(str));

        test();

    }

    public static void test(){
        Solution solution = new Solution();

        //0. работа с разделителями
        System.out.println("работа с разделителями: "+solution.mostCountedWord("y word  word tr tr word ur    iii w0rd"));

        //1.null value
        System.out.println("null value: "+solution.mostCountedWord(null));

        //2. first char == space
        System.out.println("first char == space: "+solution.mostCountedWord(" ffff iii iii ii"));

        //3." " value
        System.out.println("\" \" value: "+solution.mostCountedWord(" "));

        //4/ "" value
        System.out.println("\"\" value: "+solution.mostCountedWord(""));

        //5. not text values
        System.out.println("not text values: "+solution.mostCountedWord("123 123 456 7   8 454lo lo lo "));

        //6. diff case words
        System.out.println("diff case words: "+solution.mostCountedWord("Upper lowER C_se C_se"));

        //7. е повтор слова
        System.out.println("е повтор слова: "+solution.mostCountedWord("qw qe qt qr"));

        //8. 2 слова одинаково повторяются
        System.out.println("2 слова одинаково повторяются: "+solution.mostCountedWord("qw qw qt qt y"));
    }
}
