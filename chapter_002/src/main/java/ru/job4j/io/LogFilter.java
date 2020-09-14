package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            in.lines().filter(s -> s.contains("\" 404 ")).forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  lines;
    }

    /**
     * Метод сохраняет лог в файл
     * @param log - лог содержащий строки с 404 ошибками
     * @param file - название файла
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String s : log) {
                out.write(s + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
