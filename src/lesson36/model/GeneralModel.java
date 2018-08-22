package lesson36.model;

import lesson36.exception.UnexpectedException;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class GeneralModel<T> {
    private final Class<T> tClass;

    public GeneralModel(Class<T> tClass) {
        this.tClass = tClass;
    }

    public void parseStringToObject(String input) throws UnexpectedException {
        String[] inputData = input.split(",");
        ArrayList<?> listOfParameters = new ArrayList<>();

        int index = 0;
        for(Field f : tClass.getDeclaredFields()){
            if(f.getType() == long.class)
                System.out.println(Long.valueOf(inputData[index]));
            else
                System.out.println();
        }

            Class t = tClass;


    }

    String parseObjectToString(T t) throws UnexpectedException{

        return null;
    }

}
