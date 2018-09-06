package lesson36.dao;

import lesson36.exception.InternalServerError;
import lesson36.model.Entity;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class GeneralDAO<T extends Entity>{
    private String path;

    public GeneralDAO(String path){
        this.path = path;
    }

    public abstract T parseStringToObject(String input) throws InternalServerError;

    public T getEntityById(long id) throws InternalServerError {
        for(T t : getAll())
            if(t.getId() == id)
                return t;
        return null;
    }

    public Set<T> getAll() throws InternalServerError {
        Set<T> result = new HashSet<>();
        try(BufferedReader br = new BufferedReader(getFileReader())){
            String line;
            while ((line = br.readLine()) != null)
                result.add(parseStringToObject(line));
        } catch (IOException e){
            throw new InternalServerError("Reading from file "+path+" failed");
        }
        return result;
    }

    public T writeToFile(T t) throws InternalServerError {
        t.setId(ThreadLocalRandom.current().nextLong(Long.MAX_VALUE));
        try(BufferedReader br = new BufferedReader(getFileReader()); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            if(br.readLine() != null)
                bw.append("\r\n");
            bw.append(t.toString());
        } catch (IOException e){
            throw new InternalServerError("Writing to file error: can`t save "+t.toString()+" to file "+path+" "+e.getMessage());
        }
        return t;
    }

    public void deleteFromFileById(long id) throws InternalServerError {
        StringBuffer tempData = new StringBuffer();
        try(BufferedReader br = new BufferedReader(getFileReader())){
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
            throw new InternalServerError("Deleting from file error: can`t delete from file "+path);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), false))){
            bw.append(tempData);
        } catch (IOException e){
            throw new InternalServerError("Deleting from file "+path+" failed");
        }
    }

    public void updateEntity(T newObject) throws InternalServerError {
        deleteFromFileById(newObject.getId());
        try(BufferedReader br = new BufferedReader(getFileReader()); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            if(br.readLine() != null)
                bw.append("\r\n");
            bw.append(newObject.toString());
        } catch (IOException e){
            throw new InternalServerError("Writing to file error: can`t save "+newObject.toString()+" to file "+path);
        }
    }

//    private long generateRandomId(){ return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);}

    private FileReader getFileReader() throws InternalServerError {
        try {
            return new FileReader(path);
        }catch (FileNotFoundException e){
            throw new InternalServerError("Reading from file error: file "+path+" does not exist");
        }
    }
}
