package ru.job4j.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UserStoreTest {

    @Test
    public void whenAddAndGetNewUserForUserStore() {
        UserStore userStore = new UserStore();
        User userOne = new User("123456", "Паша");
        userStore.add(userOne);
        User result = userStore.findById(userOne.getId());
        assertThat(result.getName(), is(userOne.getName()));
    }

    @Test
    public void addAndGetUserForUserStore() {
        UserStore userStore = new UserStore();
        User userOne = new User("123456", "Паша");
        User userTwo = new User("987654", "Коля");
        userStore.add(userOne);
        userStore.add(userTwo);
        ArrayList<User> result = (ArrayList<User>) userStore.findAll();
        assertThat(result, is(new ArrayList<>(Arrays.asList(userOne, userTwo))));
    }

    @Test
    public void findItemByIdForUserStore() {
        UserStore userStore = new UserStore();
        User userOne = new User("123456", "Паша");
        userStore.add(userOne);
        User result = userStore.findById(userOne.getId());
        assertThat(result, is(userOne));
    }

    @Test
    public void findItemByIncorrectIdForUserStore() {
        UserStore userStore = new UserStore();
        User userOne = new User("123456", "Паша");
        userStore.add(userOne);
        User result = userStore.findById("TEST");
        assertNull(result);
    }

    @Test
    public void whenDeleteForUserStore() {
        UserStore userStore = new UserStore();
        User userOne = new User("123456", "Паша");
        userStore.add(userOne);
        userStore.delete(userOne.getId());
        assertThat(userStore.findById(userOne.getId()), is(nullValue()));
    }

    @Test
    public void whenReplaceForUserStore() {
        UserStore userStore = new UserStore();
        User userOne = new User("123456", "Паша");
        User userTwo = new User("987654", "Коля");
        userStore.add(userOne);
        userStore.replace(userOne.getId(), userTwo);
        assertThat(userStore.findById(userOne.getId()), is(nullValue()));
        assertThat(userStore.findById(userTwo.getId()), is(userTwo));
    }

}
