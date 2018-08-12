package gromcode.main.lesson33.homework33_1;

import java.io.*;

public class Solution {

    public static void writeToFileFromConsole(String path) throws FileNotFoundException{

        validate(path);
        System.out.println("Enter file content to write the file:");

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while((line = br.readLine()) != null) {
                if(line.equals("wr"))
                    return;
                write(path, line);
            }
        } catch(IOException e){
            System.err.println("Reading from keyboard failed");
        }
    }

    private static void write(String path, String text){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            bw.append(text);
            bw.append("\r\n");
        } catch (IOException e){
            System.err.println("Can`t write to file with path "+path);
        }
    }

    private static void validate(String path) throws FileNotFoundException{
        if(!new File(path).exists())
            throw new FileNotFoundException("File with path " + path + " not found");
    }





 /*
    private static StringBuffer readFromConsole(){
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer resultText = new StringBuffer();
        try {
            while(true){
                String line = br.readLine();
                if(line.equals("wr"))
                    return resultText;
                resultText.append(line);
                resultText.append("\r\n");
            }
        } catch (IOException e){
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
        return resultText;
    }

    private static void writeToFile(String path, StringBuffer text){
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

            bufferedWriter.append(text);
            bufferedWriter.append("\r\n");

        } catch (IOException e){
            System.err.println("Can`t write to file with path "+path);
            return;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }
    */
}
