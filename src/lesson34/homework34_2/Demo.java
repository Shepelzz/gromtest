package lesson34.homework34_2;

public class Demo {
    public static void main(String[] args){
        String fileFromPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\files\\fileFrom.txt";
        String fileToPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\files\\fileTo.txt";

        try {
            Solution.transferSentences(fileFromPath, fileToPath, "odin");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
