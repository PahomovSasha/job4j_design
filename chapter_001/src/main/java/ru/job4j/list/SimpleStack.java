package ru.job4j.list;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T element = linked.get(linked.getSize() - 1);
        linked.deleteLast();
        return element;
    }

    public void push(T value) {
        linked.add(value);
    }
}
