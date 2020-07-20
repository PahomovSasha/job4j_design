package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        if (linked.getSize() == 0) {
            throw new NoSuchElementException();
        }
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }
}
