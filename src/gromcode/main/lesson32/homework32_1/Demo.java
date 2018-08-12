package gromcode.main.lesson32.homework32_1;

        import java.io.IOException;

public class Demo {
    public static void main(String[] args){
        try{
            Solution.readNumbers();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
