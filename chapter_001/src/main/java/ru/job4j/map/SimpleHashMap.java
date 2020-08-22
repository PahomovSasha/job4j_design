package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private int capacity = 16;
    private int size = 0;
    private Entry<K, V>[] table = new Entry[capacity];

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            int sizeIterator = 0;

            @Override
            public boolean hasNext() {
                while (sizeIterator != table.length && table[sizeIterator] == null) {
                    sizeIterator++;
                }
                return sizeIterator < table.length;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[sizeIterator++].getVal();
            }
        };
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Метод получения значения элемена по его ключу
     * @param key - ключ элемента
     * @return значение элемента
     */
    public V get(K key) {
        int hash = hashing(key);
        Entry<K, V> bucket = table[hash];
        if (bucket  != null && bucket .getKey().equals(key)) {
            return bucket.getVal();
        }
        return null;
    }

    /**
     * Метод вставки элемента в мапу
     * @param key - ключ элемента
     * @param value - значение элемента
     * @return если в ячейки мапы уже есть элемент то false, иначе true
     */
    public boolean insert(K key, V value) {
        boolean result = true;
        extendSizeArray();
        int hash = hashing(key);
        if (table[hash] != null) {
            result = false;
        } else {
            Entry<K, V> entryInNewBucket = new Entry(key, value);
            table[hash] = entryInNewBucket;
            size++;
        }
        return result;
    }

    /**
     * Метод расширения размеры мапы в 2 раза
     */
    private void extendSizeArray() {
        if (size == table.length) {
            capacity = table.length * 2;
            table = Arrays.copyOf(table, capacity);
        }
    }


    /**
     * Метод вышислет хеш код ключа
     * @param key - ключ элемента
     * @return - хэш ключа
     */
    private int hashing(K key) {
        return key.hashCode() % capacity;
    }

    /**
     * Метод удаления элемента из мапы
     * @param key - ключ элемента
     * @return - если элемент удалился то true, иначе false
     */
    public boolean delete(K key) {
        boolean result = false;
        int hash = hashing(key);
        Entry<K, V> e = table[hash];
        if (e != null && e.getKey().equals(key)) {
            table[hash] = null;
            result = true;
            size--;
        }
        return result;
    }
}
