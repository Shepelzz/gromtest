package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Entity;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class GeneralDAO<T extends Entity>{
    private String path;
    private FileReader fileReader;

    public GeneralDAO(String path) throws UnexpectedException {
        this.path = path;
        try {
            fileReader = new FileReader(path);
        }catch (FileNotFoundException e){
            throw new UnexpectedException("Reading from file error: file "+path+" does not exist");
        }
    }

    public abstract T parseStringToObject(String input) throws UnexpectedException;

    public T getEntityById(long id) throws UnexpectedException{
        for(T t : getAll())
            if(t.getId() == id)
                return t;
        return null;
    }

    public Set<T> getAll() throws UnexpectedException{
        Set<T> result = new HashSet<>();
        try(BufferedReader br = new BufferedReader(fileReader)){
            String line;
            while ((line = br.readLine()) != null)
                result.add(parseStringToObject(line));
        } catch (IOException e){
            throw new UnexpectedException("Reading from file "+path+" failed");
        }
        return result;
    }

    public T writeToFile(T t) throws UnexpectedException{
        t.setId(generateRandomId());
        try(BufferedReader br = new BufferedReader(fileReader); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            if(br.readLine() != null)
                bw.append("\r\n");
            bw.append(t.toString());
        } catch (IOException e){
            throw new UnexpectedException("Writing to file error: can`t save "+t.toString()+" to file "+path);
        }
        return t;
    }

    public void deleteFromFileById(long id) throws UnexpectedException{
        StringBuffer tempData = new StringBuffer();
        try(BufferedReader br = new BufferedReader(fileReader)){
            String line;
            while((line = br.readLine()) != null) {
                if (!Long.valueOf(line.split(",")[0]).equals(id)) {
                    tempData.append(line);
                    tempData.append("\r\n");
                }
            }
            if(tempData.length()>=2)
                tempData.replace(tempData.length() - 2, tempData.length(), "");
        } catch (IOException e){
            throw new UnexpectedException("Deleting from file error: can`t delete from file "+path);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), false))){
            bw.append(tempData);
        } catch (IOException e){
            throw new UnexpectedException("Deleting from file "+path+" failed");
        }
    }

    public void updateEntity(T newObject) throws UnexpectedException{
        deleteFromFileById(newObject.getId());
        writeToFile(newObject);
    }

    private long generateRandomId(){
        return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }
}
