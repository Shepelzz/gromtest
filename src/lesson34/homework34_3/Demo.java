package lesson34.homework34_3;

public class Demo {
    public static void main(String[] args){
        String fileFromPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\files\\1.txt";
        String fileToPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\files\\2.txt";

        try {
            Solution.copyFileContent(fileFromPath, fileToPath);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
