package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class SimpleArray<T> implements Iterable<T> {
    private Object[] arrays;
    private int size = 0;

    public SimpleArray(int size) {
        this.arrays = new Object[size];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int sizeIterator = 0;

            @Override
            public boolean hasNext() {
                return sizeIterator < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) arrays[sizeIterator++];
            }
        };
    }

    /**
     * Метод добавляет указанный элемент (model) в свободную ячейку
     *
     * @param model - элемент массива
     */
    public void add(T model) {
        arrays[size] = model;
        size++;
    }

    @Override
    public String toString() {
        return Arrays.toString(arrays);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleArray<?> that = (SimpleArray<?>) o;
        return size == that.size
                && Arrays.equals(arrays, that.arrays);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arrays);
        return result;
    }

    /**
     * Метод заменяет указанным элементом (model) элемент, находящийся по индексу (index)
     *
     * @param index - индекс ячейки массива
     * @param model - элемент массива
     */
    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        arrays[index] = model;
    }

    /**
     * Метод удаляет элемент по указанному индексу, все находящиеся справа элементы при этом сдвигаются на единицу влево
     *
     * @param index - индекс ячейки массива
     */
    public void remove(int index) {
        Objects.checkIndex(index, size);
        int nextIndex = index + 1;
        for (int i = index; i < size - 1; i++) {
            this.arrays[i] = this.arrays[nextIndex];
            nextIndex++;
        }
        size--;
        this.arrays = Arrays.copyOf(this.arrays, size);
    }

    /**
     * Метод возвращает элемент, расположенный по указанному индексу (index)
     *
     * @param index - индекс ячейки массива
     * @return - элемент массива
     */
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) arrays[index];
    }

}
