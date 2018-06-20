package lesson17.homework17_3;

public class Demo {
    public static void main(String[] args) {
        String str = "y rr g word word word word tr word ur   iii w0rd";
        Solution solution = new Solution();
        System.out.println(solution.mostCountedWord(str));
        System.out.println();

        test();
    }

    public static void test(){
        Solution solution = new Solution();

        //0. работа с разделителями
        System.out.println(solution.mostCountedWord("y word  word tr tr word ur    iii w0rd"));

        //1.null value
        System.out.println(solution.mostCountedWord(null));

        //2. first char == space
        System.out.println(solution.mostCountedWord(" ffff iii iii ii"));

        //3." " value
        System.out.println(solution.mostCountedWord(" "));

        //4/ "" value
        System.out.println(solution.mostCountedWord(""));

        //5. not text values
        System.out.println(solution.mostCountedWord("123 123 456 7   8 454lo lo lo "));

        //6. diff case words
        System.out.println(solution.mostCountedWord("Upper lowER C_se C_se"));

        //7. е повтор слова
        System.out.println(solution.mostCountedWord("qw qe qt qr"));

        //8. 2 слова одинаково повторяются
        System.out.println(solution.mostCountedWord("qw qw qt qt y"));
    }
}
