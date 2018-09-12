package lesson36.model;

import lesson36.exception.InternalServerError;

public abstract class Entity{
    private long id;

    public Entity() {
        this.id = 0;
    }

    public long getId() {
        return id;
    }

    public Entity setId(long id) {
        this.id = id;
        return this;
    }

    public abstract Entity parseStringToObject(String input) throws InternalServerError;

}