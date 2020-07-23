package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();
    private int size = 0;

    public T pop() {
        if (linked.getSize() == 0) {
            throw new NoSuchElementException();
        }
        size--;
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
        size++;
    }

    public int getSize() {
        return size;
    }
}
