package lesson34.homework34_3;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

public class Solution {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        validate(fileFrom, fileTo);
        Files.copy(fileFrom.toPath(), fileTo.toPath());
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws IOException {
        FileUtils.copyFile(new File(fileFromPath), new File(fileToPath));
    }


    private static void validate(File fileFrom, File fileTo) throws Exception{
        if(!fileFrom.exists())
            throw new FileNotFoundException("File "+ fileFrom +" does not exist");

        if(!fileFrom.canRead())
            throw new Exception("File "+ fileFrom +" does not have permission to be read");

        if(fileTo.exists())
            fileTo.delete();
    }
}
