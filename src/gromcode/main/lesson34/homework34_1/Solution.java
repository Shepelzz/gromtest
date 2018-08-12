package gromcode.main.lesson34.homework34_1;

import java.io.*;

public class Solution {
    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception{
        //проверить что файлы есть / проверить права from на чтение и запись и to на запись
        //считать контент файла from / записать контент в файл to
        //удалить контент с файла from

        validate(fileFromPath, fileToPath);

        writeToFile(fileToPath, readFromFile(fileFromPath));
        clearFromFile(fileFromPath);
    }

    private static StringBuffer readFromFile(String path){
        StringBuffer res = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }
            res.replace(res.length()-1, res.length(), "");
        } catch (FileNotFoundException e){
            System.err.println("File "+path+" does not exist");
        } catch (IOException e){
            System.err.println("Reading from file "+path+" failed");
        }
        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite){
        try(BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true))){
            if(br.readLine() != null)
                bufferedWriter.append("\r\n");
            bufferedWriter.append(contentToWrite);
        } catch (IOException e){
            System.err.println("Can`t write to file "+path);
        }
    }

    private static void clearFromFile(String path){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), false))){
            bufferedWriter.append("");
        } catch (IOException e){
            System.err.println("Can`t clear file "+path);
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if(!fileFrom.exists())
            throw new FileNotFoundException("File "+ fileFrom +" does not exist");
        if(!fileTo.exists())
            throw new FileNotFoundException("File "+ fileTo +" does not exist");

        if(!fileFrom.canRead())
            throw new Exception("File "+ fileFrom +" does not have permission to be read");
        if(!fileTo.canWrite())
            throw new Exception("File "+ fileFrom +" does not have permission to be written");

        if(!fileFrom.canWrite())
            throw new Exception("File "+ fileFrom +" does not have permission to be written");
    }
}
