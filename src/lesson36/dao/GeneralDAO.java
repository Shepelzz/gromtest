package lesson36.dao;

import lesson36.exception.DAOException;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class GeneralDAO<T>{

    Set<String[]> readFromFile(String path) throws DAOException{
        Set<String[]> result = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null)
                result.add(splitLine(line));
        } catch (FileNotFoundException e){
            throw new DAOException("Reading from file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new DAOException("Reading from file "+path+" failed");
        }
        return result;
    }

    T writeToFile(T object, String path) throws DAOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            if(br.readLine() != null)
                bw.append("\r\n");
            bw.append(String.valueOf(generateRandomId())).append(",").append(object.toString());
        } catch (FileNotFoundException e) {
            throw new DAOException("Writing to file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new DAOException("Writing to file error: can`t save "+object.toString()+" to file "+path);
        }
        return object;
    }

    void deleteFromFileById(long id, String path) throws DAOException{
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
            throw new DAOException("Deleting from file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new DAOException("Deleting from file error: can`t delete from file "+path);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), false))){
            bw.append(tempData);
        } catch (IOException e){
            throw new DAOException("Deleting from file "+path+" failed");
        }
    }

    void replaceDataById(long oldObjectId, T newObject, String path) throws DAOException{
        deleteFromFileById(oldObjectId, path);

        try(BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            if(br.readLine() != null)
                bw.append("\r\n");
            bw.append(newObject.toString());
        } catch (FileNotFoundException e) {
            throw new DAOException("Writing to file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new DAOException("Writing to file error: can`t save "+newObject.toString()+" to file "+path);
        }

    }

    String[] getObjectByParameters(Map<String, String> parametersMap, Class c, String path) throws DAOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                boolean mapped = false;
                String[] dataLine = line.split(",");

                for(String field : parametersMap.keySet()) {
                    int index = getClassFieldIndex(c, field);
                    mapped = parametersMap.get(field).equals(dataLine[index]);
                }

                if(mapped)
                    return dataLine;
            }
            return null;
        } catch (FileNotFoundException e){
            throw new DAOException("Reading from file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new DAOException("Reading from file "+path+" failed");
        }
    }

    Set<String[]> getObjectsByParameters(Map<String, String> parametersMap, Class c, String path) throws DAOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            Set<String[]> result = new HashSet<>();
            String line;
            while ((line = br.readLine()) != null) {
                boolean mapped = false;
                String[] dataLine = line.split(",");

                for(String field : parametersMap.keySet()) {
                    int index = getClassFieldIndex(c, field);
                    mapped = parametersMap.get(field).equals(dataLine[index]);
                }

                if(mapped)
                    result.add(dataLine);
            }
            return result;
        } catch (FileNotFoundException e){
            throw new DAOException("Reading from file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new DAOException("Reading from file "+path+" failed");
        }
    }

    private int getClassFieldIndex(Class c, String fieldName) throws DAOException{
        int index = 0;
        for(Field f : c.getDeclaredFields()){
            if(f.getName().equals(fieldName))
                return index;
            index++;
        }
        throw new DAOException("no field with name "+fieldName+" was found in class "+c.getName());
    }

    private long generateRandomId(){
        return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }

    private String[] splitLine(String line){
        return line.split(",");
    }
}
