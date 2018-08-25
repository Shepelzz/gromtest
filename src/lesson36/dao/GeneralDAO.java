package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.GeneralModel;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class GeneralDAO<T extends GeneralModel>{
    private String path;
    private Class tClass;

    public GeneralDAO(Class<T> tClass, String path) {
        this.path = path;
        this.tClass = tClass;
    }

    public abstract T parseStringToObject(String input);

    public abstract String parseObjectToString(T t);

    Set<T> readFromFile() throws UnexpectedException{
        Set<T> result = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null)
                result.add(parseStringToObject(line));
        } catch (FileNotFoundException e){
            throw new UnexpectedException("Reading from file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new UnexpectedException("Reading from file "+path+" failed");
        }
        return result;
    }

    T writeToFile(T t) throws UnexpectedException{
        t.setId(generateRandomId());
        try(BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            if(br.readLine() != null)
                bw.append("\r\n");
            bw.append(parseObjectToString(t));
        } catch (FileNotFoundException e) {
            throw new UnexpectedException("Writing to file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new UnexpectedException("Writing to file error: can`t save "+t.toString()+" to file "+path);
        }
        return t;
    }

    void deleteFromFileById(long id) throws UnexpectedException{
        StringBuffer tempData = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null) {
                if (!Long.valueOf(line.split(",")[0]).equals(id)) {
                    tempData.append(line);
                    tempData.append("\r\n");
                }
            }
            if(tempData.length()>=2)
                tempData.replace(tempData.length() - 2, tempData.length(), "");
        } catch (FileNotFoundException e) {
            throw new UnexpectedException("Deleting from file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new UnexpectedException("Deleting from file error: can`t delete from file "+path);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), false))){
            bw.append(tempData);
        } catch (IOException e){
            throw new UnexpectedException("Deleting from file "+path+" failed");
        }
    }

    void replaceDataById(long oldObjectId, T newObject) throws UnexpectedException{
        deleteFromFileById(oldObjectId);
        writeToFile(newObject);
//        try(BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
//            if(br.readLine() != null)
//                bw.append("\r\n");
//            bw.append(parseObjectToString(newObject));
//        } catch (FileNotFoundException e) {
//            throw new UnexpectedException("Writing to file error: file "+path+" does not exist");
//        } catch (IOException e){
//            throw new UnexpectedException("Writing to file error: can`t save "+newObject.toString()+" to file "+path);
//        }
    }

    T getObjectByParameters(Map<String, String> parametersMap) throws UnexpectedException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                boolean mapped = false;
                String[] dataLine = line.split(",");

                for(String field : parametersMap.keySet()) {
                    int index = getClassFieldIndex(field);
                    mapped = parametersMap.get(field).equals(dataLine[index]);
                }

                if(mapped)
                    return parseStringToObject(line);
            }
            return null;
        } catch (FileNotFoundException e){
            throw new UnexpectedException("Reading from file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new UnexpectedException("Reading from file "+path+" failed");
        }
    }

    Set<T> getObjectsByParameters(Map<String, String> parametersMap) throws UnexpectedException{ //TODO
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            Set<T> result = new HashSet<>();
            String line;
            while ((line = br.readLine()) != null) {
                boolean mapped = false;
                String[] dataLine = line.split(",");

                for(String field : parametersMap.keySet()) {
                    int index = getClassFieldIndex(field);
                    mapped = parametersMap.get(field).equals(dataLine[index]);
                }

                if(mapped)
                    result.add(parseStringToObject(line));
            }
            return result;
        } catch (FileNotFoundException e){
            throw new UnexpectedException("Reading from file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new UnexpectedException("Reading from file "+path+" failed");
        }
    }

    private int getClassFieldIndex(String fieldName) throws UnexpectedException{
        int index = 0;
        for(Field f : tClass.getDeclaredFields()){
            if(f.getName().equals(fieldName))
                return index;
            index++;
        }
        throw new UnexpectedException("no field with name "+fieldName+" was found in class "+tClass.getName());
    }


    private long generateRandomId(){
        return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }
}
