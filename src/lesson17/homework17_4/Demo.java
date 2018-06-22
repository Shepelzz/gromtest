package lesson17.homework17_4;

public class Demo {
    public static void main(String[] args) {
        Solution solution= new Solution();
        //System.out.println(solution.validate("https://google.com"));
        //System.out.println(solution.validate("http://google.com"));
        //System.out.println(solution.validate("https://www.google.org"));
        //System.out.println(solution.validate("http://i.ua"));
        //System.out.println(solution.validate("https://google.net"));
        //System.out.println();
        //String sss = "https://google.org";
        //System.out.println(solution.validate(sss));


        test();
    }

    public static void test(){
        Solution solution= new Solution();

        //1. test protocol invalid
        System.out.println("htps://google.com: "+solution.validate("htps://google.com"));
        System.out.println("https://https://google.com: "+solution.validate("https://https://google.com"));

        //2. www.
        System.out.println("https://www.google.com: "+solution.validate("https://www.google.com"));

        //3. domain zone invalid
        System.out.println("https://www.google.com.ua: "+solution.validate("https://www.google.com.ua"));
        System.out.println("https://www.google.not: "+solution.validate("https://www.google.not"));

        //4. point or other symbol in body
        System.out.println("https://www.go.ogle.com: "+solution.validate("https://www.go.ogle.com"));
        System.out.println("https://www._google.com: "+solution.validate("https://www._google.com"));
        System.out.println("https://www.go-ogle.com: "+solution.validate("https://www.go-ogle.com"));

        //5. null value
        System.out.println("null: "+solution.validate(null));

        //6. empty values
        System.out.println(" "+solution.validate(" "));
        System.out.println("www.google.com: "+solution.validate("www.google.com"));
        System.out.println("https://.com: "+solution.validate("https://.com"));
        System.out.println("https://google: "+solution.validate("https://google"));
        System.out.println("tthttps://google: "+solution.validate("tthttps://google"));

        System.out.println("https://www.www.google.net: "+solution.validate("https://www.www.google.net"));
        System.out.println("https://google.com.com: "+solution.validate("https://google.com.com"));

    }
}
