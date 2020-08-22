package ru.job4j.map;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    @Test
    public void whenAddThenGet() {
        SimpleHashMap<String, String> myHashMap = new SimpleHashMap<>();
        myHashMap.insert("Awa", "1");
        myHashMap.insert("Rahul", "2");
        String rsl = myHashMap.get("Rahul");
        assertThat(rsl, is("2"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleHashMap<String, String> myHashMap = new SimpleHashMap<>();
        myHashMap.insert("Awa", "1");
        String rsl = myHashMap.iterator().next();
        assertThat(rsl, is("1"));
    }

    @Test
    public void whenGetMissingElement() {
        SimpleHashMap<String, String> myHashMap = new SimpleHashMap<>();
        myHashMap.insert("Awa", "1");
        String rsl = myHashMap.get("Rahul");
        assertNull(rsl);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleHashMap<String, String> myHashMap = new SimpleHashMap<>();
        myHashMap.iterator().next();
    }

    @Test
    public void whenAddRepeatKey() {
        SimpleHashMap<String, String> myHashMap = new SimpleHashMap<>();
        myHashMap.insert("Awa", "1");
        myHashMap.insert("Awa", "2");
        assertThat(myHashMap.getSize(), is(1));
    }

    @Test
    public void whenAddExtendSizeArray() {
        SimpleHashMap<String, String> myHashMap = new SimpleHashMap<>();
        myHashMap.setCapacity(2);
        myHashMap.insert("Awa", "1");
        myHashMap.insert("Саша", "2");
        myHashMap.insert("Маша", "3");
        String rsl = myHashMap.get("Маша");
        assertThat(rsl, is("3"));
    }

    @Test
    public void whenAddThenDelete() {
        SimpleHashMap<String, String> myHashMap = new SimpleHashMap<>();
        myHashMap.insert("Awa", "1");
        myHashMap.delete("Awa");
        assertNull(myHashMap.get("Awa"));
    }

    @Test
    public void whenAddThenDeleteWrongKey() {
        SimpleHashMap<String, String> myHashMap = new SimpleHashMap<>();
        myHashMap.insert("Awa", "1");
        boolean rst = myHashMap.delete("Саша");
        assertFalse(rst);
    }
}
