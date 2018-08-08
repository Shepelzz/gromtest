package lesson32.homework32_1;

        import java.io.IOException;

public class Demo {
    public static void main(String[] args){
        Solution solution = new Solution();
        try{
            solution.readNumbers();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
