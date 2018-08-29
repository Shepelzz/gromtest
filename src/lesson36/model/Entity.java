package lesson36.model;

import lesson36.exception.UnexpectedException;

public abstract class Entity{
    private long id;

    public Entity() {
        this.id = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public abstract Entity parseStringToObject(String input) throws UnexpectedException;

}
