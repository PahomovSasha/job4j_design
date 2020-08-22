package ru.job4j.map;

import java.util.Objects;

public class Entry<K, V> {
    private final K key;
    private V val;

    public Entry(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey() {
        return key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return Objects.equals(key, entry.key)
                && Objects.equals(val, entry.val);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + key.hashCode();
        return result;
    }
}
