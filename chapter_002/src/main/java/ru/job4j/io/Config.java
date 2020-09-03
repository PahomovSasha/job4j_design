package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод считывает файл и записывает его в карту values
     */
    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                if (line.contains("=")) {
                    String[] keyValue = line.split("=");
                    values.put(keyValue[0], keyValue[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает значение по ключу из карты
     *
     * @param key - ключ
     * @return - значение
     */
    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("app.properties.txt");
        config.load();
    }
}
