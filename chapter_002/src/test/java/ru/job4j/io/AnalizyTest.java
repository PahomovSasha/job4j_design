package ru.job4j.io;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void when_200_500_400_200() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("unavailable.csv");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsoluteFile()))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01 - 10:59:01;"));
    }

    @Test
    public void when_300_500_400_300() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("unavailable.csv");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("300 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("300 10:59:01");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsoluteFile()))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01 - 10:59:01;"));
    }

    @Test
    public void whenTwoPeriodsUnavailable() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("unavailable.csv");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:05");
            out.println("300 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsoluteFile()))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01 - 10:59:01;11:01:05 - 11:02:02;"));
    }

    @Test
    public void whenAlwaysAvailableServer() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("unavailable.csv");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("200 10:59:01");
            out.println("300 11:01:02");
            out.println("200 11:02:02");
            out.println("300 11:03:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsoluteFile()))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is(""));
    }

    @Test
    public void whenAlwaysUnavailableServer() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("unavailable.csv");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("500 10:56:01");
            out.println("400 10:59:01");
            out.println("500 11:01:02");
            out.println("500 11:02:02");
            out.println("400 11:03:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsoluteFile()))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is(""));
    }
}
