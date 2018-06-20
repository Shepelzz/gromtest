package lesson17.homework17_2;

public class Demo {
    public static void main(String[] args) {
        //String str = "qwe qwer qwert y1   qw7ertyuio";
        Solution solution = new Solution();
        //System.out.println(solution.maxWord(str));
        //System.out.println(solution.minWord(str));
        //System.out.println();

        System.out.println(solution.minWord("  h yhy    "));

        //test();
    }

    public static void test(){
        Solution solution = new Solution();

        //0. работа с разделителями
        System.out.println(solution.maxWord("onE two thr7e Four FIVE   O"));
        System.out.println(solution.minWord("onE two thr7e Four FIVE   O"));

        //1.null value
        System.out.println(solution.maxWord(null));
        System.out.println(solution.minWord(null));

        //2. first char == space
        System.out.println(solution.maxWord(" ffff iii"));
        System.out.println(solution.minWord(" ffff iii"));

        //3." " value
        System.out.println(solution.maxWord(" "));
        System.out.println(solution.minWord(" "));

        //4/ "" value
        System.out.println(solution.maxWord(""));
        System.out.println(solution.minWord(""));

        //5. not text values
        System.out.println(solution.maxWord("123 456 7  8 454lololo "));
        System.out.println(solution.minWord("123 456 7  8 454lololo "));

        //6. diff case words
        System.out.println(solution.maxWord("Upper lowER C_se"));
        System.out.println(solution.minWord("Upper lowER C_se"));
    }
}
