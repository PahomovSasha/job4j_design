package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && name.equals(user.name)
                && birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", children=" + children + ", birthday=" + birthday + '}';
    }

    public static void main(String[] args) {
        Map<User, Object> userObjectMap = new HashMap<>();
        User user1 = new User("Саша", 6, new GregorianCalendar(2000, 1, 2));
        User user2 = new User("Саша", 6, new GregorianCalendar(2000, 1, 2));
        userObjectMap.put(user1, "Первый");
        userObjectMap.put(user2, "Второй");
        for (Map.Entry<User, Object> userObjectEntry : userObjectMap.entrySet()) {
            System.out.println(userObjectEntry);
        }
    }
}
