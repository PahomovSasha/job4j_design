package ru.job4j.set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSetTest {

    @Test
    public void whenAddThenIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        int rsl = simpleSet.iterator().next();
        assertThat(rsl, is(1));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenAddDuplicateThenIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(1);
        Iterator<Integer> it = simpleSet.iterator();
        it.next();
        it.next();
    }

    @Test
    public void whenSomeAddThenIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        Iterator<Integer> it = simpleSet.iterator();
        it.next();
        it.next();
        assertThat(it.next(), is(3));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenMoreAddThenIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        Iterator<Integer> it = simpleSet.iterator();
        it.next();
        it.next();
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        Iterator<Integer> it = simpleSet.iterator();
        simpleSet.add(2);
        it.next();
    }

    @Test
    public void whenAddNullElementThenIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(null);
        simpleSet.add(3);
        int rsl = simpleSet.iterator().next();
        assertThat(rsl, is(1));
    }
}
