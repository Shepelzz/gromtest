package gromcode.main.lesson34.homework34_3;

import java.io.IOException;

public class Demo {
    public static void main(String[] args){
        //work
        //String fileFromPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\files\\1.txt";
        //String fileToPath = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\files\\2.txt";

        //home
        String fileFromPath = "C:\\Users\\Asus_1\\IdeaProjects\\files\\1.txt";
        String fileToPath = "C:\\Users\\Asus_1\\IdeaProjects\\files\\2.txt";

        try {
            Solution.copyFileContent(fileFromPath, fileToPath);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            Solution.copyFileContentApacheIO(fileFromPath, fileToPath);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
