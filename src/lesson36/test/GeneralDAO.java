package lesson36.test;

import lesson36.exception.UnexpectedException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public abstract class GeneralDAO<T extends GeneralModel>{
    private String path;

    public GeneralDAO(String path) {
        this.path = path;
    }

    abstract T parseStringToObject(String input);

    abstract String parseObjectToString(T t);

    Set<T> readFromFile() throws UnexpectedException{
        Set<T> result = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                result.add(parseStringToObject(line));
            }
        } catch (FileNotFoundException e){
            throw new UnexpectedException("Reading from file error: file "+path+" does not exist");
        } catch (IOException e){
            throw new UnexpectedException("Reading from file "+path+" failed");
        }
        return result;
    }
}
