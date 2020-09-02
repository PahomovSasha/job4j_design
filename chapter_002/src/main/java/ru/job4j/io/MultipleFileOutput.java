package ru.job4j.io;


import java.io.FileOutputStream;

public class MultipleFileOutput {
    public static void main(String[] args) {
        String result = "1 * 2 = 2" + System.lineSeparator()
                + "1 * 3 = 3" + System.lineSeparator()
                + "1 * 4 = 4" + System.lineSeparator()
                + "1 * 5 = 5" + System.lineSeparator()
                + "1 * 6 = 6" + System.lineSeparator()
                + "1 * 7 = 7" + System.lineSeparator()
                + "1 * 8 = 8" + System.lineSeparator()
                + "1 * 9 = 9";
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(result.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
