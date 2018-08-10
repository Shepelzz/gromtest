package lesson34;

import java.io.*;

public class ReadWriteFile {
    public static void readFile(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            System.err.println("File does not exist");
        } catch (IOException e){
            System.err.println("Reading from file "+path+" failed");
        }
    }

    public static void writeFile(String path){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true))){
            bufferedWriter.append("\r\n");
            bufferedWriter.append("tttttt");
        } catch (IOException e){
            System.err.println("Can`t write to file");
        }
    }
}
