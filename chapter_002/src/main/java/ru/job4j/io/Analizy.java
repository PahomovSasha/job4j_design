package ru.job4j.io;

import java.io.*;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String serverDownTime = null;
            while (in.ready()) {
                String line = in.readLine();
                if ((line.contains("500 ") || line.contains("400 ")) && serverDownTime == null) {
                    serverDownTime = line.substring(4);
                } else if ((line.contains("200 ") || line.contains("300 ")) && serverDownTime != null) {
                    out.write(serverDownTime + " - " + line.substring(4) + ";");
                    serverDownTime = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}