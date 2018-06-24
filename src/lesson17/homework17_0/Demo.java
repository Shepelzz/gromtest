package lesson17.homework17_0;

public class Demo {
    public static void main(String[] args) {
        Exercises solution = new Exercises();
        String str = "test str here was here two times or not no test";

        System.out.println(solution.replace(str, "here", "here"));
        System.out.println();

        test();
    }

    public static void test(){
        Exercises solution = new Exercises();
        //1. input has no target word
        System.out.println("1. input has no target word: "+solution.replace("test str h was h two times or not no test", "here", "PPP"));

        //2. input is empty
        System.out.println("2. input is empty: "+solution.replace("", "here", "PPP"));

        //3. input is null
        System.out.println("3. input is null: "+solution.replace(null, "here", "PPP"));

        //4. target is null
        System.out.println("4. target is null: "+solution.replace("test str here was here two times or not no test", null, "PPP"));

        //5. replacement is null
        System.out.println("5. replacement is null: "+solution.replace("test str here was here two times or not no test", "here", null));

        //6. target is empty
        System.out.println("6. target is empty: "+solution.replace("test str here was here two times or not no test", "", "y"));

        //7. replacement is empty
        System.out.println("7. replacement is empty: "+solution.replace("test str here was here two times or not no test", "test", ""));

        //8. target == replacement
        System.out.println("8. target == replacement: "+solution.replace("test str here was here two times or not no test", "here", "here"));
    }
}
