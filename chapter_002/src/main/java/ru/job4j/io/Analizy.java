package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    /**
     * Метод сохраняет в файл диапазоны времени недоступности сервера
     * @param source исходный файл
     * @param target выходной файл
     */
    public void unavailable(String source, String target) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String serverDownTime = null;
            while (in.ready()) {
                String line = in.readLine();
                if ((line.contains("500 ") || line.contains("400 ")) && serverDownTime == null) {
                    serverDownTime = line.substring(4);
                } else if ((line.contains("200 ") || line.contains("300 ")) && serverDownTime != null) {
                    result.add(serverDownTime + " - " + line.substring(4) + ";");
                    serverDownTime = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveToFile(result, target);
    }

    private static void saveToFile(List<String> log, String target) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String s : log) {
                out.write(s + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}