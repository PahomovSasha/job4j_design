package ru.job4j.io;

import java.util.*;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String rst = values.get(key);
        if (rst == null) {
            throw new IllegalArgumentException("Ключ не найден");
        }
        return values.get(key);
    }

    /**
     * Метод распарсивает массив строк, на мапу
     *
     * @param args массив строк
     */
    private void parse(String[] args) {
        for (String arg : args) {
            values.put(arg.substring(1, arg.indexOf("=")), arg.substring(arg.indexOf("=") + 1));
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

}
