package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Linked<E> implements Iterable<E> {
    private Node head;
    private Node tail;
    private int count = 0;
    private int modCount = 0;

    @Override
    public Iterator<E> iterator() {
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
                return get(sizeIterator++);
            }
        };
        return iterator;
    }

    public void add(E value) {
        Node node = new Node();
        node.value = value;
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        count++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, count);
        Node node = this.head;
        int countGet = 0;
        while (node != null) {
            if (countGet == index) {
                break;
            } else {
                node = node.next;
                countGet++;
            }
        }
        return (E) node.value;
    }

}
