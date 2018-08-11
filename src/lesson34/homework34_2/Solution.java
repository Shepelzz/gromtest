package lesson34.homework34_2;

import java.io.*;

public class Solution {
    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception{
        //проверить что файлы есть / проверить права from на чтение и запись и to на запись
        //считать контент с файла from
        //перенести строки
        //перезаписать оба файла

        validate(fileFromPath, fileToPath);

        StringBuffer fileFromText = new StringBuffer();
        StringBuffer fileToText = new StringBuffer();
        String currentLine = "";

        for(String sentence : readFromFile(fileFromPath).toString().split("\\.")){
            currentLine = currentLine.concat(sentence+".");
            if(currentLine.length() > 10) {
                if(currentLine.contains(word)) {
                    fileToText.append(currentLine.trim());
                    fileToText.append("\r\n");
                }
                else {
                    fileFromText.append(currentLine.trim());
                    fileFromText.append("\r\n");
                }
                currentLine = "";
            }
        }

        writeToFile(fileFromPath, fileFromText.replace(fileFromText.length()-1, fileFromText.length(), ""), false);
        writeToFile(fileToPath, fileToText.replace(fileToText.length()-1, fileToText.length(), ""), false);
    }

    private static StringBuffer readFromFile(String path){
        StringBuffer res = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (FileNotFoundException e){
            System.err.println("File "+path+" does not exist");
        } catch (IOException e){
            System.err.println("Reading from file "+path+" failed");
        }
        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite, boolean append){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), append))){
            bufferedWriter.append(contentToWrite);
        } catch (IOException e){
            System.err.println("Can`t write to file "+path);
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if(!fileFrom.exists())
            throw new FileNotFoundException("File "+ fileFrom +" does not exist");
        if(!fileTo.exists())
            fileTo.createNewFile();
            //throw new FileNotFoundException("File "+ fileTo +" does not exist");

        if(!fileFrom.canRead())
            throw new Exception("File "+ fileFrom +" does not have permission to be read");
        if(!fileTo.canWrite())
            throw new Exception("File "+ fileFrom +" does not have permission to be written");

        if(!fileFrom.canWrite())
            throw new Exception("File "+ fileFrom +" does not have permission to be written");
    }
}
