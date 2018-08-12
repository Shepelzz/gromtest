package gromcode.main.lesson33.homework33_2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {

    public static void readFileByConsolePath(){
        readFile(readPathFromConsole());
    }

    private static String readPathFromConsole(){
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please, enter file path to read:");
        try {
            return br.readLine();
        } catch (IOException e){
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
        return null;
    }

    private static void readFile(String path){

        FileReader reader = null;
        BufferedReader br = null;

        try {
            reader = new FileReader(path);
            br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            System.err.println("File with path " + path + " not found");
            return;
        } catch (IOException e){
            System.err.println("Can`t read file by path "+path);
        }  finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
}
