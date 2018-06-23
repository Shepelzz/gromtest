package lesson17.homework17_0;

public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "test str here was here two times or not no test";

        System.out.println(solution.replace(str, "here", "PPP"));
        System.out.println();

        test();
    }

    public static void test(){
        Solution solution = new Solution();
        //1. input has no target word
        System.out.println("1. input has no target word: "+solution.replace("test str h was h two times or not no test", "here", "PPP"));

        //2. input is empty
        System.out.println("2. input is empty: "+solution.replace("", "here", "PPP"));

        //3. input is null
        System.out.println("3. input is null: "+solution.replace(null, "here", "PPP"));
    }
}
