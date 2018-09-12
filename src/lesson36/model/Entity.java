package lesson36.model;

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
}
