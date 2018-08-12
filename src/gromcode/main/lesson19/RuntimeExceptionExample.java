package gromcode.main.lesson19;

public class RuntimeExceptionExample {
    public static void main(String[] args) {
        //arithmetic exception
        arithmeticException(2);
        try {
            arithmeticException(0);
        } catch (ArithmeticException e){
            System.out.println("Something wrong");
        }

        npe(new Object());
        npe(null);
    }

    private static void arithmeticException(int a){
        System.out.println(10 / a);
    }

    private static void npe(Object o){
        if(o != null)
            System.out.println(o.hashCode());

    }
}
