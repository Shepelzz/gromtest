package lesson36.dao;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class GeneralDAO<T>{
    private String path;

    public GeneralDAO(String path) {
        this.path = path;
    }

    Set<String> readFromFile(){
        Set<String> result = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                if(line.length() != 0)
                    result.add(line);
            }
        } catch (FileNotFoundException e){
            System.err.println("Reading from file error: file " + path + " does not exist");
        } catch (IOException e){
            System.err.println("Reading from file "+path+" failed");
        }
        return result;
    }

    T writeToFile(T t){
        try(BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            if(br.readLine() != null)
                bw.append("\r\n");
            bw.append(t.toString());
        } catch (FileNotFoundException e) {
            System.err.println(t.getClass().getName()+" saving error: file " + path + " does not exist");
        } catch (IOException e){
            System.err.println(t.getClass().getName()+" saving error: can`t save "+t.toString()+" to file "+path);
        }
        return t;
    }

    void deleteFromFile(T t){
        StringBuffer tempData = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null){
                if(!line.equals(t.toString())){
                    tempData.append(line);
                    tempData.append("\r\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Reading from file error: file " + path + " does not exist");
        } catch (IOException e){
            System.err.println("Reading from file error: can`t save to file "+path); /*TODO*/
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), false))){
            bw.append(tempData);
        } catch (IOException e){
            System.err.println("Can`t write to file "+path);
        }
    }

    long randomId(){
        return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }

}
