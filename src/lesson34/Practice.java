package lesson34;

import java.io.*;

public class Practice {
    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception{
        //проверить что файлы есть +
        //проверить права +
        //считать контент файла from
        //записать контент в файл to

        validate(fileFromPath, fileToPath);
        writeFileToFile(fileToPath, readFileFromFile(fileFromPath));
    }

    private static StringBuffer readFileFromFile(String path){
        StringBuffer res = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }
            res.replace(res.length()-1, res.length(), "");
        } catch (FileNotFoundException e){
            System.err.println("File does not exist");
        } catch (IOException e){
            System.err.println("Reading from file "+path+" failed");
        }
        return res;
    }

    private static void writeFileToFile(String path, StringBuffer contentToWrite){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true))){
            bufferedWriter.append(contentToWrite);
        } catch (IOException e){
            System.err.println("Can`t write to file");
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
    }
}
