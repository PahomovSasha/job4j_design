package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> simpleArray = new SimpleArray<>();
    private int size = 0;

    public void add(E e) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(simpleArray.get(i), e)) {
                return;
            }
        }
        simpleArray.add(e);
        size++;
    }

    @Override
    public Iterator<E> iterator() {
        return simpleArray.iterator();
    }
}
