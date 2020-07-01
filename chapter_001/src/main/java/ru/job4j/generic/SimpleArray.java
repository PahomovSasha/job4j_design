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
        size--;
        System.arraycopy(this.arrays, index + 1, this.arrays, index, size - index);
        arrays[size] = null;
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

    public static void main(String[] args) {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.remove(1);
        System.out.println(simpleArray);
    }
}
