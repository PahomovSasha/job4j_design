package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        mem.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        mem.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return index != -1 ? mem.get(index) : null;
    }

    /**
     * Метод возвращает index по id
     *
     * @return index
     */
    private int indexOf(String id) {
        int rst = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    /**
     * Метод возвращает ArrayList объекта
     *
     */
    public List<T> findAll() {
        return this.mem;
    }
}
