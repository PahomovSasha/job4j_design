package ru.job4j.list;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        T element = in.pop();
        for (int i = 0; i < size - 1; i++) {
            out.push(element);
            element = in.pop();
        }
        size--;
        return element;
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
