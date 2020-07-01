package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void addAndGetElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(5);
        assertThat(5, is(simpleArray.get(0)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAndGetUnavailableElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(5);
        assertThat(5, is(simpleArray.get(1)));
    }

    @Test
    public void setElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(5);
        simpleArray.add(6);
        simpleArray.set(1, 9);
        assertThat(9, is(simpleArray.get(1)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setUnavailableElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(5);
        simpleArray.add(6);
        simpleArray.set(2, 9);
        assertThat(9, is(simpleArray.get(2)));
    }

    @Test
    public void removeElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(5);
        simpleArray.add(6);
        simpleArray.add(7);
        simpleArray.remove(1);
        SimpleArray<Integer> expect = new SimpleArray<>(2);
        expect.add(5);
        expect.add(7);
        assertThat(expect, is(simpleArray));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeUnavailableElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(5);
        simpleArray.add(6);
        simpleArray.add(7);
        simpleArray.remove(3);
        SimpleArray<Integer> expect = new SimpleArray<>(3);
        expect.add(5);
        expect.add(7);
        assertThat(expect, is(simpleArray));
    }
}
