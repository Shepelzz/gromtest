package lesson33.homework33_1;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void writeToFileFromConsole(String path){
        System.out.println("Enter file content to write the file:");
        writeToFile(path, readFromConsole());
    }

    private static List<String> readFromConsole(){
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> resultText = new LinkedList();
        try {
            while(true){
                String line = br.readLine();
                if(line.equals("wr"))
                    return resultText;
                resultText.add(line);
            }
        } catch (IOException e){
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
        return resultText;
    }

    private static void writeToFile(String path, List<String> text){
        File file = new File(path);
        if(!file.exists()) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            writer = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(writer);

            for(String line : text){
                bufferedWriter.append(line);
                bufferedWriter.append("\r\n");
            }
        } catch (IOException e){
            System.err.println("Can`t write to file with path "+path);
            return;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }
}
