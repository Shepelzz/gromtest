package lesson34.homework34_2;

public class Demo {
    public static void main(String[] args){
        //work
        //String fileFromPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\files\\fileFrom.txt";
        //String fileToPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\files\\fileTo.txt";

        //home
        String fileFromPath = "C:\\Users\\Asus_1\\IdeaProjects\\files\\fileFrom.txt";
        String fileToPath = "C:\\Users\\Asus_1\\IdeaProjects\\files\\fileTo.txt";

        try {
            Solution.transferSentences(fileFromPath, fileToPath, "the");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
