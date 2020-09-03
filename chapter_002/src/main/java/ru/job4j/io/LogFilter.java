package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    /**
     * Метод считывает переданный файл и возвращает строки содержащие 404 ошибку
     *
     * @param file - имя файла
     * @return строки содержащие 404 ошибку
     */
    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines.stream().filter(s -> s.contains("\" 404 ")).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for (String s : log) {
            System.out.println(s);
        }
    }
}
