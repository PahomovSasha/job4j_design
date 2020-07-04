package ru.job4j.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container = new Object[5];
    private int modCount = 0;
    private int count = 0;

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) container[index];
    }

    public void add(T model) {
        if (count == container.length) {
            container = (Object[]) extendSizeArray();
        }
        container[count++] = model;
        modCount++;
    }

    private T extendSizeArray() {
        Object[] containerClone = Arrays.copyOf(container, container.length * 2);
        return (T) containerClone;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator iterator = new Iterator() {
            int expectedModCount = modCount;
            int sizeIterator = 0;

            @Override
            public boolean hasNext() {
                return sizeIterator < count;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[sizeIterator++];
            }
        };
        return iterator;
    }
}
