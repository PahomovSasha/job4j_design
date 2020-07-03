package ru.job4j.generic;

public class Role extends Base {
    private String role;

    protected Role(String id, String role) {
        super(id);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Role: " + "id = " + getId() + ", name = " + getRole();
    }
}
