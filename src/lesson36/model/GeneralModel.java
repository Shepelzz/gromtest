package lesson36.model;

public abstract class GeneralModel<T> {

    public GeneralModel() {
    }

    public abstract T parseStringToObject(String input);

    public abstract String parseObjectToString(T t);

}
