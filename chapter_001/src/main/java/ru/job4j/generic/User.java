package ru.job4j.generic;

public class User extends Base {
    private String name;

    protected User(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "User: " + "id = " + getId() + ", name = " + getName();
    }
}
