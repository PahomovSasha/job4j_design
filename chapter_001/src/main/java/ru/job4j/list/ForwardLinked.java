package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        size++;
        if (head == null) {
            head = node;
            return;
        }
        Node<T> nodeTail = head;
        while (nodeTail.next != null) {
            nodeTail = nodeTail.next;
        }
        nodeTail.next = node;
        tail = node;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
        size--;
    }

    public void deleteLast() {
        if (size == 1) {
            deleteFirst();
        } else {
            tail.value = null;
            size--;
        }
    }

    public int getSize() {
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> nodeTail = head;
        for (int i = 0; i < index; i++) {
            nodeTail = nodeTail.next;
        }
        return nodeTail.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return head != null && node.value != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                if (node.value == null) {
                    value = node.next.value;
                    node = node.next.next;
                } else {
                    node = node.next;
                }
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}