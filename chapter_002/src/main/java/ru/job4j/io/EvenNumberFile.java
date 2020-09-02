package ru.job4j.io;


import java.io.FileInputStream;


public class EvenNumberFile {
    public static void main(String[] args) {
        String[] subStr;
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            subStr = text.toString().split("[\r\n]");
            for (String s : subStr) {
                if (!s.equals("")) {
                    checkEven(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет чётное ли число
     * @param line строковое число
     */
    private static void checkEven(String line) {
        int number = Integer.parseInt(line);
        if (number % 2 == 0) {
            System.out.println("Число " + number + " - чётное");
        } else {
            System.out.println("Число " + number + " - нечётное");
        }
    }
}
