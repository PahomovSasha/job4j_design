package ru.job4j.list;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        T elementIn = in.pop();
        for (int i = 0; i < size - 1; i++) {
            out.push(elementIn);
            elementIn = in.pop();
        }
        size--;
        for (int i = 0; i < size; i++) {
            T elementOut = out.pop();
            in.push(elementOut);
        }
        return elementIn;
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
