package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LinkedTest {
    @Test
    public void whenAddThenGet() {
        Linked<String> linked = new Linked<>();
        linked.add("Ваня");
        linked.add("Саша");
        linked.add("Катя");
        String rsl = linked.get(2);
        assertThat(rsl, is("Катя"));
    }

    @Test
    public void whenAddThenIt() {
        Linked<String> linked = new Linked<>();
        linked.add("Ваня");
        String rsl = linked.iterator().next();
        assertThat(rsl, is("Ваня"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        Linked<String> linked = new Linked<>();
        linked.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        Linked<String> linked = new Linked<>();
        linked.add("Ваня");
        linked.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        Linked<String> linked = new Linked<>();
        linked.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        Linked<String> linked = new Linked<>();
        linked.add("Ваня");
        Iterator<String> it = linked.iterator();
        linked.add("Саша");
        it.next();
    }
}
