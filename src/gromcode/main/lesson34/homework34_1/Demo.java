package gromcode.main.lesson34.homework34_1;

public class Demo {
    public static void main(String[] args){
        String fileFromPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\test.txt";
        String fileToPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\test1.txt";

        try {
            Solution.transferFileContent(fileFromPath, fileToPath);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
