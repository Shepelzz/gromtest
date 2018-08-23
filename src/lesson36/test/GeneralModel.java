package lesson36.test;

public abstract class GeneralModel<T> {

    GeneralModel() {}

    public abstract T parseStringToObject(String input);

    public abstract String parseObjectToString(T t);

}
