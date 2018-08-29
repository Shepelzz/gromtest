package lesson36.model;

import lesson36.exception.UnexpectedException;

public abstract class Entity <T>{

    public abstract long getId();
    public abstract void setId(long id);
    public abstract T parseStringToObject(String input) throws UnexpectedException;

}
