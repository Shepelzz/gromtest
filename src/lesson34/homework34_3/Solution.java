package lesson34.homework34_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

public class Solution {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception{
        validate(fileFromPath, fileToPath);

        Files.copy(new File(fileFromPath).toPath(), new File(fileToPath).toPath());
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath){

    }


    private static void validate(String fileFromPath, String fileToPath) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if(!fileFrom.exists())
            throw new FileNotFoundException("File "+ fileFrom +" does not exist");

        if(!fileFrom.canRead())
            throw new Exception("File "+ fileFrom +" does not have permission to be read");

        if(fileTo.exists())
            throw new FileAlreadyExistsException("File "+fileTo+" already exist");
    }
}
