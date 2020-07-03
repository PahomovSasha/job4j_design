package ru.job4j.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class MemStoreTest {
    @Test
    public void whenAddAndGetNewUserForMemStore() {
        MemStore<User> memStore = new MemStore<>();
        User userOne = new User("123456", "Паша");
        memStore.add(userOne);
        User result = memStore.findById(userOne.getId());
        assertThat(result.getName(), is(userOne.getName()));
    }

    @Test
    public void addAndGetUserForMemStore() {
        MemStore<User> memStore = new MemStore<>();
        User userOne = new User("123456", "Паша");
        User userTwo = new User("987654", "Коля");
        memStore.add(userOne);
        memStore.add(userTwo);
        ArrayList<User> result = (ArrayList<User>) memStore.findAll();
        assertThat(result, is(new ArrayList<>(Arrays.asList(userOne, userTwo))));
    }

    @Test
    public void findItemByIdForMemStore() {
        MemStore<User> memStore = new MemStore<>();
        User userOne = new User("123456", "Паша");
        memStore.add(userOne);
        User result = memStore.findById(userOne.getId());
        assertThat(result, is(userOne));
    }

    @Test
    public void findItemByIncorrectIdForMemStore() {
        MemStore<User> memStore = new MemStore<>();
        User userOne = new User("123456", "Паша");
        memStore.add(userOne);
        User result = memStore.findById("TEST");
        assertNull(result);
    }

    @Test
    public void whenDeleteForMemStore() {
        MemStore<User> memStore = new MemStore<>();
        User userOne = new User("123456", "Паша");
        memStore.add(userOne);
        memStore.delete(userOne.getId());
        assertThat(memStore.findById(userOne.getId()), is(nullValue()));
    }

    @Test
    public void whenReplaceForMemStore() {
        MemStore<User> memStore = new MemStore<>();
        User userOne = new User("123456", "Паша");
        User userTwo = new User("987654", "Коля");
        memStore.add(userOne);
        memStore.replace(userOne.getId(), userTwo);
        assertThat(memStore.findById(userOne.getId()), is(nullValue()));
        assertThat(memStore.findById(userTwo.getId()), is(userTwo));
    }
}
